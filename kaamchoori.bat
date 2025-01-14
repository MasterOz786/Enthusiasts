@echo off
echo Stopping the server...
taskkill /f /im server64.exe
if %errorlevel% equ 0 (
    echo Server stopped successfully.
) else (
    echo Server was not running.
)
echo Starting the server...
start "" "D:\Re-Flex\server64.exe"
echo Server restarted successfully.