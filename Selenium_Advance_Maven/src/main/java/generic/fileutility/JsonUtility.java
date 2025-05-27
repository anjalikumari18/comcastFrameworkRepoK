package generic.fileutility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {
	
			
		public String getDataFromJsonFile(String key) throws IOException, ParseException {
			
			FileReader fr=new FileReader("./ConfigApp/jsoncommondata.json");
			JSONParser parser=new JSONParser();
			Object object = parser.parse(fr);
			JSONObject jobj=(JSONObject)object;
			String data = jobj.get(key).toString();
			return data;
		
	}

}
