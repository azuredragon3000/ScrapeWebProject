@ECHO ON 
echo CREATE JKS 
keytool -genkey -v -keystore C:\cuong\javaCompile\key\ca-app-pub-8404443559572571/8642405566 -alias key0 -keyalg RSA -keysize 2048 -validity 10000 
