cd /d "%~dp0"
git init
git add *
git commit -a -m "version initiale"
git remote add gitHubOrigin_al_serveurWS https://didier-tp:pwd007!@github.com/didier-tp/al_serveurWs.git
git push -u gitHubOrigin_al_serveurWS master
pause

REM open with text editor
REM opne with system editor