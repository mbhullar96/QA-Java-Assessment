package com.qa.javaAssessment;

public class Assessment {

	// Given a string, return a string where
	// for every char in the original string,
	// there are three chars.

	// multChar("The") ==> "TTThhheee"
	// multChar("AAbb") ==> "AAAAAAbbbbbb"
	// multChar("Hi-There") ==> "HHHiii---TTThhheeerrreee"

	public String multChar(String input) {
		String word = "";
		for (int i = 0; i< input.length(); i++) {
			word += input.substring(i, i+1);
			word += input.substring(i, i+1);
			word += input.substring(i, i+1);
		}
		return word;
	}
	
	// Return the string (backwards) that is between the first and last appearance
	// of "bert"
	// in the given string, or return the empty string "" if there is not 2
	// occurances of "bert" - Ignore Case

	// getBert("bertclivebert") ==> "evilc"
	// getBert("xxbertfridgebertyy") ==> "egdirf"
	// getBert("xxBertfridgebERtyy") ==> "egdirf"
	// getBert("xxbertyy") ==> ""
	// getBert("xxbeRTyy") ==> ""

	public String getBert(String input) {
		String search = "bert";
		input = input.toLowerCase();
		int first = input.indexOf(search);
		int last = input.lastIndexOf(search);
		int count = 0;
		
		for (int i = 0; i < input.length() - 3; i++) {
			if (input.substring(i, i + 4).equals("bert")) {
				count++;
			}
		}
		
		if (count < 2) {
			return "";
		} else {
			String mid = input.substring(first+4, last);
			String backwards = "";
			for (int i = mid.length() - 1; i >= 0; i--) {
				backwards += mid.charAt(i);
			}
			
			return backwards;
		}
	}

	// Given three ints, a b c, one of them is small, one is medium and one is
	// large. Return true if the three values are evenly spaced, so the
	// difference between small and medium is the same as the difference between
	// medium and large. Do not assume the ints will come to you in a reasonable
	// order.

	// evenlySpaced(2, 4, 6) ==> true
	// evenlySpaced(4, 6, 2) ==> true
	// evenlySpaced(4, 6, 3) ==> false
	// evenlySpaced(4, 60, 9) ==> false

	public boolean evenlySpaced(int a, int b, int c) {
		int small = Math.min(Math.min(a, b), c);
		int large = Math.max(Math.max(a, b), c);
		int mid;
		
		if (a > small && a < large) {
			mid = a;
		} else if (b > small && b < large) {
			mid = b;
		} else {
			mid = c;
		}
		
		if (mid - small == large - mid) {
			return true;
		} else {
			return false;
		}
	}

	// Given a string and an int n, return a string that removes n letters from the 'middle' of the string.
	// The string length will be at least n, and be odd when the length of the input is odd.

	// nMid("Hello", 3) ==> "Ho"
	// nMid("Chocolate", 3) ==> "Choate"
	// nMid("Chocolate", 1) ==> "Choclate"

	public String nMid(String input, int a) {
		int len = input.length();
		int i = (len / 2);
		int diff = a / 2;
		
		String mid = input.substring(0, (i - diff)) + input.substring((i + diff) + 1, len);
		return mid;
	}


	// Given a string, return the length of the largest "block" in the string.
	// A block is a run of adjacent chars that are the same.
	//
	// superBlock("hoopplla") ==> 2
	// superBlock("abbCCCddDDDeeEEE") ==> 3
	// superBlock("") ==> 0

	public int superBlock(String input) {
		int largest = 0;
		int count = 0;
		if (input.isEmpty()) {
			return 0;
		}
		for (int i = 0; i < input.length() - 1; i++) {
			if (input.charAt(i) == input.charAt(i + 1)) {
				count++;
			} else {
				if (count > largest) {
					largest = count;
				}
				count = 1;
			}
		}
		return largest;
	}
	
	//given a string - return the number of times "am" appears in the String ignoring case -
	// BUT ONLY WHEN the word "am" appears without being followed or proceeded by other letters
	//
	//amISearch("Am I in Amsterdam") ==> 1
	//amISearch("I am in Amsterdam am I?") ==> 2
	//amISearch("I have been in Amsterdam") ==> 0

	public int amISearch(String arg1) {
		String search = "am";
		arg1 = arg1.toLowerCase();
		int count = 0;
		int len = arg1.length();
		if (arg1.substring(0, 2).equals(search) && arg1.substring(2, 3).equals(" ")) {
			count += 1;
		}
		if (arg1.substring(len - 2, len).equals(search) && arg1.substring(len - 3, len - 2).equals(" ")) {
			count += 1;
		}
		for (int i = 1; i < len - 2; i++) {
			String left = arg1.substring(i - 1, i);
			String right = arg1.substring(i + 2, i + 3);
			if ((left.equals(" ") && right.equals(" ")) && arg1.substring(i, i + 2).equals(search)) {
				count++;
			}
		}
		return count;
	}
	
	//given a number 
	// if this number is divisible by 3 return "fizz"
	// if this number is divisible by 5 return "buzz"
	// if this number is divisible by both 3  and 5return "fizzbuzz"
	//
	//fizzBuzz(3) ==> "fizz"
	//fizzBuzz(10) ==> "buzz"
	//fizzBuzz(15) ==> "fizzbuzz"
	
	public String fizzBuzz(int arg1) {
		if (arg1 % 3 == 0 && arg1 % 5 == 0) {
			return "fizzbuzz";
		}
		if (arg1 % 3 == 0) {
			return "fizz";
		}
		if (arg1 % 5 == 0) {
			return "buzz";
		}
		return "";
		
	}
	
	//Given a string split the string into the individual numbers present
	//then add each digit of each number to get a final value for each number
	// String example = "55 72 86"
	//
	// "55" will = the integer 10
	// "72" will = the integer 9
	// "86" will = the integer 14
	//
	// You then need to return the highest vale
	//
	//largest("55 72 86") ==> 14
	//largest("15 72 80 164") ==> 11
	//largest("555 72 86 45 10") ==> 15
	
	public int largest(String arg1) {
		int sum = 0;
		int largest = 0;
		String[] arr = arg1.split(" ");
		for (String num : arr) {
			for (int i = 0; i < num.length(); i++) {
				sum += Integer.parseInt(String.valueOf(num.charAt(i)));
			}
			if (sum > largest) {
				largest = sum;
			}
			sum -= sum;
		}
		return largest;
	}
}
