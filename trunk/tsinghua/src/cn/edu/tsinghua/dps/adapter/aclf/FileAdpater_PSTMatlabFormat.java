/*
 * Created on 2006-4-8
 * 
 */
package cn.edu.tsinghua.dps.adapter.aclf;
   
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;

import org.apache.commons.math.complex.Complex;

import com.interpss.common.datatype.Constants;
import com.interpss.common.datatype.UnitType;
import com.interpss.common.exp.InvalidInputException;
import com.interpss.common.exp.InvalidOperationException;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfBranch;
import com.interpss.core.aclf.AclfBranchCode;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfGenCode;
import com.interpss.core.aclf.AclfLoadCode;
import com.interpss.core.aclf.LineAdapter;
import com.interpss.core.aclf.LoadBusAdapter;
import com.interpss.core.aclf.PQBusAdapter;
import com.interpss.core.aclf.PVBusAdapter;
import com.interpss.core.aclf.SwingBusAdapter;
import com.interpss.core.aclf.XfrAdapter;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;
import com.interpss.simu.io.IpssFileAdapterBase;
  
/**
 * @author chenying class FileAdpater_PSTMatlabFormat
 *         ******************************************************* This file
 *         FileAdpater_PSTMatlabFormat.java is part of package custom.input
 * created at 2006-4-8 for ipss.custom All right @ dps.tsinghua.edu.cn
 *         ******************************************************* Change record
 *         4/8/06 Mike Zhou - change package name to
 *         cn.edu.tsinghua.dps.adapter.aclf - SeesionMsg changed to IPSSMsgHub -
 *         Changed Exception handling approach
 *
 *         5/22/06 Mike Zhou - packaged into tsinghua.jar and integrated into
 *         GEditor 0.6.02 
 *  
 */
public class FileAdpater_PSTMatlabFormat extends IpssFileAdapterBase {

    private static final int BusData = 1;

    /**
     * Load the data in the data file, specified by the filepath, into the
     * SimuContext object. An AclfAdjNetwork object will be created to hold the
     * data for loadflow analysis.
     * 
     * @param simuCtx
     *            the SimuContext object
     * @param filepath
     *            full path path of the input file
     * @param msg
     *            the SessionMsg object
     */
    public void load(SimuContext simuCtx, String filepath, IPSSMsgHub msg)
            throws Exception {
        File file = new File(filepath);
        InputStream stream = new FileInputStream(file);
        BufferedReader din = new BufferedReader(new InputStreamReader(stream));

        AclfAdjNetwork adjNet = loadFile(din, msg);
        IpssLogger.getLogger().fine(adjNet.net2String());

        simuCtx.setNetType(SimuCtxType.ACLF_ADJ_NETWORK);
        simuCtx.setAclfAdjNet(adjNet);
        simuCtx.setName(filepath.substring(filepath
                .lastIndexOf(File.separatorChar) + 1));
        simuCtx.setDesc("This project is created by input file " + filepath);
    }

    /**
     * Create a SimuContext object and Load the data in the data file, specified
     * by the filepath, into the object. An AclfAdjNetwork object will be
     * created to hold the data for loadflow analysis.
     * 
     * @param filepath
     *            full path path of the input file
     * @param msg
     *            the SessionMsg object
     * @return the created SimuContext object.
     */
    public SimuContext load(String filepath, IPSSMsgHub msg) throws Exception {
        SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(
                SimuCtxType.NOT_DEFINED, msg);
        load(simuCtx, filepath, msg);
        return simuCtx;
    }

    /**
     * This method is currently not implemented, since the loadflow results are
     * not going to write back to a data file.
     */
    public boolean save(String filepath, SimuContext net, IPSSMsgHub msg)
            throws Exception {
        throw new InvalidOperationException(
                "FileAdapter_IeeeCommonFormat.save not implemented");
    }

