package implementation;

public class Implementation_for {

	public static void main(String[] args) {
		int i = 0;
		int total = 0;

		/*
		
		 for(;;) {//초기부;조건부;증감부가 모두 없을 때. 
			 System.out.println(i);
			 i++; 
			 if (i<10) {
				continue; }
			 else { break; }
		 
		 }
		 
		 
		 System.out.println();
		 
		 
		 for (int j = 0; j < 10; j++) {
		 
		 System.out.println(j);
		 
		 }
		 
		 int x = 1; while (x <= 100) { System.out.println(x);
		 
		  x*=2; }
		  
		  int x = 1;
		  
		  for (; x <= 100;) {
		  
		  System.out.println(x); x *= 2;
		  
		  }
		  
		  
		  
		  
		  
		  
		  //1과 100사이의 자연수에서 2 또는 3의 배수를 출력하는 코드 for (int j = 1; j <= 100; j++) {
		  
		  if (j % 2 ==0 || j%3 == 0) { total++; System.out.println(j);
		  
		  } }
		  
		  System.out.println("total : "+total); System.out.println();
		  
		  total = 0;
		  
		  while(i < 100) {
		  
		  i++;
		  
		  if (i % 2 ==0 || i%3 == 0) { total++; System.out.println(i); }
		  
		  }
		  
		  
		  System.out.println("total : "+total);
		  

		//break와 continue
		for (int j = 0; j < 10; j++) {

			for (int j2 = 0; j2 < 20; j2++) {

				if (j == 1) {
					System.out.println("j : " +j+" break");
					break;
					
				} else if (j2 == 1) {
					//System.out.println("j : "+j+"  j2 : "+j2 +" continue");
					continue;
				
				}
				System.out.println("j : "+j+"  j2 : "+j2);
			
			}

		}
		
		*/
		
		
		
		
		exit :
			while (true) {
				System.out.println("first loop \n");
				
				while (true) {
					System.out.println("second loop \n");
				
					while (true) {
						System.out.println("third loop \n");
					
						//break;
						break exit;
					
					}
					//break;
				
				}
				//break;
				
				
				
				
			}
		
		
		
		
		

	}
}
