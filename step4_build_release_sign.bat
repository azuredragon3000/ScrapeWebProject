@ECHO ON 
echo BUILD RELEASE && cd "dest_app300" && call .\gradlew bundleRelease && cd "C:\Program Files\Java\jdk-11.0.13\bin" && jarsigner -keystore "C:\cuong\javaCompile\key\app300_cuong.jks" "C:\cuong\javaCompile\dest_app300\app\build\outputs\bundle\release\app-release.aab" key0  -storepass "cuongcuong " -keypass "cuongcuong "&& echo passed || echo failed 
