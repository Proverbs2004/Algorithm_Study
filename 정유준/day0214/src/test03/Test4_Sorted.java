package test03;

public class Test4_Sorted {

	public static void main(String[] args) {
		int[] A = {2, 4, 7, 9, 11, 19, 23};
		int idx = squentialSearch(A, 4);
		System.out.println(idx);
	}	
	
	public static int squentialSearch(int[] A, int key) {
		int n = A.length;
		
		int i = 0;
		while(A[i] < key) {
			i++;
		}
		
		//while문을 빠져나온다면?
		//1. A[i] == key (i)
		//2. A[i] > key : 정렬되어있기 때문에 더 이상 볼 필요가 없다.(-1)
		if (A[i] == key) {
			return i;
		} else {
			return -1;
		}
	}
}
