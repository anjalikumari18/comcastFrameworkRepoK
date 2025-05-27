import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Datemanipulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Date date=new Date();
		System.out.println(date);
		SimpleDateFormat sdf=new SimpleDateFormat();
		String currentdate = sdf.format(date);
		System.out.println(currentdate);
		
		Calendar cal=sdf.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,20);
		String expecteddate = sdf.format(cal.getTime());
		System.out.println(expecteddate);
		
		
		

	}

}
