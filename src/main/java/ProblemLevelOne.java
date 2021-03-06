import java.io.IOException;
import java.math.BigInteger;
import java.util.*;

public class ProblemLevelOne {

	
	/**
	 * If we list all the natural numbers below 10 that are multiples of 3 or 5, 
	 * we get 3, 5, 6 and 9. The sum of these multiples is 23.
	 * Find the sum of all the multiples of 3 or 5 below 1000.
	 * @return
	 */
	public int problem1() {
		
		int sum = 0;
		
		for(int i=0;i<1000;i++) {
			if(i%5 == 0 || i%3 == 0) {
				sum += i;
			}
		}
		
		return sum;
	}
	
	/**
	 * Each new term in the Fibonacci sequence is generated by adding the previous two terms. 
	 * By starting with 1 and 2, the first 10 terms will be: 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
	 * By considering the terms in the Fibonacci sequence whose values do not exceed four million, 
	 * find the sum of the even-valued terms.
	 */
	
	public int problem2() {
		
		int prev2 = 1;
		int prev = 2;
		int sum = 2;
		int cur = 2;
		
		while(cur < 4000000) {
			cur = prev2 + prev;
			if(cur % 2 == 0) {
				sum += cur;
			}
			prev2 = prev;
			prev = cur;
		}
		
		return sum;
	}

	/**
	 * The prime factors of 13195 are 5, 7, 13 and 29. 
	 * What is the largest prime factor of the number 600851475143 ?
	 * @return
	 */
	public long problem3(double number) {
		
		long n = (long) number;
		long sqrt = (long) Math.floor(Math.sqrt(number));
		long factor = 3;
		long largestFactor = 3;
		
		while (factor <= sqrt) {
			if(n % factor == 0) {
				if(factor > largestFactor) {
					largestFactor = factor;
				}
				n /= factor;
			}
			factor += 2;
		}
		
		return largestFactor;
	}
	
	
	/**
	 * A palindromic number reads the same both ways. 
	 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
	 * Find the largest palindrome made from the product of two 3-digit numbers.
	 */
	public int problem4() {
		
		int largestPalindrome = 0;
		
		for(int i=0;i<1000;i++) {
			for(int j=0;j<1000;j++) {
				int num = i * j;
				if(isPalindrome(num) && num > largestPalindrome) {
					largestPalindrome = num;
				}
			}
		}
		
		return largestPalindrome;
	}

