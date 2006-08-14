set LIB_PATH=lib/ipss_editor.jar;lib/jgraph.jar;lib/jnlp.jar;lib/swing/swing-layout-1.0.jar;lib/apache/commons-math.jar;lib/jraphpad/jibble.jar;lib/jraphpad/lowagie.jar
set DB_PATH=lib/db/ibatis-sqlmap-2.jar;lib/db/ibatis-common-2.jar;lib/db/derby.jar;lib/db/derbyclient.jar;lib/db/derbynet.jar;lib/db/derbytools.jar
set SPRING_PATH=lib/spring/spring.jar
set BATIK_PATH=lib/batik/batik-awt-util.jar;lib/batik/batik-dom.jar;lib/batik/batik-svggen.jar;lib/batik/batik-util.jar
set XML_PATH=lib/xml/xerces.jar;lib/xml/castor-1.0-xml.jar
set CHART_PATH=lib/chart/jfreechart-1.0.0-rc2.jar;lib/chart/jcommon-1.0.0.jar
set RPT_PATH=lib/report/jasperreports.jar;lib/apache/commons-logging.jar;lib/apache/commons-logging-api.jar;lib/apache/commons-digester.jar;lib/apache/commons-collections.jar;lib/apache/commons-beanutils.jar;lib/apache/commons-javaflow.jar;lib/report/jdt-compiler.jar;
set IPSS_PATH=lib/ipss/ipss_pad.jar;lib/ipss/pad_export.jar;lib/ipss/ipss_core.jar;lib/ipss/ipss_dstab.jar;lib/ipss/ipss_dist.jar;lib/ipss/ipss_simu.jar;lib/ipss/ipss_control.jar;lib/ipss/ipss_custom.jar;lib/ipss/ipss_geditor_images.jar;lib/ipss/ipss_common.jar;lib/ipss/ipss_report.jar;lib/ipss/ipss_chart.jar;lib/ipss/ipss_editor_ui.jar;lib/ipss/ipss_editor_simu.jar;lib/ipss/ipss_jgraph.jar;lib/ipss/ipss_psat.jar
set EMF_PATH=lib/eclipse/org.eclipse.emf_2.2.0.jar;lib/eclipse/org.eclipse.emf.ecore_2.2.0.jar;lib/eclipse/org.eclipse.emf.common_2.2.0.jar;
set CUS_PATH=lib/custom/tsinghua.jar;
start java -classpath %LIB_PATH%;%BATIK_PATH%;%RPT_PATH%;%DB_PATH%;%SPRING_PATH%;%XML_PATH%;%CHART_PATH%;%IPSS_PATH%;%EMF_PATH%;%CUS_PATH% -Xms512m -Xmx1024m com.interpss.editor.GEditor