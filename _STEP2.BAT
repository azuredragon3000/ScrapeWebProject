call "step0_1runProject.bat"
call "step1_copy_project.bat"
call "step3_modify_build_test_capture_image.bat"
call "step3_1capture_image.bat"
cd C:\cuong\javaCompile
call "step4_build_release_sign.bat"
cd C:\cuong\javaCompile
call "step5_1update_project_googleconsole.bat"
cd C:\cuong\javaCompile
call "step5_1update_project_bundle.bat"