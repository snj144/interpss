@echo off
set CLASSPATH=lib\commons-math.jar
set CLASSPATH=%CLASSPATH%;lib\org.eclipse.emf.common.jar
set CLASSPATH=%CLASSPATH%;lib\org.eclipse.emf.ecore.jar
set CLASSPATH=%CLASSPATH%;lib\org.eclipse.emf.ecore.xmi.jar
set CLASSPATH=%CLASSPATH%;lib\org.eclipse.emf.jar
set CLASSPATH=%CLASSPATH%;lib\spring.jar
set CLASSPATH=%CLASSPATH%;lib\xbean.ja

set CLASSPATH=%CLASSPATH%;lib\ieee.odm_pss.jar
set CLASSPATH=%CLASSPATH%;lib\ieee.odm_pss.schemas.jar

set CLASSPATH=%CLASSPATH%;lib\ipss_core.jar
set CLASSPATH=%CLASSPATH%;lib\ipss_plugin.jar
set CLASSPATH=%CLASSPATH%;lib\ipss_pssl.jar

C:\eclipse\jython2.2.1\jython.bat

