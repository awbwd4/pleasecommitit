package recursion;

public class Recursion {

	/* 순환적 알고리즘 설계
	 * 1. 적어도 하나의 base case, 즉 순환되지 않고 종료되는 case가 있어야 함.
	 * 2. 모든 case는 결국 base case로 수렴돼야 함.
	 * 3. 메소드 내에서 쓰이는 모든 변수들을 다 파라미터로 지정해주어야 함.(명시적 매개변수) 
	 * */
	
	
	
	public static void main(String[] args) {
		
		int data[] = {123,1341,125,24251,123,1221};
		
		
		/*
		 */
		int result = sum(4);

		System.out.println(result);
		
		
		System.out.println(gcd(100, 28));
		
		System.out.println(length("qwerqwer"));
		
		printCharsReverse("asdf");
		
		printInBinary(10);
	
		System.out.println();
		
		System.out.println(sum(data.length, data));
		
		System.out.println("findMax2 : "+findMax2(data, 0, data.length-1));
		System.out.println("findMax3 : "+findMax3(data, 0, data.length-1));

		System.out.println();
		
	}
/*
 */
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
	
	/*	
	 */
	public static int search_loop(int[] data, int length, int target) {
		//재귀가 아닌 루프를 쓸때는 0~n-1 에서 0을 파라미터로 넣어주지 않음. 이것이 암시적 매개변수
		for (int i = 0; i < length; i++) {
			if (data[i] == target) {
				return i;
			}
		}
		return -1;
		
	}
	
	
	
	
	
	
	public static int search(int[] data, int target, int begin, int end) {
		//begin이 주어짐. 명시적 매개변수
		if (begin > end) {
			return -1;
		}else if(target == data[begin]){
			return begin;
		}else{
			return search(data, target, begin+1, end);
		}
		
		
	}
	
	public static int search1(int[] data, int target, int begin, int end) {
		
		if (begin>end) {//begin == end는 데이터가 1개라는 것. 
			return -1;
		}else if(target == data[begin]) {
			return begin;
		}else {
			return search1(data, target, begin+1, end);
		}
	}
	

	public static int search2(int[] data, int target, int begin, int end) {
		
		if (begin<end) {
			return -1;
		}else if (target == data[end]) {
			return end;
		}else {
			return search2(data, target, begin, end-1);
		}
	}
	
	//binary search와는 다름
	public static int search3(int[] data, int target, int begin, int end) {
		
		int mid = (begin+end)/2;
		int index;
		
		if (begin > end) {
			return -1;
		}else{
		
			if (data[mid]==target) {
				return mid;
			}
			
			index = search3(data, target, begin, mid-1);
			//mid 앞부분 먼저 검색
			
			if (index != -1) {
				return index;//index가 -1이 아니다 : mid앞 부분에 target값이 존재한다. 
			}else {
				//mid 앞 부분에 타겟값이 존재하지 않으면, 이제 mid 뒷부분 검색. 
				return search3(data, target, mid+1, end);
			}
		}
		
	}
	
	public static int findMax1(int[] data, int begin, int end) {
		
		if (begin == end) {
			return data[begin];//데이터가 1개밖에 없으므로
		} else {
			return Math.max(data[begin], findMax1(data, begin+1, end));
		}
	}
	
	
	public static int findMax2(int[] data, int begin, int end) {
	
		if (begin == end) {
			return data[begin];
		} else {
			return Math.max(data[begin], findMax2(data, begin+1, end));
		}
	
	}
	
	public static int findMax3(int[] data, int begin, int end) {
		
		int middle = (begin+end)/2;
		
		if (begin == end) {
			return data[begin];
		}else {
			
			int max1 = findMax3(data, begin, middle);
			int max2 = findMax3(data, middle+1, end);
			return Math.max(max1, max2);
			
			
		}
		
		
	}
	
	public static int binarySearch(String[] items, String target, int begin, int end) {
		//이진탐색의 개념자체가 재귀적 성격을 갖는다.
		
		
		if (begin>end) {
			
			return -1;
		
		} else {
			
			int middle = (begin+end)/2;
			int compResult = target.compareTo(items[middle]);
			
			if (compResult == 0) {
				
				return middle;
			
			}else if(compResult<0){
			
				return binarySearch(items, target, begin, middle-1);
			
			}else {
			
				return binarySearch(items, target, middle+1, end);
			}
		}
	}
	
	
	
	

}
