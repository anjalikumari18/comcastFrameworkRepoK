import java.util.Random;

public class DDT_GenerateRandomNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random randominteger=new Random();
		int random = randominteger.nextInt(1000);
		
		System.out.println(random);

	}

}
