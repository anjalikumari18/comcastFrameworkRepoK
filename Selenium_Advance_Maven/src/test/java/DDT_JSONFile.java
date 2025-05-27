import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DDT_JSONFile {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		// TODO Auto-generated method stub
		
		//Step:1 parse JSON Physical file in to Java Object using JSonParse class
		JSONParser parser=new JSONParser();
		Object obj=parser.parse(new FileReader("C:\\Users\\anjal\\OneDrive\\Desktop\\Framewo\\seleniumintegrationdata\\appcommondata.json.txt"));

		//Step 2: Convert java object in to jsonObject using downcasting
		JSONObject map=(JSONObject)obj;
		
		//Step 3: get value from json file using key
		System.out.println(map.get("url"));
		System.out.println(map.get("browser"));
		System.out.println(map.get("username"));
		System.out.println(map.get("password"));
		System.out.println(map.get("time"));
		
	}

}
