@echo off
REM
REM set Gridgain installation location
REM
set GRIDGAIN_HOME=C:\Program Files\GridGain-1.6.1

set IPSS_HOME=$INSTALL_PATH
cd %IPSS_HOME%
call bin\setCmdPath.bat
call bin\setEditorPath.bat
call bin\setGridPath.bat
start javaw -Duser.language=en -classpath ipss.jar;%IPSS_CLASSPATH%;%GRIDGAIN_LIBS% -Xms512m -Xmx1024m org.interpss.InterPSS -o Editor -g GridGain

