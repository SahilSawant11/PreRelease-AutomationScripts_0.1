package utility;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Delete_Files {
	
	public Delete_Files (WebDriver wb)
	{
		PageFactory.initElements(wb, this);
	}
	
	public void Delete_files(String deletepath) {

		File folder = new File(System.getProperty("user.dir")+deletepath);
		File[] listOfFiles = folder.listFiles();
	
System.out.println(folder);
System.out.println(listOfFiles);
		for (int i = 0; i < listOfFiles.length; i++) {
		  
//		    System.out.println(listOfFiles[i].getName());
		    
		    File file = new File(System.getProperty("user.dir")+deletepath+"\\"+listOfFiles[i].getName());
			 
		    file.delete();//	        file.delete();
	        }
	}

}
