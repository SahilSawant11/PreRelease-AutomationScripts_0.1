package utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileHistory {

	public static void FileData(String url, String node, String sector, String propertyNo) throws IOException
	{
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		 LocalDateTime now = LocalDateTime.now();
		 String s = dtf.format(now);
		 File f1 = new File("C:\\CMSFile");
		 f1.mkdir();
		 String file = f1+"\\PropertyHistory "+s+".txt";
		 
		 File yourFile = new File(file);
		 yourFile.createNewFile(); // if file already exists will do nothing

		 FileWriter myWriter = new FileWriter(file, true);
		 myWriter.write("\n\n----------- "+s+" -----------------\n");
		 myWriter.write("Url: "+ url);
		 myWriter.write("\nProperty: "+node+sector+" - "+propertyNo);
		 myWriter.write("\n---------------------------------------\n");
		 myWriter.close();
	}
}
