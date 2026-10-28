@echo off
setlocal
cd /d "%~dp0"
chcp 65001 > nul
where javac > nul 2>&1
if errorlevel 1 (
  echo JDK nao encontrado. Instale o JDK 17 e configure o PATH.
  pause
  exit /b 1
)
if not exist "lib\mysql-connector-j-*.jar" (
  echo Coloque o driver MySQL Connector/J em lib antes de continuar.
  pause
  exit /b 1
)
if not exist bin mkdir bin
dir /s /b src\*.java > fontes.txt
javac -encoding UTF-8 -d bin @fontes.txt
del fontes.txt
if errorlevel 1 (
  pause
  exit /b 1
)
java -Dfile.encoding=UTF-8 -cp "bin;lib/*" br.com.livraria.App
pause
