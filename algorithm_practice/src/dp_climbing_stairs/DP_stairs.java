package dp_climbing_stairs;

public class DP_stairs {

	public static int minCostClimbingStairs(int[] cost) {
		int case1 = 0, case2 = 0, current;
		//매 계단마다 경우의 수가 두가지 있음. 한칸더 갈지 두칸 더 갈지
		//current 현재 계단의 비용을 임시로 저장할 변수 
		//ㄴㅁㅇㄴㅇㄹㄴㅇ
		for (int i = cost.length -1; i >= 0; i--) {
			//계단의 뒤에서 앞으로 오면서 각 계단을 밟을때 발생하는 최소 비용을 계산.
			current = cost[i] + Math.min(case1, case2);
			//그 다음 앞에 있는 계단의 계산을 위해, 계단들을 각각 한칸씩 옮겨줌
			
			case2 = case1;//지금 한칸 옆에 있는 계단은 다음번에는 두칸 옆에 있는 계단으로
			case1 = current; //지금 밟고있는 계단은 다음번에는 한칸 옆에있는 계단이 됨.
		}
		//다 해서 i=0까지 왔을경우! 0번방에서 시작햇을때와 1번방에서 시작했을때의 케이스가 여전히 남음
		return Math.min(case1, case2);
		
	}
	
	
	public static void main(String[] args) {
		
		int[] cost = {1,100,1,1,1,100,1,1,100,1};
		int result = minCostClimbingStairs(cost);
		System.out.println(result);
		
		
	}


}