	protected boolean isPalindrome(long num) {
		String numStr = String.valueOf(num);
		int length = numStr.length();
		int mid = (length / 2);
		
		for(int i=0,j=length-1; i < mid && j >= mid; i++,j--) {
			if(numStr.charAt(i) != numStr.charAt(j)) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 
	 * without any remainder. 
	 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
	 */
	public int problem5() {
		int i = 20;
		
		while(i > 0) {
			
			boolean divisible = true;
			
			for(int j=1;j<=20;j++) {
				if(i % j > 0) {
					divisible = false;
					break;
				}
			}
			
			if(divisible) {
				return i;
			}
			
			i++;
		}
		
		return -1;
	}
	
	
	/**
	 * The sum of the squares of the first ten natural numbers is,
	 * 1^2 + 2^2 + ... + 10^2 = 385
	 * The square of the sum of the first ten natural numbers is,
	 * (1 + 2 + ... + 10)^2 = 552 = 3025
	 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
	 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
	 */
	
	public int problem6() {
		
		int sumOfSquares = 0;
		int squareOfSums = 0;
		
		for(int i=1;i<=100;i++) {
			sumOfSquares += i * i;
			squareOfSums += i;
		}
		
		squareOfSums = squareOfSums * squareOfSums;
		
		return (squareOfSums - sumOfSquares);
	}
	
	
	/**
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
	 * What is the 10 001st prime number?
	 */
	
	public int problem7() {
		int pNo = 0;
		int prime=0;
		
		while(pNo <= 10001) {
			prime++;
			if(isPrime(prime)) {
				pNo++;
			}
		}
		
		return prime;
	}
	
	/**
	 * The four adjacent digits in the 1000-digit number that have the greatest product are 9 × 9 × 8 × 9 = 5832.
	 * 
			73167176531330624919225119674426574742355349194934
			96983520312774506326239578318016984801869478851843
			85861560789112949495459501737958331952853208805511
			12540698747158523863050715693290963295227443043557
			66896648950445244523161731856403098711121722383113
			62229893423380308135336276614282806444486645238749
			30358907296290491560440772390713810515859307960866
			70172427121883998797908792274921901699720888093776
			65727333001053367881220235421809751254540594752243
			52584907711670556013604839586446706324415722155397
			53697817977846174064955149290862569321978468622482
			83972241375657056057490261407972968652414535100474
			82166370484403199890008895243450658541227588666881
			16427171479924442928230863465674813919123162824586
			17866458359124566529476545682848912883142607690042
			24219022671055626321111109370544217506941658960408
			07198403850962455444362981230987879927244284909188
			84580156166097919133875499200524063689912560717606
			05886116467109405077541002256983155200055935729725
			71636269561882670428252483600823257530420752963450
			
		Find the thirteen adjacent digits in the 1000-digit number that have the greatest product. 
		What is the value of this product?
		
	 * @param number
	 * @return
	 */
	
	public String problem8() {
		
		long largestProduct = 0;
		int largestIdx = 0;
		
		String numString = 
		   "73167176531330624919225119674426574742355349194934"
		 + "96983520312774506326239578318016984801869478851843"
		 + "85861560789112949495459501737958331952853208805511"
		 + "12540698747158523863050715693290963295227443043557"
		 + "66896648950445244523161731856403098711121722383113"
		 + "62229893423380308135336276614282806444486645238749"
		 + "30358907296290491560440772390713810515859307960866"
		 + "70172427121883998797908792274921901699720888093776"
		 + "65727333001053367881220235421809751254540594752243"
		 + "52584907711670556013604839586446706324415722155397"
		 + "53697817977846174064955149290862569321978468622482"
		 + "83972241375657056057490261407972968652414535100474"
		 + "82166370484403199890008895243450658541227588666881"
		 + "16427171479924442928230863465674813919123162824586"
		 + "17866458359124566529476545682848912883142607690042"
		 + "24219022671055626321111109370544217506941658960408"
		 + "07198403850962455444362981230987879927244284909188"
		 + "84580156166097919133875499200524063689912560717606"
		 + "05886116467109405077541002256983155200055935729725"
		 + "71636269561882670428252483600823257530420752963450";
		
		
		for(int i=0;i<numString.length()-13;i++) {
			int[] chars = new int[13];
		
			for(int j=0;j<13;j++) {
				chars[j] = Character.getNumericValue(numString.charAt(i+j));
			}
			
			long product = 1;
			
			for(int j=0;j<13;j++) {
				product *= chars[j];
			}
			
			if(product > largestProduct) {
				largestProduct = product;
				largestIdx = i;
			}
			
		}
		
		System.out.println(String.valueOf(numString.substring(largestIdx, largestIdx+13)));
		
		return String.valueOf(largestProduct);
	}
	
	protected boolean isPrime(long number) {
		
		if(number == 2 || number == 3) {
			return true;
		}
		
		if(number % 2 == 0) {
			return false;
		}
		
		long sqrt = (long) Math.sqrt((double) number);
		
		for(int i = 3 ; i <= sqrt ; i = i+2) {
			if (number % i == 0) {
				return false;
			}
		}
		
		return true;
		
	}

	/**
	 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
	 * a^2 + b^2 = c^2
	 * 
	 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
	 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
	 * Find the product abc.
	 * @return
	 */
	public int problem9() {

		for(int i=1;i<=1000;i++) {
			for(int j=i;j<=1000;j++) {
				for(int k=j;k<=1000;k++) {
					
					if((i*i + j*j) == k*k) {
						if((i+j+k) == 1000) {
							return i*j*k;
						}
					}
					
				}
			}
		}
		
		return 0;
	}

	/**
	 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
	 * Find the sum of all the primes below two million.
	 * @return
	 */
	public long problem10() {

		long sum = 0;
		
		for(int i=2;i<2000000;i++) {
			if(isPrime(i)) {
				sum += i;
			}
		}
		
		return sum;
	}

	/**
	 * In the 20×20 grid below, four numbers along a diagonal line have been marked in red.
	 * 
	 * 08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08
	 * 49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00
	 * 81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65
	 * 52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91
	 * 22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80
	 * 24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50
	 * 32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70
	 * 67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21
	 * 24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72
	 * 21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95
	 * 78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92
	 * 16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57
	 * 86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58
	 * 19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40
	 * 04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66
	 * 88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69
	 * 04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36
	 * 20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16
	 * 20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54
	 * 01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48
	 * 
	 * The product of these numbers is 26 × 63 × 78 × 14 = 1788696.
	 * What is the greatest product of four adjacent numbers in the same direction (up, down, left, right, or diagonally) in the 20×20 grid?
	 * @return
	 * @throws IOException 
	 */
	public long problem11(int[][] gridInt) throws IOException {
		long maxPrdt = 0;
		for(int i=0;i<20;i++) {
			for(int j=0;j<20;j++) {
				long prdt = getMaxProduct(new int[]{i,j}, gridInt, 4);
				if(prdt > maxPrdt) {
					maxPrdt = prdt;
				}
			}
		}
		
		return maxPrdt;
	}
	
	
	/**
	 * The sequence of triangle numbers is generated by adding the natural numbers. 
	 * So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. The first ten terms would be:
	 * 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
	 * Let us list the factors of the first seven triangle numbers:
	 * 1: 1
	 * 3: 1,3
	 * 6: 1,2,3,6
	 * 10: 1,2,5,10
	 * 15: 1,3,5,15
	 * 21: 1,3,7,21
	 * 28: 1,2,4,7,14,28
	 * We can see that 28 is the first triangle number to have over five divisors.
	 * 
	 * What is the value of the first triangle number to have over five hundred divisors?
	 * @return
	 */
	public int problem12() {
		
		int triangleNumber = 1;
		
		for(int i=2;i>0;i++) {
			Set<Integer> divisors = new HashSet<>();

			triangleNumber += i;
			
			divisors = getFactors(triangleNumber, divisors);
			
			if(divisors.size() > 500) {
				break;
			}
		}
		
		return triangleNumber;
	}
	
	protected Set<Integer> getFactors(int number, Set<Integer> factors) {
		int sqrt = Double.valueOf(Math.sqrt(number)).intValue();
		
		factors.add(1);
		
		for(int j=2; j <= sqrt; j++) {
			if(number % j == 0) {
				int quotient = number / j;
				factors.add(j);
				factors.add(quotient);
				getFactors(quotient, factors);
			}
		}
		
		factors.add(number);
		
		return factors;
	}

	protected long getMaxProduct(int[] cur, int[][] gridInt, int wordlength) {
		
		long maxPrdt = 0;
		long prdt = 1;
		int maxPos = gridInt.length - wordlength;
		int minPos = wordlength - 1;
		
		if(cur[0] > minPos) {
			prdt = 1;
			for(int i=0;i<wordlength;i++) {
				prdt = prdt * gridInt[cur[0]-i][cur[1]];
			}
			
			if(prdt > maxPrdt) {
				maxPrdt = prdt;
			}
		}
		
		if(cur[0] < maxPos) {
			prdt = 1;
			for(int i=0;i<wordlength;i++) {
				prdt = prdt * gridInt[cur[0]+i][cur[1]];
			}
			
			if(prdt > maxPrdt) {
				maxPrdt = prdt;
			}
		}
		
		if(cur[1] > minPos) {
			prdt = 1;
			for(int i=0;i<wordlength;i++) {
				prdt = prdt * gridInt[cur[0]][cur[1]-i];
			}
			
			if(prdt > maxPrdt) {
				maxPrdt = prdt;
			}
		}
		
		if(cur[1] < maxPos) {
			prdt = 1;
			for(int i=0;i<wordlength;i++) {
				prdt = prdt * gridInt[cur[0]][cur[1]+i];
			}
			
			if(prdt > maxPrdt) {
				maxPrdt = prdt;
			}
		}
		
		if(cur[0] > minPos && cur[1] > minPos) {
			prdt = 1;
			for(int i=0;i<wordlength;i++) {
				prdt = prdt * gridInt[cur[0]-i][cur[1]-i];
			}
			
			if(prdt > maxPrdt) {
				maxPrdt = prdt;
			}
		}
		
		if(cur[0] < maxPos && cur[1] < maxPos) {
			prdt = 1;
			for(int i=0;i<wordlength;i++) {
				prdt = prdt * gridInt[cur[0]+i][cur[1]+i];
			}
			
			if(prdt > maxPrdt) {
				maxPrdt = prdt;
			}
		}
		
		if(cur[0] > minPos && cur[1] < maxPos) {
			prdt = 1;
			for(int i=0;i<wordlength;i++) {
				prdt = prdt * gridInt[cur[0]-i][cur[1]+i];
			}
			
			if(prdt > maxPrdt) {
				maxPrdt = prdt;
			}
		}
		
		if(cur[0] < maxPos && cur[1] > minPos) {
			prdt = 1;
			for(int i=0;i<wordlength;i++) {
				prdt = prdt * gridInt[cur[0]+i][cur[1]-i];
			}
			
			if(prdt > maxPrdt) {
				maxPrdt = prdt;
			}
		}

		return maxPrdt;
	}

	public LargeNumber problem13(String[] numbers) throws Exception {
		
		LargeNumber sum = new LargeNumber("0");
		
		for(int i=0;i<numbers.length;i++) {
			sum = sum.add(new LargeNumber(numbers[i]));
		}
		
		return sum;
	}
	
	/**
	 * The following iterative sequence is defined for the set of positive integers:
	 * 
	 * n → n/2 (n is even)
	 * n → 3n + 1 (n is odd)
	 * 
	 * Using the rule above and starting with 13, we generate the following sequence:
	 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
	 * 
	 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
	 * 
	 * Which starting number, under one million, produces the longest chain?
	 * 
	 * NOTE: Once the chain starts the terms are allowed to go above one million.
	 * @return
	 */
	public int problem14() {
		
		int longestChain = 0;
		int lcn = 0;
		
		Map<Integer, Integer> memoize = new HashMap<>();
		
		for(int i=2;i<1000000;i++) {
			long num = i;
			int cnt = 0;
			
			while(num != 1) {
				if(memoize.containsKey(num)) {
					cnt += memoize.get(num);
					break;
				} else {
					if(num % 2 == 0) {
						num = halfEven(num);
					} else {
						num = tripleOdd(num);
					}
					cnt++;
				}
			}
			
			memoize.put(i, cnt);
			
			if(longestChain < cnt) {
				longestChain = cnt;
				lcn = i;
			}
		}
		
		return lcn;
	}
	
	
	/**
	 * Starting in the top left corner of a 2�2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.
	 * How many such routes are there through a 20�20 grid?
	 * @param number
	 * @return
	 */
	public BigInteger problem15(long n) {
		BigInteger numerator = factorial(new BigInteger(String.valueOf(2 * n)));
		BigInteger denominator = factorial(new BigInteger(String.valueOf(n))).multiply(factorial(new BigInteger(String.valueOf(n))));
		
		return numerator.divide(denominator);
	}
	
	
	/**
	 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
	 * What is the sum of the digits of the number 2^1000?
	 * @param number
	 * @return
	 */
	public int problem16() {
		BigInteger number = new BigInteger("2").pow(1000);
		
		String numberStr = String.valueOf(number);
		int sum = 0;
		
		for(int i=0;i<numberStr.length();i++) {
			sum += Character.getNumericValue(numberStr.charAt(i));
		}
		
		return sum;
	}
	
	
	/**
	 * If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
	 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
	 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters 
	 * and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.
	 * @param number
	 * @return
	 */
	public int problem17() {
		
		int length = 0;
		
		for (int i=1;i<=1000;i++) {
			String word = numberToWords(i);
			length += word.replaceAll("[ -]", "").length();
		}
		

		return length;
	}
	
	/**
	 * By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.

		3
		7 4
		2 4 6
		8 5 9 3
		
		That is, 3 + 7 + 4 + 9 = 23.
		
		Find the maximum total from top to bottom of the triangle below:
		
		75
		95 64
		17 47 82
		18 35 87 10
		20 04 82 47 65
		19 01 23 75 03 34
		88 02 77 73 07 63 67
		99 65 04 28 06 16 70 92
		41 41 26 56 83 40 80 70 33
		41 48 72 33 47 32 37 16 94 29
		53 71 44 65 25 43 91 52 97 51 14
		70 11 33 28 77 73 17 78 39 68 17 57
		91 71 52 38 17 14 91 43 58 50 27 29 48
		63 66 04 68 89 53 67 30 73 16 69 87 40 31
		04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
		
		NOTE: As there are only 16384 routes, it is possible to solve this problem by trying every route. However, Problem 67, is the same challenge with a triangle containing one-hundred rows; it cannot be solved by brute force, and requires a clever method! ;o)
	 * @return
	 */
	public int problem18(int[][] pyramid) {
		
		if(pyramid.length == 1) {
			return pyramid[0][0];
		}
		
		int[][] newPyramid = new int[pyramid.length-1][];
		
		for(int i = 0; i < newPyramid.length; i++) {
			newPyramid[i] = Arrays.copyOf(pyramid[i], newPyramid.length);
		}
		
		for(int i = 0; i < newPyramid[newPyramid.length-1].length; i++) {	
			
			int leftVal = pyramid[newPyramid.length][i];
			int rightVal = pyramid[newPyramid.length][i+1];
			
			if(leftVal > rightVal) {
				newPyramid[newPyramid.length-1][i] += leftVal;
			} else {
				newPyramid[newPyramid.length-1][i] += rightVal;
			}
			
		}
		
		return problem18(newPyramid);
	}
	
	/**
	 * You are given the following information, but you may prefer to do some research for yourself.

		1 Jan 1900 was a Monday.
		Thirty days has September,
		April, June and November.
		All the rest have thirty-one,
		Saving February alone,
		Which has twenty-eight, rain or shine.
		And on leap years, twenty-nine.
		A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
		How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
	 * @return
	 */
	public int problem19() {
		
		int[] months = new int[12];
		
		months[0] = 31;
		months[1] = 28;
		months[2] = 31;
		months[3] = 30;
		months[4] = 31;
		months[5] = 30;
		months[6] = 31;
		months[7] = 31;
		months[8] = 30;
		months[9] = 31;
		months[10] = 30;
		months[11] = 31;
		
		int offsetToSunday = 5;
		
		int sunday = 0;
		
		for(int i=1901;i<=2000;i++) {
			if((i%100 != 0 && i%4 == 0) || (i%100 == 0 && i%400 == 0)) {
				months[1] = 29;
			} else {
				months[2] = 28;
			}
			
			for(int j=0;j<months.length;j++) {
				int days = months[j];
				
				days -= offsetToSunday;
				
				while(days > 0) {
					days -= 7;
				}
				
				if(days == -1) {
					sunday++;
				}
				
				offsetToSunday = (7 - (days + 1));
			}
			
		}
		
		return sunday;
	}
	
	protected String numberToWords(int number) {
		
		StringBuilder word = new StringBuilder();
		
		int thousands = number / 1000;
		if(thousands > 0) {
			word.append(dictionary(thousands)).append(" ").append(dictionary(1000));
			
			if(number - (thousands * 100) > 0) {
				word.append(" ");
			}
		}
		
		int hundredsNo = number - (thousands * 1000);
		int hundreds = hundredsNo / 100;
		if(hundreds > 0) {
			word.append(dictionary(hundreds)).append(" ").append(dictionary(100));
			
			if(hundredsNo - (hundreds * 100) > 0) {
				word.append(" and ");
			}
		}
		
		int tensNo = hundredsNo - (hundreds * 100);
		
		if(tensNo > 20) {
			int tens = tensNo / 10;
			if(tens > 0) {
				word.append(dictionary(tens * 10));
				if(tensNo - (tens * 10) > 0) {
					word.append("-");
				}
			}
			int ones = tensNo - (tens * 10);
			if(ones > 0) {
				word.append(dictionary(ones));
			}
		} else {
			word.append(dictionary(tensNo));
		}
		
		return word.toString();
	}

	private String dictionary(int number) {
		
		switch(number) {
			case 1 : return "one";
			case 2 : return "two";
			case 3 : return "three";
			case 4 : return "four";
			case 5 : return "five";
			case 6 : return "six";
			case 7 : return "seven";
			case 8 : return "eight";
			case 9 : return "nine";
			case 10 : return "ten";
			case 11 : return "eleven";
			case 12 : return "twelve";
			case 13 : return "thirteen";
			case 14 : return "fourteen";
			case 15 : return "fifteen";
			case 16 : return "sixteen";
			case 17 : return "seventeen";
			case 18 : return "eighteen";
			case 19 : return "nineteen";
			case 20 : return "twenty";
			case 30 : return "thirty";
			case 40 : return "forty";
			case 50 : return "fifty";
			case 60 : return "sixty";
			case 70 : return "seventy";
			case 80 : return "eighty";
			case 90 : return "ninety";
			case 100 : return "hundred";
			case 1000 : return "thousand";
		}
		
		return "";
	}
	
	private BigInteger factorial(BigInteger number) {
		BigInteger answer = number;
		for(BigInteger i=number.subtract(new BigInteger("1")); i.compareTo(new BigInteger("0")) > 0; i=i.subtract(new BigInteger("1"))) {
			answer = answer.multiply(i);
		}
		
		return answer;
	}
	
	private long halfEven(long number) {
		return number / 2;
	}
	
	private long tripleOdd(long number) {
		return (number * 3) + 1;
	}
	
	public static class LargeNumber {
		
		int[] number;
		
		public LargeNumber() {
			this.number = new int[1];
		}
		
		public LargeNumber(int length) {
			this.number = new int[length];
		}
		
		public LargeNumber(String number) {
			this.number = new int[number.length()];
			
			for(int i=0;i<number.length();i++) {
				this.number[i] = Character.getNumericValue(number.charAt(i));
			}
		}
		
		public int length() {
			return this.number.length;
		}
		
		public int getIndex(int i) throws Exception {
			if(i >= 0 && i < number.length) {
				return number[i];
			} else {
				throw new Exception("ArrayOutOfBounds!");
			}
		}
		
		@Override
		public boolean equals(Object other) {
			if(other == null || !(other instanceof LargeNumber)) return false;
			
			return this.toString().equals(other.toString());
		}
		
		@Override
		public int hashCode() {
			return this.toString().hashCode();
		}
		
		public void setIdx(int idx, int digit) {
			number[idx] = digit;
		}

		@Override
		public String toString() {
			StringBuilder numStr = new StringBuilder();
			for(int i=0;i<number.length;i++) {
				numStr.append(String.valueOf(number[i]));
			}
			return numStr.toString();
		}
		
		public LargeNumber add(LargeNumber other) throws Exception {
			
			int otherLength = other.length();
			int myLength = this.length();
			int[] addedNumber = null;
			
			if(otherLength > myLength) {
				addedNumber = new int[otherLength+1];
			} else {
				addedNumber = new int[myLength+1];
			}
			
			int carryOver = 0;
			for(int i=myLength-1,j=otherLength-1,k=addedNumber.length-1;i>=0 || j>=0;i--,j--,k--) {
				
				int numOne = 0;
				if(j >= 0) {
					numOne = other.getIndex(j);
				}
				
				int numTwo = 0;
				if(i >= 0) {
					numTwo = this.getIndex(i);
				}
				
				int sum = numOne + numTwo + carryOver;
				
				if(sum > 9) {
					addedNumber[k] = sum - 10;
					carryOver = 1;
				} else {
					addedNumber[k] = sum;
					carryOver = 0;
				}
			}
			
			if(carryOver == 1) {
				addedNumber[0] = 1;
			}
			
			StringBuilder largeNoStr = new StringBuilder(); 
			for(int i=0;i<addedNumber.length;i++) {
				if(i!=0 || addedNumber[i] > 0) {
					largeNoStr.append(addedNumber[i]);
				}
			}
			
			LargeNumber myAddedNumber = new LargeNumber(largeNoStr.toString());
			
			return myAddedNumber;
		}
		
		public LargeNumber multiply(LargeNumber other) throws Exception {
			LargeNumber shorterLength = other.length() > this.length() ? this : other;
			LargeNumber longerLength = other.length() <= this.length() ? this : other;
			
			LargeNumber[] sumProduct = new LargeNumber[shorterLength.length()];
			
			for(int i=shorterLength.length()-1, i2=0;i >= 0; i--,i2++) {

				int carryOver = 0;
				int product = 0;

				sumProduct[i2] = new LargeNumber(longerLength.length() + i2 + 1);
				int sumProductIdx = sumProduct[i2].length()-1 - i2;
				
				for(int j=longerLength.length()-1; j >= 0; j--) {
					
					product = shorterLength.getIndex(i) * longerLength.getIndex(j);
					product += carryOver;
					
					int digit = product % 10;
					
					if(product > 9) {
						carryOver = Math.floorDiv(product, 10);
					} else {
						carryOver = 0;
					}
					
					sumProduct[i2].setIdx(sumProductIdx--, digit);
					
				}
				
			}
			
			LargeNumber finalProduct = sumProduct[0];
			
			for(int i=1;i<sumProduct.length;i++) {
				finalProduct = finalProduct.add(sumProduct[i]);
			}
			
			return finalProduct;
		}
		
	}

	/**
	 * n! means n × (n − 1) × ... × 3 × 2 × 1

		For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
		and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
		
		Find the sum of the digits in the number 100!
	 * @return
	 */
	public int problem20(int factorial) throws Exception {
		
		LargeNumber ln;
		LargeNumber prdt = new LargeNumber(String.valueOf(factorial));
		
		for(int i = factorial-1; i >= 1; i--) {
			ln = new LargeNumber(String.valueOf(i));
			prdt = prdt.multiply(ln);
		}
		
		int sum = 0;
		
		for(int i=0;i<prdt.length();i++) {
			sum += prdt.getIndex(i);
		}
		
		return sum;
	}

	
}
