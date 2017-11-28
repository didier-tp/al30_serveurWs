cd /d "%~dp0"
git add *
git commit -a -m "nouvelle version"
git push -u gitHubOrigin_al_serveurWS master
pause

REM open with text editor
REM opne with system editor