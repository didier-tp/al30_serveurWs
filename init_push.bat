cd /d "%~dp0"
git init
git add *
git commit -a -m "version initiale"
git remote add gitHubOrigin_al30_serveurWs https://didier-tp:....!@github.com/didier-tp/al30_serveurWs.git
git push -u gitHubOrigin_al30_serveurWs master
pause

REM open with text editor
REM opne with system editor