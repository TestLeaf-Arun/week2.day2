package week2.day2;
public class RemoveDuplicates {
	public static void main(String[] args) {
		String text = "We learn java basics as part of java sessions in java week1";
		int count=0;
		String[] splitStr = text.split(" ");
		String temp=null;
		for (int i=0; i<splitStr.length; i++) {
			for (int j=i+1; j<splitStr.length; j++) {
				if (splitStr[i].equals(splitStr[j])) {
					temp=splitStr[i];
					count++;
				}	
			}
		}
		if (count>1) {
			System.out.println(text.replace(temp, ""));
		}
	}
}