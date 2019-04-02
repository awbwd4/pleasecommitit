package recursion;

public class Recursion {

	public static void main(String[] args) {
		
		int data[] = {1,2,3,4,5};
		
		
		/*
		int result = sum(4);

		System.out.println(result);
		
		
		System.out.println(gcd(100, 28));
		
		System.out.println(length("qwerqwer"));
		
		printCharsReverse("asdf");
		 */
		
		printInBinary(10);
	
		System.out.println();
		
		System.out.println(sum(data.length, data));
		
		
	}
/*
	public static int sum(int n) {
		// 이 함수의 미션은 0~n 까지의 합을 구하는 것
		if (n <= 0) {
			return 0; // n == 0  이라면 합은 0이다
		} else {
			return n + sum(n - 1);
			//n이 0보다 크다면 [0에서 n까지의 합]은 [0에서 n-1까지의 합]에 n을 더한것이다. 
			//[0에서 n-1까지의 합]은 [0에서 n-2]까지의 합에 n-1을 더한 것이다. 
		}

		
		
	}

	
	public static int gcd(int m, int n) {
		if (n == 0) {
			return m;
		} else {
			return gcd(n, m%n);
		}
		
	}

	public static int length(String str) {
		if (str.equals("")) {
			return 0;
		} else {
			return 1+length(str.substring(1));
		}
		
		
	}
	
	public static void printCharsReverse(String str) {
		
		if (str.equals("")) {
			return;
		}else {
			
			printCharsReverse(str.substring(1));
			System.out.print(str.charAt(0));
		}
		
		
	}

 */
	
	public static void printInBinary(int n) {
		
		if (n < 2) {
			System.out.print(n);
		} else {
			
			printInBinary(n/2);
			System.out.print(n%2);
			
		}
	}
	
	public static int sum(int n, int[] data) {
		
		if (n == 0) {
			return 0;
		}else {
			return sum(n-1, data)+data[n-1];
		}
		
		
	}
	
	public static int search(int[] data, int target, int begin, int end) {
		
		if (begin > end) {
			return -1;
		}else if(target == data[begin]){
			return begin;
		}else{
			return search(data, target, begin+1, end);
		}
		
		
	}
	
	

}
