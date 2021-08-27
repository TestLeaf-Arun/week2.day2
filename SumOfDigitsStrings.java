package week2.day2;
public class SumOfDigitsStrings {
	public static void main(String[] args) {
		String text = "Tes12Le79af65";
		int sum=0;
		String num = text.replaceAll("\\D", "");
		System.out.println("Digits:" + num);
		char[] charArray = num.toCharArray();		
			for (int i=0; i<charArray.length; i++) {
				System.out.println("charArray[" + i + "]:" + charArray[i]);

			 //	Using Character.getNumericValue(i), change the character into int
				int j=Character.getNumericValue(charArray[i]);
				sum=sum+j;
			}	
		System.out.println("Sum of the Digits:" + sum);	
	}
}