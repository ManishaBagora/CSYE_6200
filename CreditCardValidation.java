import java.util.Scanner;
public class CreditCardValidation {
	public static void main(String[] args) {
		try (Scanner input =new Scanner(System.in)) {
			System.out.print("Enter a credit card number as a long integer:");
			long number= input.nextLong();
			boolean isValid=isValid(number);
			if(isValid) {
				String cardType=identifyCardType(number);
				System.out.println(number +" "+ "is a valid" +" "+ cardType);
			}else {
				System.out.println(number + " is Invalid");
			}
		}	
	}
	//Lets identify the card type//
	public static String identifyCardType(long number) {
		if(isVisaCard(number)) {
			return "Visa Card";
		}else if(isMasterCard(number)) {
			return "Master Card";
		}else if(isAmericanExpressCard(number)) {
			 return "American Express Card";
		}else if (isDiscoverCard(number)) {
			return "Discover Card";
		}else {
			return "Valid";
		
		 }
	}
	
	/** Return true if the card number is valid */
	public static boolean isValid(long number) {
		boolean valid_number=(getSize(number)>=13 && getSize(number)<=16)&&
				((prefixMatched(number,4)&&isVisaCard(number))||
						(prefixMatched(number,5)&& isMasterCard(number))||
								(prefixMatched(number,37)&&isAmericanExpressCard(number))||
								(prefixMatched(number,6)&&isDiscoverCard(number)))&&
						((sumOfDoubleEvenPlace(number)+ sumOfOddPlace(number))%10==0);

	return valid_number;
	}
	/*Here we are checking the credit card company*/
	public static boolean isDiscoverCard(long number) {
		String my_num=Long.toString(number);
		return my_num.startsWith("6");//Discover card start with 6
	}
	public static boolean isVisaCard(long number) {
		String my_num=Long.toString(number);
		return my_num.startsWith("4");//Visa card start with 4
	}
	public static boolean isMasterCard(long number) {
		String my_num=Long.toString(number);
		return my_num.startsWith("5");//Master card start with 5
	}
	public static boolean isAmericanExpressCard(long number) {
		String my_num=Long.toString(number);
		return my_num.startsWith("37");//American Express card start with 37
	}
		
	
	/** Get the result from Step 2 */
	public static int sumOfDoubleEvenPlace(long number) {
		int num_sum=0;
		String my_num=Long.toString(number);
		for(int x=getSize(number)-2;x>=0;x-=2) {
			num_sum+=getDigit(Integer.parseInt(my_num.charAt(x)+"")*2);
		}
		return num_sum;
	}

	/**
	 * Return this number if it is a single digit, otherwise, return the sum of
	 * the two digits
	 */
	public static int getDigit(int number) {
		if(number<9) 
			return number;
		else
			return number/10+number%10;
		}
	

	/** Return sum of odd place digits in number */
	public static int sumOfOddPlace(long number) {
		int num_sum=0;
		String my_num=Long.toString(number);
		for(int x=getSize(number)-1;x>=0;x-=2) {
			num_sum+=Integer.parseInt(my_num.charAt(x)+"");
		}
		return num_sum;
	}

	/** Return true if the digit d is a prefix for number */
	public static boolean prefixMatched(long number, int d) {
		
		return getPrefix(number,getSize(d))==d;
	}

	/** Return the number of digits in d */
	public static int getSize(long d) {
		String my_num=d+"";
		return my_num.length();
	}

	/**
	 * Return the first k number of digits from number. If the number of digits
	 * in number is less than k, return number.
	 */
	public static long getPrefix(long number, int k) {
		if(getSize(number)>k) {
			String my_num=number+"";
			return Long.parseLong(my_num.substring(0,k));
		}
		return number;
	}
}


