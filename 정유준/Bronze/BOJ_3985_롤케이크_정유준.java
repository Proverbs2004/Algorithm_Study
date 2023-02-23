import java.util.Scanner;

public class BOJ_3985_롤케이크_정유준 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int L = scan.nextInt(); // 롤케이크 길이
        int N = scan.nextInt(); // 방청객의 수
        boolean[] cake = new boolean[L + 1]; // 케이크 실제로 받았는지 여부
        int[] getCake = new int[N + 1];
        int[][] arr = new int[N][2];
        int want = 0; // 가장 많은 조각 기대
        int real = 0; // 실제 가장 많은 조각
        for (int i = 0; i < N; i++) {
            arr[i][0] = scan.nextInt();
            arr[i][1] = scan.nextInt();
        }

        // 가장 많은 조각을 받을 것으로 기대한 케이크의 조각 수 찾기
        // 1 에 큰값 0에 작은값 넣어서 두개 빼줌으로써 갯수 계산
        for (int i = 0; i < N; i++) {
            if (arr[i][1] - arr[i][0] > want)
                want = arr[i][1] - arr[i][0];
        }

        // 실제 가장 많은 조각 받은 방청객 찾기
        for (int i = 1; i <= N; i++) {
            for (int j = arr[i - 1][0]; j <= arr[i - 1][1]; j++) {
                if (!cake[j]) { // 방청객이 기대한 번호가 체크가 안되어 있는경우
                    getCake[i]++; // i번째 방청객 케이크 +1
                    cake[j] = true; // 케이크를 받았으므로 체크표시
                }
            }
        }

        // 방청객 중 가장 많은 조각을 받은 케이크 수 찾기
        for (int i = 1; i < getCake.length; i++) {
            if (getCake[i] > real)
                real = getCake[i];
        }

        // 가장 많은 조각을 받을 것으로 기대하고 있던 방청객이 여러명인 경우 => 번호가 작은 사람 출력
        for (int i = 1; i <= N; i++) {
            if (want == arr[i - 1][1] - arr[i - 1][0]) {
                System.out.println(i);
                break;
            }
        }
        // 실제 가장 많은 조각을 받은 방청객이 여러명인 경우 => 번호가 작은 사람 출력
        for (int i = 1; i < getCake.length; i++)
            if (getCake[i] == real) {
                System.out.println(i);
                break;
            }

        scan.close();
    }
}
