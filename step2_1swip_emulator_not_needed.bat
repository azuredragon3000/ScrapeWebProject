@echo on 
echo CLEAN EMULATOR 
set DIR=C:\Users\Huy Cuong\AppData\Local\Android\Sdk\emulator 
cd %DIR% 
cmd /k emulator -avd Pixel_2_API_30 -wipe-data 
