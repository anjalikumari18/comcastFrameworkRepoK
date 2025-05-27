import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DDT_Testcase_Createcampaginwithdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Date date=new Date();
		System.out.println(date); //Thu May 08 19:11:08 IST 2025

		SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
		String actDate = simple.format(date);
		
		System.out.println(actDate);
		
		Calendar cal=simple.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,20);
		
		String reqDate=simple.format(cal.getTime());
		System.out.println(reqDate);
		
		
		
		
		
	}

}
