@echo off
set IPSS_HOME=$INSTALL_PATH
cd %IPSS_HOME%
start javaw -Duser.language=en -Xms512m -Xmx1024m -jar ipss.jar -o Editor

