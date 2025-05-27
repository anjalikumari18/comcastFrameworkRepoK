
public class DDT_GenerateAlphanumeric {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n=20;
		//Choose a random character from this string
		String alphanumericstring="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		
		//Create stringbuffer of alphanumericString
		StringBuilder sb=new StringBuilder(n);
		
		for(int i=0; i<n;i++) {
			
			//generate a random number
			
			int index=(int)(alphanumericstring.length()*Math.random());
			
			//add character one by one in the end of ab
			sb.append(alphanumericstring.charAt(index));
			
			}
		
		System.out.println(sb);

	}

}
