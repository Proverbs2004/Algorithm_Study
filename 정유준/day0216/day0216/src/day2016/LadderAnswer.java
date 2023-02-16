package day2016;

import java.util.Scanner;

public class LadderAnswer {
	static Scanner sc = new Scanner(System.in);
	static int[] deltaRow = { -1, 0, 0 };
	static int[] deltaCol = { 0, -1, 1 };

	static final int UP = 0;
	static final int LEFT = 1;
	static final int RIGHT = 2;

	static int[][] map;
	static int endRow;
	static int endCol;

	static void input() {
		// 테스트 케이스 번호
		int testCaseNum = sc.nextInt();

		map = new int[100][100];

		for (int row = 0; row < 100; row++) {
			for (int col = 0; col < 100; col++) {
				map[row][col] = sc.nextInt();

				// 종료위치면 해당 위치를 담아둔다.
				if (map[row][col] == 2) {
					endRow = row;
					endCol = col;
				}
			}
		}
	}

	static void findWay() {
		int direction = UP;

		// 마지막 도착하는 곳이 출발점.
		// 출발점이라는 것은 어떻게 알아야 할까? -> row = 0

		int nextRow = endRow;
		int nextCol = endCol;

		while (nextRow != 0) {
			// 다음 좌표로 이동을 해보자
			nextRow = endRow + deltaRow[direction];
			nextCol = endCol + deltaCol[direction];

			// 위로 올라가면서
			// 왼쪽이나 오른쪽으로 갈 수 있는지 확인해야함
			if (direction == UP) {
				// 왼쪽에 1이 있으면 왼쪽으로 가야한다.
				if (nextCol > 0 && map[nextRow][nextCol - 1] == 1) {
					direction = LEFT;
				}

				// 오른쪽에 1이 있으면 오른쪽으로 가야한다.
				if (nextCol < 99 && map[nextRow][nextCol + 1] == 1) {
					direction = RIGHT;
				}
			}
			// 왼쪽으로 가는 상태 / 오른쪽으로 가능 상태
			// 위로 갈 수 있는지 확인
			else if (direction == LEFT || direction == RIGHT) {
				// 위로 갈 수 있다.
				if (map[nextRow - 1][nextCol] == 1) {
					direction = UP;
				}
			}

			// 좌표 갱신해주어야함
			endRow = nextRow;
			endCol = nextCol;
		}
	}

	static void solve() {
		for (int tc = 1; tc <= 10; tc++) {
			input();
			findWay();
			System.out.println("#" + tc + " " + endCol);
		}
	}

	public static void main(String[] args) {
		// 도착점부터 시작하면 한번에 답을 알 수 있다.
		solve();
	}
}
