package CRM_Testcase;

import java.util.Random;

public class DDT_GenerateRandomnumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random random=new Random();
		int randominteger = random.nextInt(300);
		System.out.println(randominteger);
		
	}

}