    private static AclfAdjNetwork loadFile(java.io.BufferedReader din,
            IPSSMsgHub msg) throws Exception {
        AclfAdjNetwork adjNet = CoreObjectFactory.createAclfAdjNetwork();
        adjNet.setAllowParallelBranch(true);

        String str = din.readLine();
        while (str.indexOf('%') < 0) {
            str = din.readLine();
        }
        IpssLogger.getLogger().fine(str);
        processNetData(str, adjNet);

        int dataType = 0;
        do {
            str = din.readLine(); //kvaBase
            IpssLogger.getLogger().fine(str);
            if (str != null) {
                try {
                    // process the data
                    if (str.startsWith("%")) {
                        dataType = 0;
                    } else if (str.length() > 3
                            && str.substring(0, 3).equals("bus")) {
                        dataType = BusData;
                        IpssLogger.getLogger().info("load bus data");
                        processBusData(str, din, adjNet);
                    } else if (str.length() > 4
                            && str.substring(0, 4).equals("line")) {
                        dataType = BusData;
                        IpssLogger.getLogger().info("load bus data");
                        processBranchData(str, din, adjNet, msg);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    msg.sendErrorMsg(e.toString());
                    msg.sendErrorMsg("Error Line: " + str);
                }
            }
        } while (str != null);

        return adjNet;
    }

    /*
     * Network data ============
     */

    private static void processNetData(String str, AclfAdjNetwork adjNet) {
        // parse the input data line
        String caseName = "";
        if (str.indexOf('%') >= 0) {
            caseName = str.substring(str.indexOf('%'));
        }

        // set the input data to the network container
        adjNet.setId(caseName);
        adjNet.setDesc("Aclf case created from an PST Matlab Format file.\n"
                + str);
        adjNet.setBaseKva(100 * 1000.0);
    }

    /*
     * Bus data ========
     */

    private static void processBusData(String str, java.io.BufferedReader din,
            AclfAdjNetwork net) throws Exception {
        int nBus = 0;
        String busDataLine;
        //process the first line of bus data
        int linStart = str.indexOf('[');
        int linEnd = str.indexOf(';');
        if (linStart >= 0 && linEnd >= 0) {
            busDataLine = str.substring(linStart + 1, linEnd).trim();
            String[] strAry = getDataFields(busDataLine);
            createBusFromStrLine(strAry, net);
            nBus++;
        }
        str = din.readLine().trim();
        //process mid content line
        while (str != null && str.indexOf(']') < 0) {
            linEnd = str.indexOf(';');
            if (linEnd < 0) {
                linEnd = str.length();
            }
            busDataLine = str.substring(0, linEnd);
            createBusFromStrLine(getDataFields(busDataLine), net);
            nBus++;
            str = din.readLine().trim();
        }
        linEnd = str.indexOf(']');
        if (linEnd > 0) {
            int linEnd2 = str.indexOf(';');
            if (linEnd2 < linEnd)
                linEnd = linEnd2;
            busDataLine = str.substring(0, linEnd);
            createBusFromStrLine(getDataFields(busDataLine), net);
            nBus++;
        }
    }

    private static AclfBus createBusFromStrLine(String[] strAry,
            AclfAdjNetwork net) throws Exception {
        String busId = strAry[0];
        IpssLogger.getLogger().fine("Bus data loaded, id: " + busId);
        String busName = "bus" + busId;
        double vpu = new Double(strAry[1]).doubleValue();
        double angDeg = new Double(strAry[2]).doubleValue();
        double genP = new Double(strAry[3]).doubleValue();
        double genQ = new Double(strAry[4]).doubleValue();
        double loadP = new Double(strAry[5]).doubleValue();
        double loadQ = new Double(strAry[6]).doubleValue();
        double gPU = new Double(strAry[7]).doubleValue();
        double bPU = new Double(strAry[8]).doubleValue();
        int type = new Integer(strAry[9]).intValue();

        // create an AclfBus object
        AclfBus bus = CoreObjectFactory.createAclfBus(busId, 1, 1, "1", net);
        bus.setName(busName);
        bus.setBaseVoltage(100, UnitType.kV);
        bus.setVoltage(vpu, angDeg * Constants.DtoR);
        bus.setShuntY(new Complex(gPU, bPU));

        // add the bus object into the network container
        net.addBus(bus);

        // set input data to the bus object
        if (type == 1) {
            // Swing bus
            bus.setGenCode(AclfGenCode.SWING);
            bus.setLoadCode(AclfLoadCode.CONST_P);
            SwingBusAdapter gen = (SwingBusAdapter) bus
                    .adapt(SwingBusAdapter.class);
            gen.setVoltMag(vpu, UnitType.PU);
            gen.setVoltAng(angDeg, UnitType.Deg);
            gen.setLoad(new Complex(loadP, loadQ), UnitType.PU, net
                    .getBaseKva());
        } else if (type == 3) {
            // PQ bus
            bus.setGenCode(AclfGenCode.GEN_PQ);
            bus.setLoadCode(AclfLoadCode.CONST_P);
            if (Math.abs(genP) > 1e-4 || Math.abs(genQ) > 1e-4) {
                PQBusAdapter gen = (PQBusAdapter) bus.adapt(PQBusAdapter.class);
                gen.setGen(new Complex(genP, genQ), UnitType.PU, net
                        .getBaseKva());
                gen.setLoad(new Complex(loadP, loadQ), UnitType.PU, net
                        .getBaseKva());
            } else if (Math.abs(loadP) > 1e-4 || Math.abs(loadQ) > 1e-4) {
                LoadBusAdapter load = (LoadBusAdapter) bus
                        .adapt(LoadBusAdapter.class);
                load.setLoad(new Complex(loadP, loadQ), UnitType.PU, net
                        .getBaseKva());
            }
        } else if (type == 2) {
            // PV or remote Q bus
            bus.setGenCode(AclfGenCode.GEN_PV);
            bus.setLoadCode(AclfLoadCode.CONST_P);
            PVBusAdapter gen = (PVBusAdapter) bus.adapt(PVBusAdapter.class);
            gen.setGenP(genP, UnitType.PU, net.getBaseKva());
            gen.setVoltMag(vpu, UnitType.PU);
            gen.setLoad(new Complex(loadP, loadQ), UnitType.PU, net
                    .getBaseKva());

        }
        return bus;
    }

   
    /*
     * Branch data ===========
     */

    private static void processBranchData(String str,
            java.io.BufferedReader din, AclfAdjNetwork net, IPSSMsgHub msg)
            throws Exception {
        try {
            int nBranch = 0;
            String branchDataLine;
            //process the first line of bus data
            int linStart = str.indexOf('[');
            int linEnd = str.indexOf(';');
            if (linStart >= 0 && linEnd >= 0) {
                branchDataLine = str.substring(linStart + 1, linEnd).trim();
                createBranchFromStrLine(getDataFields(branchDataLine),
                        net, msg);
                nBranch++;
            }
            str = din.readLine().trim();
            //process mid content line
            while (str != null && str.indexOf(']') < 0) {
                linEnd = str.indexOf(';');
                if (linEnd < 0) {
                    linEnd = str.length();
                }
                branchDataLine = str.substring(0, linEnd);
                createBranchFromStrLine(getDataFields(branchDataLine), net,
                        msg);
                nBranch++;
                str = din.readLine().trim();
            }
            linEnd = str.indexOf(']');
            if (linEnd > 0) {
                linEnd = str.indexOf(';');
                branchDataLine = str.substring(0, linEnd);
                createBranchFromStrLine(getDataFields(branchDataLine), net,
                        msg);
                nBranch++;
            }
        } catch (Exception e) {
            IpssLogger.logErr(e);
            throw new InvalidInputException("" + e.toString());
        }
    }

    
    

    private static void createBranchFromStrLine(String[] strAry,
            AclfAdjNetwork net, IPSSMsgHub msg) {
        String fid = strAry[0];
        String tid = strAry[1];
        IpssLogger.getLogger().fine(
                "Branch data loaded, from-id, to-id: " + fid + ", " + tid);

        double rpu = new Double(strAry[2]).doubleValue();
        double xpu = new Double(strAry[3]).doubleValue();
        double bpu = new Double(strAry[4]).doubleValue();
        double ratio = new Double(strAry[5]).doubleValue();
        int type = 0;
        if (Math.abs(ratio - 1) > 1e-3)
            type = 1;

        // create an AclfBranch object
        AclfBranch bra = CoreObjectFactory.createAclfBranch(1, 1, "1", net);

        // add the object into the network container
        net.addBranch(bra, fid, tid);

        if (type == 0) {
            // A line branch
            bra.setBranchCode(AclfBranchCode.LINE);
            LineAdapter line = (LineAdapter) bra.adapt(LineAdapter.class);
            line.getAclfBranch().setZ(new Complex(rpu, xpu), msg);
            line.setHShuntY(new Complex(0.0, 0.5 * bpu), UnitType.PU, 1.0, net
                    .getBaseKva()); // Unit is PU, no need to enter baseV
        } else if (type == 1) {
            // Transformer branch
            bra.setBranchCode(AclfBranchCode.XFORMER);
            XfrAdapter xfr = (XfrAdapter) bra.adapt(XfrAdapter.class);
            xfr.getAclfBranch().setZ(new Complex(rpu, xpu), msg);
            xfr.setFromTurnRatio(ratio, UnitType.PU);
            xfr.setToTurnRatio(1.0, UnitType.PU);
        }
    }
    
    private static String[] getDataFields(String str) {
        Vector strVec = new Vector();
 
        StringTokenizer st = new StringTokenizer(str, " ");
        int cnt = 0;
        while (st.hasMoreTokens()) {
            String tmpStr = st.nextToken().trim();
            if (tmpStr.indexOf(',') >= 0) {
                StringTokenizer tmpSt = new StringTokenizer(str, ",");
                while (tmpSt.hasMoreTokens())
                    strVec.add(tmpSt.nextToken().trim());
            } else if (tmpStr.indexOf('\t') >= 0) {
                StringTokenizer tmpSt = new StringTokenizer(str, "	");
                while (tmpSt.hasMoreTokens())
                    strVec.add(tmpSt.nextToken().trim());
            } else {
                strVec.add(tmpStr);
            }
        }
        String[] strArr = new String [strVec.size()];
        for (int i = 0 ; i < strVec.size(); i ++){
            strArr[i] = (String)strVec.get(i);
        }
        return strArr;
    }
    
}
