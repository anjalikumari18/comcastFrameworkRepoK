package generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileutility {
	
	public String getDataFromPropertiesFile(String key) throws IOException {
		
		FileInputStream fis=new FileInputStream("./ConfigApp/ninzaCRMCommonData.properties");
		Properties pObj=new Properties();
		pObj.load(fis);
		String data = pObj.getProperty(key);
		
		return data;
	}
	
	

}
