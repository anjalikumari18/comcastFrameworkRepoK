import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReaddatafromJSon {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		
		//Get access of physical file using file reader
		FileReader fr=new FileReader("C:\\Users\\anjal\\Desktop\\DDT Files\\jsoncommondata.json");

		//Parse json physicl file into java file using JSONParser class
		JSONParser parser=new JSONParser();
        Object object = parser.parse(fr);
        
        //Convert java object into JSONObject using downcasting
		JSONObject jsobj=(JSONObject)object;
		
		//Read the data using get() by passing the key
		 Object brow = jsobj.get("browser").toString();
		System.out.println(brow);
		
	
		

	}

}
