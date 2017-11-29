cd /d %~dp0
REM set MVN_REPOSITORY=C:\ext\mvn-repository
set MVN_REPOSITORY=C:\Users\formation\.m2\repository

set MY_H2_DB_URL=jdbc:h2:~/devise_db

set H2_VERSION=1.4.196
set H2_CLASSPATH=%MVN_REPOSITORY%\com\h2database\h2\%H2_VERSION%\h2-%H2_VERSION%.jar

java -jar  %H2_CLASSPATH% -user "sa" -url %MY_H2_DB_URL%

REM url=http://localhost:8082

REM NB: penser à se déconnecter
REM    et options/session actives/arrêt pour éviter des futurs verrous/blocages

pause