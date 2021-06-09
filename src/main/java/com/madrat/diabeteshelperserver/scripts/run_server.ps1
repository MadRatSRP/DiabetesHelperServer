$PathDH = 'C:/WebDependencies/Apps/DiabetesHelperServer/'
$PathServer = 'C:/WebDependencies/ApacheTomcat'

$SubWebApps = '/webapps'
$SubBin = '/bin'
$SubWar = 'build/libs'

# 1. Остановка сервера
Set-Location -Path "$PathServer$SubBin/"
./shutdown.sh
"Server stopped!"
# 2. Удаляем старые файл и папку (если есть)
Set-Location -Path "$PathServer$SubWebApps/"
# TODO - упростить проверку наличия папки до 1 команды
if (Test-Path -Path "dh_server") {
    Remove-Item -Recurse -Force "dh_server\*"
    "Old Folder removed!"
}
if (Test-Path -Path "dh_server.war" -PathType Leaf) {
    Remove-Item -Path "dh_server.war"
    "Old File removed!"
}
# 3. Генерируем новые файлы
Set-Location -Path $PathDH
./gradlew clean assemble
"New files generated!"
# 4. Копируем новый варник в webapps
Copy-Item -Path "$PathDH$SubWar/dh_server.war" -Destination "$PathServer$SubWebApps/"
"Was file copied:"
Test-Path -Path "$PathServer$SubWebApps/dh_server.war"
# 5. Включение сервера
Set-Location -Path "$PathServer$SubBin/"
./startup.sh
"Server started!"