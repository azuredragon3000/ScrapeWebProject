
import java.util.Arrays;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import javax.imageio.ImageIO;

import java.io.IOException;
import java.nio.file.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.stream.*;
import java.io.FileWriter;
import java.io.Writer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;

class UpdateAndroidProject {
    public static void main(String[] args) throws FileNotFoundException,IOException 
	{
        System.out.println(Arrays.toString(args));
		
		ArrayList<String> iPara = ReadFile("python\\inputFile.txt");
		String[] para = iPara.get(0).split(" ");
		System.out.println(Arrays.toString(para)+"size para: "+ para.length + "last para: "+para[8]);
		// check if key is not exist then create new key
		String iKey = para[7];
		String cwd = Path.of("").toAbsolutePath().toString();
		String pKey = cwd+"\\key\\"+iKey;
		File fKey = new File(pKey);
		if(fKey.exists()){
			System.out.println("Exist");
		}else{
			System.out.println("Not Exist");
			// create file
			createFile(para,"create_jks.bat");
			
		}
		
		createFile(para,"step1_copy_project.bat");
		createFile(para,"step2_open_emulator.bat");
		createFile(para,"step2_1swip_emulator_not_needed.bat");
		createFile(para,"step3_modify_build_test_capture_image.bat");
		createFile(para,"step3_1capture_image.bat");
		createFile(para,"step4_build_release_sign.bat");
		createFile(para,"step5_update_project_github.bat");
		createFile(para,"step5_1update_project_bundle.bat");
		createFile(para,"step5_1update_project_googleconsole.bat");
		
		if(args[0].equals("No"))
		{
			System.out.println("initializing time ");
			if(fKey.exists()){
				
			}else{
				// run file
				Runtime.
					getRuntime().
					exec("cmd /c start "+cwd+"\\runCreateJks.bat");
			}
		}
		else
		{
			String iconImage = "";
			String replaceImage = "";
			String targetImage = "";
			System.out.println("debug: "+para[8]);
			// copy file from source to update
		
			//copyFileImage(cwd+"\\update\\"+replaceImage+".png",cwd+"\\"+args[1]+"\\app\\src\\main\\res\\drawable\\"+targetImage+".png");
			File folder = new File("C:\\cuong\\image\\"+para[3]);
			File[] listOfFiles = folder.listFiles();
			for(int i =0;i<listOfFiles.length;i++)
			{
				copyFileImage("C:\\cuong\\image\\"+para[3]+"\\"+listOfFiles[i].getName(),cwd+"\\update\\"+listOfFiles[i].getName());
				
			}
			try{
				
				iconImage = para[8].split("-")[0];
				replaceImage = para[8].split("-")[1];
				targetImage = para[8].split("-")[2];
				System.out.println("debug: "+iconImage+" "+replaceImage);
			}catch(Exception e){
				iconImage = para[8];
			}
			System.out.println(cwd+"\\update\\"+iconImage+".png");
			resizeImage(cwd+"\\update\\"+iconImage+".png",iconImage);
		
			copyAndReplaceTextProject(args[0],args[1],args[2],args[3],args[4],args[5],args[6],args[7]);	
			
			System.out.println("Debug: "+para[0]+" "+para[1]+" "+para[2]+" ");
			// check if project copy is truyenphatgiao,truyentinhyeu,truyenthienchua,hatgiongtamhon
			if(	para[0].equals("truyenphatgiao") 	||
				para[0].equals("truyentinhyeu")		||
				para[0].equals("truyenthienchua")	||
				para[0].equals("hatgiongtamhon")	
			){
				// open file manifest and modify it
				String manifestFile = cwd+"\\"+para[1]+"\\app\\src\\main\\AndroidManifest.xml";
				WriteToFile2(manifestFile,ReadFile(manifestFile),"manifest");
				
				
				// copy file file content - use for loop 4
				// truyentinhyeu - 25 random
				// truyenphatgiao - 100 random
				// truyenthienchua - 100 random
				// hatgiongtamhon - 100 random
				String contentFile = cwd+"\\"+para[1]+"\\app\\src\\main\\java\\com\\myapp\\"+para[3]+"\\ContentActivity.java"; 
				String contentFile1= cwd+"\\"+para[1]+"\\app\\src\\main\\java\\com\\myapp\\"+para[3]+"\\ContentActivity2.java";
				String contentFile2= cwd+"\\"+para[1]+"\\app\\src\\main\\java\\com\\myapp\\"+para[3]+"\\ContentActivity3.java";
				
				copyFileJava(contentFile,contentFile1);
				copyFileJava(contentFile,contentFile2);
				WriteToFile2(contentFile1,ReadFile(contentFile1),"ContentActivity2");
				WriteToFile2(contentFile2,ReadFile(contentFile2),"ContentActivity3");
				
				
				// copy file image
				copyFileImage(cwd+"\\update\\"+iconImage+"512.png",cwd+"\\"+args[1]+"\\app\\src\\main\\ic_launcher-playstore.png");
				copyFileImage(cwd+"\\update\\"+iconImage+"72.png",cwd+"\\"+args[1]+"\\app\\src\\main\\res\\mipmap-hdpi\\ic_launcher.png");
				copyFileImage(cwd+"\\update\\"+iconImage+"162.png",cwd+"\\"+args[1]+"\\app\\src\\main\\res\\mipmap-hdpi\\ic_launcher_foreground.png");
				copyFileImage(cwd+"\\update\\"+iconImage+"72.png",cwd+"\\"+args[1]+"\\app\\src\\main\\res\\mipmap-hdpi\\ic_launcher_round.png");
				copyFileImage(cwd+"\\update\\"+iconImage+"48.png",cwd+"\\"+args[1]+"\\app\\src\\main\\res\\mipmap-mdpi\\ic_launcher.png");
				copyFileImage(cwd+"\\update\\"+iconImage+"108.png",cwd+"\\"+args[1]+"\\app\\src\\main\\res\\mipmap-mdpi\\ic_launcher_foreground.png");
				copyFileImage(cwd+"\\update\\"+iconImage+"48.png",cwd+"\\"+args[1]+"\\app\\src\\main\\res\\mipmap-mdpi\\ic_launcher_round.png");
				copyFileImage(cwd+"\\update\\"+iconImage+"96.png",cwd+"\\"+args[1]+"\\app\\src\\main\\res\\mipmap-xhdpi\\ic_launcher.png");
				copyFileImage(cwd+"\\update\\"+iconImage+"216.png",cwd+"\\"+args[1]+"\\app\\src\\main\\res\\mipmap-xhdpi\\ic_launcher_foreground.png");
				copyFileImage(cwd+"\\update\\"+iconImage+"96.png",cwd+"\\"+args[1]+"\\app\\src\\main\\res\\mipmap-xhdpi\\ic_launcher_round.png");
				copyFileImage(cwd+"\\update\\"+iconImage+"144.png",cwd+"\\"+args[1]+"\\app\\src\\main\\res\\mipmap-xxhdpi\\ic_launcher.png");
				copyFileImage(cwd+"\\update\\"+iconImage+"324.png",cwd+"\\"+args[1]+"\\app\\src\\main\\res\\mipmap-xxhdpi\\ic_launcher_foreground.png");
				copyFileImage(cwd+"\\update\\"+iconImage+"144.png",cwd+"\\"+args[1]+"\\app\\src\\main\\res\\mipmap-xxhdpi\\ic_launcher_round.png");
				copyFileImage(cwd+"\\update\\"+iconImage+"192.png",cwd+"\\"+args[1]+"\\app\\src\\main\\res\\mipmap-xxxhdpi\\ic_launcher.png");
				copyFileImage(cwd+"\\update\\"+iconImage+"432.png",cwd+"\\"+args[1]+"\\app\\src\\main\\res\\mipmap-xxxhdpi\\ic_launcher_foreground.png");
				copyFileImage(cwd+"\\update\\"+iconImage+"192.png",cwd+"\\"+args[1]+"\\app\\src\\main\\res\\mipmap-xxxhdpi\\ic_launcher_round.png");
			
				copyFileImage(cwd+"\\update\\"+replaceImage+".png",cwd+"\\"+args[1]+"\\app\\src\\main\\res\\drawable\\"+targetImage+".png");
				
				
			}else{
				System.out.println("Debug: need check");
			}
		}
    }
	public static void copyFileImage(String from,String to){
		Path sourceDirectory = Paths.get(from);
        Path targetDirectory = Paths.get(to);

        //copy source to target using Files Class
        try {
            Files.copy(sourceDirectory, targetDirectory,StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
	}
	public static void copyFileJava(String from,String to){
		Path sourceDirectory = Paths.get(from);
        Path targetDirectory = Paths.get(to);

        //copy source to target using Files Class
        try {
            Files.copy(sourceDirectory, targetDirectory,StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
	}
	public static void resizeImage(String image,String arg8)throws IOException{
		BufferedImage bg = ImageIO.read(new File(image));

		ImageIO.write(resizeImageSpecific(bg,512,512),"png",new File("update\\"+arg8+"512.png"));
		ImageIO.write(resizeImageSpecific(bg,100,100),"png",new File("update\\"+arg8+"72.png")); // 72 but so small
		ImageIO.write(resizeImageSpecific(bg,162,162),"png",new File("update\\"+arg8+"162.png"));
		ImageIO.write(resizeImageSpecific(bg,100,100),"png",new File("update\\"+arg8+"48.png")); // 48 but so small
		ImageIO.write(resizeImageSpecific(bg,108,108),"png",new File("update\\"+arg8+"108.png"));
		ImageIO.write(resizeImageSpecific(bg,96,96),"png",new File("update\\"+arg8+"96.png"));
		ImageIO.write(resizeImageSpecific(bg,216,216),"png",new File("update\\"+arg8+"216.png"));
		ImageIO.write(resizeImageSpecific(bg,144,144),"png",new File("update\\"+arg8+"144.png"));
		ImageIO.write(resizeImageSpecific(bg,324,324),"png",new File("update\\"+arg8+"324.png"));
		ImageIO.write(resizeImageSpecific(bg,192,192),"png",new File("update\\"+arg8+"192.png"));
		ImageIO.write(resizeImageSpecific(bg,432,432),"png",new File("update\\"+arg8+"432.png"));
	}
	
	public static BufferedImage resizeImageSpecific(BufferedImage originalImage,int targetWidth,int targetHeight) throws IOException {
		
		BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_ARGB);
		Graphics2D graphics2D = resizedImage.createGraphics();
		graphics2D.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
		graphics2D.dispose();
		
		return resizedImage;
	}
	
	public static boolean isStringNull(String str)
    {
        if (str == null)
            return true;
        else
            return false;
    }
	public static boolean checkInputArg(String[] args)
    {
		for(int i=0;i<args.length;i++){
			if(isStringNull(args[i])){
				return false;
			}
		}
		
		return true;
    }
	public static void copyAndReplaceTextProject(String path,String dest,String pk1,String pk2,String delete,String code,String adsAppId,String unitAdsId) throws IOException
	{	
		// create folder for destination
		File pDest = new File(dest);
		if(pDest.exists())
		{
			System.out.println("Exist dest folder- delete dest folder");
			if(delete.equals("Yes"))
			{
				deleteDir(pDest);
			}
		}
		else
		{
			System.out.println("Not Exist dest folder - process next");
		}
		if(pDest.mkdir())
		{
			System.out.println("created new dest folder for copying");
			copyDir(path,dest,true);
		}
		else
		{
			System.out.println("cant created because error ");
		}
		
		// find text and replace
		System.out.println("find text and replace");
		findTextAndReplace(dest,pk1,pk2,code,adsAppId,unitAdsId);
		
		// find folder and rename it
		System.out.println("find folder and rename it");
		findFolderAndReplace(dest,pk1,pk2);
	}
	
	private static String getFileExtension(String file)
	{
		int lastIndexOf = file.lastIndexOf(".");
		if(lastIndexOf == -1)
		{
			return "";
		}
		
		return file.substring(lastIndexOf);
	}
	
	private static void copyDir(String src, String dest, boolean overwrite) 
	{
        try {
            Files.walk(Paths.get(src)).forEach(a -> 
			{
                Path b = Paths.get(dest, a.toString().substring(src.length()));
                try 
				{
                    if (!a.toString().equals(src))
                        Files.copy(a, b, overwrite ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[]{});
                } catch (IOException e) {
                    e.printStackTrace();
                }
				
            });
			System.out.println("copied from " + src +" to "+dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public static void findAndReplaceRegex(String file, String regex,String code,String iFile)throws IOException
	{
		WriteToFile(file,ReadFile(file),regex,code,iFile);
	}
	
	public static void WriteToFile2(String sfile,ArrayList<String> data,String process) throws IOException 
	{
		File file = new File(sfile);
		FileWriter myWriter = null;
        
		if(!file.exists()) 
		{
            return;
        }
		else
		{
            myWriter = new FileWriter(sfile,false);
        }
		try
		{
			for(String idata: data)
			{
				if(process.equals("manifest"))
				{
					if(idata.contains("android:exported=\"false\""))
					{
						idata = "            android:exported=\"true\" />";
					}
					else if(idata.contains("<meta-data"))
					{
						idata = 
						"<activity\n"+
						"	android:name=\".ContentActivity2\"\n"+
						"	android:theme=\"@style/Theme.MaterialComponents.Light.NoActionBar\"\n"+
						"	android:exported=\"true\" />\n"+
						"\n"+
						"<activity\n"+
						"	android:name=\".ContentActivity3\"\n"+
						"	android:theme=\"@style/Theme.MaterialComponents.Light.NoActionBar\"\n"+
						"	android:exported=\"true\" />\n"+
						"\n"+
						"        <meta-data";
					}
					
				}
				else if(process.contains("ContentActivity"))
				{
					if(idata.contains("ContentActivity"))
					{
						idata = idata.replace("ContentActivity", process);
					}
					else if(idata.contains("getIntent().getIntExtra"))
					{
						idata = "";
					}
					else if(idata.contains("position+1"))
					{
						idata = "int position = (int)(Math.random() * (25 - 0 + 1)) + 0;";
					}
					
				}
				else
				{
					System.out.println("Debug not found type");
				}
				myWriter.write(idata+"\n");
			}
			myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } 
		catch (IOException e) 
		{
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
		
	}
	public static void WriteToFile(String sfile, ArrayList<String> data,String regex,String code,String iFile) throws IOException 
	{
        File file = new File(sfile);
		FileWriter myWriter = null;
        
		if(!file.exists()) 
		{
            return;
        }
		else
		{
            myWriter = new FileWriter(sfile,false);
        }
        try 
		{
            for(String idata: data)
			{
				if(iFile.equals("gradle1"))
				{
					if(getGroup(idata,regex))
					{
						idata = "        versionCode "+code;
					}
				}
				else if(iFile.equals("cfile"))
				{
					if(getGroup(idata,regex))
					{
						idata = "        adsInterstitial = new AdsInterstitial(\"07CC7E40850ABA2DF210A2D2564CAD76\",\""+code+"\",this);";
					}
				}
				else if(iFile.equals("gradle2"))
				{
					if(getGroup(idata,regex))
					{
						idata = "        versionName "+code;
					}
				}
				else if(iFile.equals("manifest1"))
				{
					
					if(getGroup(idata,regex))
					{
						System.out.println("Cuong: "+code + " "+ regex);
						idata = "            android:value=\""+code+"\" />";
					}
				}
				else if(iFile.equals("manifest2"))
				{
					if(getGroup(idata,regex))
					{
						idata = "    package=\"com.myapp."+code+"\">";
					}
				}
				myWriter.write(idata+"\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) 
		{
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
	
	public static ArrayList<String> ReadFile(String sfile) throws IOException 
	{    
        ArrayList<String> lines = (ArrayList<String>) Files.readAllLines(Paths.get(sfile));
        return lines;
    }
	
	public static boolean getGroup(String line, String pattern) 
	{
        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);
        // Now create matcher object.
        Matcher m = r.matcher(line);
        if (m.find()) 
		{
			return true;
        } 
		else 
		{
			return false;
        }
    }
	
	public static void findAndReplace(String file, String txt, String txt_replace) throws IOException
	{
		Path path = Paths.get(file);
		Charset charset = StandardCharsets.UTF_8;
		
		String content = new String(Files.readAllBytes(path),charset);
		content = content.replaceAll(txt,txt_replace);
		try
		{
			Files.write(path,content.getBytes(charset));
		}
		catch(AccessDeniedException e)
		{
			System.out.println("cant write this file: "+ path);
		}
	}
	
	
	public static ArrayList<String> findTextInFile(String pathFile,String text) throws FileNotFoundException
	{
		ArrayList<String> result = new ArrayList<>();
		
		Scanner scanner = new Scanner(new File(pathFile));
		
		while(scanner.hasNext())
		{
			String line = scanner.nextLine().toLowerCase().toString();
			if(line.contains(text))
			{
				System.out.println(line);
			}
		}
		
		return result;
	}
	
	
	public static void findTextAndReplace(String path,String pk1,String pk2,String code,String adsAppId,String unitAdsId)throws IOException 
	{	
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) 
		{
            if (listOfFiles[i].isFile()) 
			{
				String file = listOfFiles[i].getName();
				String t = getFileExtension(file);
				if(t.equals(".db") || t.equals(".png"))
				{
					//ignored this 
				}
				else
				{
					if(	file.equals(".gitignore")||
						file.equals("build.gradle")||
						file.equals("gradle.properties")||
						file.equals("gradlew")||
						file.equals("gradlew.bat")||
						file.equals("local.properties"))
					{
						// ignored
						if(file.equals("build.gradle"))
						{
							String gradle = path + "\\"+file;
							if(gradle.contains("app\\build.gradle"))
							{
								findAndReplace(path+"\\"+file,pk1,pk2);
								System.out.println("find "+path+"\\"+file +" going to replace code: "+code);
								findAndReplaceRegex(path+"\\"+file,".*versionCode.*\\d+.*",code,"gradle1");
								findAndReplaceRegex(path+"\\"+file,".*versionName.*\\d+.*","\""+code+"\"","gradle2");
							}
						}
					}
					else if(file.contains("AndroidManifest.xml"))
					{
						String manifest = path +"\\"+file;
						if(manifest.contains("app\\src\\main\\AndroidManifest.xml"))
						{
							System.out.println("find "+path+"\\"+file);
							findAndReplaceRegex(path+"\\"+file,".*package=\"..*\">",pk2,"manifest2");
							findAndReplaceRegex(path+"\\"+file,".*android:value=\".*\".*/>.*",adsAppId,"manifest1");
							
						}
						
					}
					else
					{
						findAndReplace(path+"\\"+file,pk1,pk2);
						String cfile = path+"\\"+file;
						
						if(cfile.contains("app\\src\\main\\java\\com\\myapp\\"+pk1+"\\"+file))
						{
							findAndReplaceRegex(path+"\\"+file,".*adsInterstitial.*new.*AdsInterstitial.*\".*\",\".*\",this.*",unitAdsId,"cfile");
						}
					}
				}
                //arr.add(path+"\\"+listOfFiles[i].getName());
            } 
			else if (listOfFiles[i].isDirectory()) 
			{
				if(	listOfFiles[i].getName().equals(".git")||
					listOfFiles[i].getName().equals(".gradle")||
					listOfFiles[i].getName().equals("gradle")
				)
				{
					
				}
				else
				{
					findTextAndReplace(path+"\\"+listOfFiles[i].getName(),pk1,pk2,code,adsAppId,unitAdsId);
				}
            }
        }
    }
	
	public static ArrayList<String> ListFileinFolder(String path)
	{
        ArrayList<String> arr = new ArrayList<>();

        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) 
		{
            if (listOfFiles[i].isFile()) 
			{
                arr.add(path+"\\"+listOfFiles[i].getName());
            } 
			else if (listOfFiles[i].isDirectory()) 
			{
				ArrayList<String> arrListTemp = new ArrayList<>();
                arrListTemp = ListFileinFolder(path+"\\"+listOfFiles[i].getName());
				arr.addAll(arrListTemp);
            }
        }
        return arr;
    }
	
	public static void findFolderAndReplace(String path, String nameFolder,String nameFolder2)
	{
		File folder = new File(path);
		
		File[] listOfFiles = folder.listFiles();
		for(int i=0; i< listOfFiles.length;i++)
		{
			if(listOfFiles[i].isDirectory())
			{
				if(listOfFiles[i].getName().equals(nameFolder))
				{
					System.out.println("got it: "+path+"\\"+listOfFiles[i].getName());
					// copy it to another folder
					String iDest = path+"\\"+nameFolder2;
					File dest = new File(iDest);
					if(dest.exists())
					{
						System.out.println("Exist - please find another folder");
					}
					else
					{
						System.out.println("Not Exist");
						if(dest.mkdir())
						{
							System.out.println("created new folder");
							copyDir(path+"\\"+listOfFiles[i].getName(),iDest,true);
							// delete it
							deleteDir(new File(path+"\\"+listOfFiles[i].getName()));
						}
						else
						{
							System.out.println("cant created because error ");
						}
					}
				}else
				{
					findFolderAndReplace(path+"\\"+listOfFiles[i].getName(),nameFolder,nameFolder2);
				}
			}
		}
	}
	
	
	public static void deleteDir(File file) 
	{
		File[] contents = file.listFiles();
		if (contents != null) 
		{
			for (File f : contents) 
			{
				if (! Files.isSymbolicLink(f.toPath())) 
				{
					deleteDir(f);
				}
			}
		}
		file.delete();
	}
	
	private static String getStep3(String nameProject,String cwd) throws IOException 
	{
        String t1 = nameProject;
        String t2 = "C:\\Users\\Huy Cuong\\appData\\Local\\Android\\Sdk\\platform-tools";
		String t3 = cwd+"\\"+nameProject+"\\app\\build\\outputs\\apk\\debug\\app-debug.apk";
        return "@ECHO ON \necho BUILD DEBUG && " +
                    "cd \""+t1+"\" " +
                    "&& call .\\gradlew assembleDebug " +
                    "&& cd \""+t2+"\" " +
                    "&& adb install \""+t3+"\""+
					"&& cd \""+cwd+"\" \n"
					
					;
    }
	
	private static String getStep4(String nameProject,String cwd,String key,String nameKey,String pass)
	{
		String t1 = nameProject;
		String t2 = "C:\\Program Files\\Java\\jdk-11.0.13\\bin";
		String iKey = cwd+"\\key\\"+key;
		String t3 = "";

		t3 = cwd+"\\"+nameProject+"\\app\\build\\outputs\\bundle\\release\\app-release.aab\" "+nameKey+"  -storepass \""+pass+"\" -keypass \""+pass+"\"";

		return "@ECHO ON \necho BUILD RELEASE && " +
				"cd \""+t1+"\" " +
				"&& call .\\gradlew bundleRelease " +
				"&& cd \""+t2+"\" " +
				"&& jarsigner -keystore \""+iKey+"\" \""+t3+
				"&& echo passed || echo failed \n"
				
				;
	}
	
	private static String getStep1(String[] para,String cwd)
	{
		return "java UpdateAndroidProject source_template\\"+para[0]+" "+para[1]+" "+para[2]+" "+para[3]+" Yes "+para[4]+" "+para[5]+" "+para[6]+" "+para[7]+" \n"
		
		;
	}
	
	private static String getStep2(String nameProject,String cwd)
	{
		String t = 
		"@echo on \n"+
		"echo OPEN EMULATOR \n"+
		"set DIR=C:\\Users\\Huy Cuong\\AppData\\Local\\Android\\Sdk\\emulator \n"+
		"cd %DIR% \n"+
		"cmd /k emulator -avd Pixel_2_API_30 \n"
		;
		return t;
	}
	private static String getStep31(String nameProject,String cwd,String key)
	{
		String t=
		"echo CREATE IMAGE CAPTURE AND COPY THEM \n"+
		"cd \"C:\\Users\\Huy Cuong\\AppData\\Local\\Android\\Sdk\\platform-tools>\"\n"+
		
		"adb shell am force-stop com.myapp."+nameProject+"\n"+
		"ping localhost -n 5 >nul && :: will wait 5 seconds before going next command (it will not display)\n"+
		"\n"+
		"adb shell am start -n com.myapp."+nameProject+"/com.myapp."+nameProject+".HomeActivity\n"+
		"ping localhost -n 15 >nul && :: will wait 10 seconds before going next command (it will not display)\n"+
		"adb shell screencap -p /sdcard/screencap.png && adb pull /sdcard/screencap.png\n"+
		"ping localhost -n 5 >nul && :: will wait 5 seconds before going next command (it will not display)\n"+
		"adb pull sdcard/screencap.png\n"+
		"copy screencap.png C:\\cuong\\javaCompile\\dest_"+nameProject+"\\capture1.png\n"+
		"\n"+
		"\n"+
		"adb shell am start -n com.myapp."+nameProject+"/com.myapp."+nameProject+".HomeActivity\n"+
		"ping localhost -n 15 >nul && :: will wait 10 seconds before going next command (it will not display)\n"+
		"adb shell screencap -p /sdcard/screencap.png && adb pull /sdcard/screencap.png\n"+
		"ping localhost -n 5 >nul && :: will wait 5 seconds before going next command (it will not display)\n"+
		"adb pull sdcard/screencap.png\n"+
		"copy screencap.png C:\\cuong\\javaCompile\\dest_"+nameProject+"\\capture1.png\n"+
		"\n"+
		"\n"+
		"adb shell am start -n com.myapp."+nameProject+"/com.myapp."+nameProject+".ContentActivity\n"+
		"ping localhost -n 10 >nul && :: will wait 10 seconds before going next command (it will not display)\n"+
		"adb shell screencap -p /sdcard/screencap.png && adb pull /sdcard/screencap.png\n"+
		"ping localhost -n 5 >nul && :: will wait 5 seconds before going next command (it will not display)\n"+
		"adb pull sdcard/screencap.png\n"+
		"copy screencap.png C:\\cuong\\javaCompile\\dest_"+nameProject+"\\capture2.png\n"+
		"\n"+
		"\n"+
		"adb shell am start -n com.myapp."+nameProject+"/com.myapp."+nameProject+".ContentActivity2\n"+
		"ping localhost -n 10 >nul && :: will wait 10 seconds before going next command (it will not display)\n"+
		"adb shell screencap -p /sdcard/screencap.png && adb pull /sdcard/screencap.png\n"+
		"ping localhost -n 5 >nul && :: will wait 5 seconds before going next command (it will not display)\n"+
		"adb pull sdcard/screencap.png\n"+
		"copy screencap.png C:\\cuong\\javaCompile\\dest_"+nameProject+"\\capture3.png\n"+
		"\n"+
		"adb shell am start -n com.myapp."+nameProject+"/com.myapp."+nameProject+".ContentActivity3\n"+
		"ping localhost -n 10 >nul && :: will wait 10 seconds before going next command (it will not display)\n"+
		"adb shell screencap -p /sdcard/screencap.png && adb pull /sdcard/screencap.png\n"+
		"ping localhost -n 5 >nul && :: will wait 5 seconds before going next command (it will not display)\n"+
		"adb pull sdcard/screencap.png\n"+
		"copy screencap.png C:\\cuong\\javaCompile\\dest_"+nameProject+"\\capture4.png\n"
		
		;
		return t;
	}
	private static String getStep5(String nameProject,String cwd)
	{
		return "";
	}
	
	private static String getStep52(String nameProject,String cwd)
	{
		String t = 
		"cd python \n"+
		"echo UPDATE BUNDLE FILE \n"+
		"googleconsole_update_bundle.py \n"
		
		;
		return t;
	}
	
	private static String getStep51(String nameProject,String cwd)
	{
		String t = "";

		t = 
		"cd python \n"+
		"echo UPDATE STORAGE IMAGE \n"+
		"googleconsole_update_app.py \n"
		;	

		return t;
	}
	private static String getStep21(String nameProject,String cwd)
	{
		String t = 
		"@echo on \n"+
		"echo CLEAN EMULATOR \n"+
		"set DIR=C:\\Users\\Huy Cuong\\AppData\\Local\\Android\\Sdk\\emulator \n"+
		"cd %DIR% \n"+
		"cmd /k emulator -avd Pixel_2_API_30 -wipe-data \n"
		;
		return t;
	}
	
	private static String createJks(String key,String cwd,String nameKey)
	{
		String pKey = cwd+"\\key\\"+key;
		String t = 
		"@ECHO ON \n"+
		"echo CREATE JKS \n"+
		"keytool -genkey -v -keystore "+pKey+" -alias "+nameKey+" -keyalg RSA -keysize 2048 -validity 10000 \n"
		
		;
		return t;
	}
	
	private static void createFile(String[] para,String sfile) throws IOException 
	{
		String cwd = Path.of("").toAbsolutePath().toString();
		Writer myWriter= new FileWriter(sfile);
		String sContentFile = "";
		String file = sfile.split("\\.")[0];
		String nameProject = para[1];
		String packageProject = para[3];
        try 
		{
			switch(file)
			{
				case "step1_copy_project":
				   sContentFile = getStep1(para,cwd);
				   break;
				case "step2_open_emulator":
				   sContentFile = getStep2(nameProject,cwd);
				   break;
				case "step2_1swip_emulator_not_needed":
				   sContentFile = getStep21(nameProject,cwd);
				   break;
				case "step3_modify_build_test_capture_image":
				   sContentFile = getStep3(nameProject,cwd);
				   break;
				case "step3_1capture_image":
				   sContentFile = getStep31(packageProject,cwd,para[7]);
				   break;
				case "step4_build_release_sign":
				   sContentFile = getStep4(nameProject,cwd,para[7],"key0",para[9]);
				   break;
				case "step5_update_project_github":
				   sContentFile = getStep5(nameProject,cwd);
				   break;
				case "step5_1update_project_bundle":
				   sContentFile = getStep52(nameProject,cwd);
				   break;
				case "step5_1update_project_googleconsole":
				   sContentFile = getStep51(nameProject,cwd);
				   break;
				case "create_jks":
				   sContentFile = createJks(para[7],cwd,"key0");
				   break;
				default:
				  System.out.println("No file created!!! "+sfile);
				  break;
			}
			myWriter.write(sContentFile);
			
            myWriter.close();
            System.out.println("Successfully wrote to the file."+sfile);
        } 
		catch (IOException e) 
		{
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

