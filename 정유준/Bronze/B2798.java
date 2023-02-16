import java.util.Scanner;

public class B2798 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cardNum = sc.nextInt();
		int dealerNum = sc.nextInt();
		int[] cardArr= new int[cardNum];
		
		int sum = 0;
		int result = 0;
		//카드값 입력받기
		for(int idx = 0; idx < cardNum; idx++) {
			cardArr[idx] = sc.nextInt();
		}
		
		//for문 3개돌리면서 최소차이 찾기 ^^
		for(int i = 0; i < cardNum; i++) {
			for(int j = i+1; j < cardNum; j++) {
				for(int z = j+1; z < cardNum; z++) {
					sum = cardArr[i] + cardArr[j] + cardArr[z];
					if(sum <= dealerNum && result < sum) {
						result = sum;
					}
				}
			}
		}
		
		System.out.println(result);
	}
}
