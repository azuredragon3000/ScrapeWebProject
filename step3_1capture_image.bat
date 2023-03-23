echo CREATE IMAGE CAPTURE AND COPY THEM 
cd "C:\Users\Huy Cuong\AppData\Local\Android\Sdk\platform-tools>"
adb shell am force-stop com.myapp.app300
ping localhost -n 5 >nul && :: will wait 5 seconds before going next command (it will not display)

adb shell am start -n com.myapp.app300/com.myapp.app300.HomeActivity
ping localhost -n 15 >nul && :: will wait 10 seconds before going next command (it will not display)
adb shell screencap -p /sdcard/screencap.png && adb pull /sdcard/screencap.png
ping localhost -n 5 >nul && :: will wait 5 seconds before going next command (it will not display)
adb pull sdcard/screencap.png
copy screencap.png C:\cuong\javaCompile\dest_app300\capture1.png


adb shell am start -n com.myapp.app300/com.myapp.app300.HomeActivity
ping localhost -n 15 >nul && :: will wait 10 seconds before going next command (it will not display)
adb shell screencap -p /sdcard/screencap.png && adb pull /sdcard/screencap.png
ping localhost -n 5 >nul && :: will wait 5 seconds before going next command (it will not display)
adb pull sdcard/screencap.png
copy screencap.png C:\cuong\javaCompile\dest_app300\capture1.png


adb shell am start -n com.myapp.app300/com.myapp.app300.ContentActivity
ping localhost -n 10 >nul && :: will wait 10 seconds before going next command (it will not display)
adb shell screencap -p /sdcard/screencap.png && adb pull /sdcard/screencap.png
ping localhost -n 5 >nul && :: will wait 5 seconds before going next command (it will not display)
adb pull sdcard/screencap.png
copy screencap.png C:\cuong\javaCompile\dest_app300\capture2.png


adb shell am start -n com.myapp.app300/com.myapp.app300.ContentActivity2
ping localhost -n 10 >nul && :: will wait 10 seconds before going next command (it will not display)
adb shell screencap -p /sdcard/screencap.png && adb pull /sdcard/screencap.png
ping localhost -n 5 >nul && :: will wait 5 seconds before going next command (it will not display)
adb pull sdcard/screencap.png
copy screencap.png C:\cuong\javaCompile\dest_app300\capture3.png

adb shell am start -n com.myapp.app300/com.myapp.app300.ContentActivity3
ping localhost -n 10 >nul && :: will wait 10 seconds before going next command (it will not display)
adb shell screencap -p /sdcard/screencap.png && adb pull /sdcard/screencap.png
ping localhost -n 5 >nul && :: will wait 5 seconds before going next command (it will not display)
adb pull sdcard/screencap.png
copy screencap.png C:\cuong\javaCompile\dest_app300\capture4.png
