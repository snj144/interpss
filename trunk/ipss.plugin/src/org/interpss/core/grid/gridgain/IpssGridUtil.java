package org.interpss.core.grid.gridgain;

import org.gridgain.grid.Grid;
import org.gridgain.grid.GridException;
import org.gridgain.grid.GridFactory;

import com.interpss.common.util.IpssLogger;

public class IpssGridUtil {
    public static void performGridTask(String desc, String model) throws GridException {
        GridFactory.start();
        try {
            Grid grid = GridFactory.getGrid();
            IpssLogger.getLogger().info("Begin to excute IpssGridTask " + desc + " ...");
            String str = (String)grid.execute(IpssGridTask.class.getName(), model).get();
            IpssLogger.getLogger().info("End to excute IpssGridTask " + desc );

            IpssLogger.getLogger().info("Result - " + str );
        }
        finally {
            GridFactory.stop(true);
        }
    }
}
