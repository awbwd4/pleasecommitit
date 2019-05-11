package cos_pro_ex;

public class Cos_ex1 {
	
	  public long solution(long num) {

		  int power = 0;
		  //num == 9940000  -> return 9951111
		  
		  num += 1;
		  
		  if ((num % 10) == 0) {
			///////////////////////////////////////////
			  while(true) {
				  
				  //int power = 1;
				  
				  power++;
				  if (num % Math.pow(10, power) != 0) {
					  break;
				}
			 }
		  ///////////////////////////////////////////
			  
			  for (int i = power-2; i >= 0; i--) {
				  System.out.println("i : "+i);
				num  = (long) (num+ Math.pow(10, i));
			}
			  
			  
		}
		  	System.out.println(num%10);
		  	System.out.printf("power : %d \n",power-1);
		  	System.out.println();
		  	long answer = num;
	        return answer;
	    }

	  
	  public long solution2(long num) {
	        num++;
	        
	        long digit = 1;
	        
	        while ((num/digit)%10 == 0) {
				num += digit;
	        	digit *= 10;
			}
	        
	        return num;
	    }
	  
	  
	  
	    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
	    public static void main(String[] args) {
	    	Cos_ex1 ex = new Cos_ex1();
	    	long num = 9949999;
	        long ret = ex.solution(num);
	        long ret2 = ex.solution2(num);

	        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
	        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
	        System.out.println("solution 메소드의 반환 값은2 " + ret2 + " 입니다.");
	    }
}
