@echo off
:: Disable Ctrl+C
break off

echo Building project...
call mvn package

if %ERRORLEVEL% NEQ 0 (
    echo Build failed!
    pause
    exit /b %ERRORLEVEL%
)

echo Finding JAR file...
for /r "target" %%i in (*.jar) do (
    set "JAR_FILE=%%i"
    goto :found_jar
)

:found_jar
if not defined JAR_FILE (
    echo No JAR file found in target directory!
    pause
    exit /b 1
)

echo Found JAR: %JAR_FILE%

cd ..
if not exist "minecraftdevserver" (
    echo minecraftdevserver folder not found!
    pause
    exit /b 1
)

cd minecraftdevserver
if not exist "plugins" (
    echo Creating plugins directory...
    mkdir plugins
)

echo Moving JAR to plugins folder...
move "%JAR_FILE%" "plugins\"

echo Starting Minecraft server...
call start.bat 