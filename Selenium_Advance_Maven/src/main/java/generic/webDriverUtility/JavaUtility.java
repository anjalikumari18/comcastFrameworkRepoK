package generic.webDriverUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	public int getRandomNumber() {
		Random rdm=new Random();
		int randominteger = rdm.nextInt(9000);
		return randominteger;
	}
	
	public String getSystemDate() {
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		String cdate = sdf.format(date);
		return cdate;
	}
	
	public String getRequiredDateYYYYDDMM(int days){
		Date date=new Date();
		SimpleDateFormat simp=new SimpleDateFormat("dd-MM-yyyy");
		simp.format(date);
		Calendar cal = simp.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,days);
		String reqDate = simp.format(cal.getTime());
		return reqDate;
		
	}
	
	
	

}
