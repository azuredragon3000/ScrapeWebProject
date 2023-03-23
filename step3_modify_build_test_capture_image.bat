@ECHO ON 
echo BUILD DEBUG && cd "dest_app300" && call .\gradlew assembleDebug && cd "C:\Users\Huy Cuong\appData\Local\Android\Sdk\platform-tools" && adb install "C:\cuong\javaCompile\dest_app300\app\build\outputs\apk\debug\app-debug.apk"&& cd "C:\cuong\javaCompile" 
