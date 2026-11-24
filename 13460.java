import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        // 코드 작성

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 세로
        int M = Integer.parseInt(st.nextToken()); // 가로

        char[][] board = new char[N][M];

        int[] red = new int[] { -1, -1 };
        int[] blue = new int[] { -1, -1 };
        int[] target = new int[] { -1, -1 };

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            // . = 0 , # = -1 , O = 100, R = 1, B=2
            for (int j = 0; j < M; j++) {
                char c = line.charAt(j);
                board[i][j] = c;

                switch (c) {
                    case 'O' -> target = new int[] { i, j };
                    case 'R' -> {
                        red = new int[] { i, j };
                        board[i][j] = '.';
                    }
                    case 'B' -> {
                        blue = new int[] { i, j };
                        board[i][j] = '.';
                    }
                }

            }
        }

        // System.out.println(Arrays.deepToString(board));
        // System.out.printf("red: %s, blue: %s, target: %s%n", Arrays.toString(red),
        // Arrays.toString(blue),
        // Arrays.toString(target));

        // 레드부터 시작하는데. 타겟으로 가야하는 최소거리

        // [row, col, blue row, blue col, count] count: 현재까지 움직인 횟수
        Deque<int[]> path = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        path.offer(new int[] { red[0], red[1], blue[0], blue[1], 0 });

        // System.out.printf("시작 전 path: %s *************%n%n%n",
        // Arrays.deepToString(path.toArray()));

        int[][] DIRS = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int min = Integer.MAX_VALUE;

        while (!path.isEmpty()) {
            int[] pop = path.poll();
            int count = pop[4];
            // System.out.printf("\n$$$$$$ while문 돌아요!!! pop. red: [%d, %d], blue: [%d, %d],
            // count: %d%n", pop[0], pop[1],
            // pop[2],
            // pop[3], count);
            if (count >= min) {
                // System.out.println("이미 더 커져서 안 돌아도 돼요.");
                // System.out.println("-----------\n");

                continue;
            }

            if (visited.contains(pop[0] + "," + pop[1] + "," + pop[2] + "," + pop[3])) {
                // System.out.println("방문했던 곳이라 패스할게요.");
                // System.out.println("-----------\n");
                continue;
            }

            visited.add(pop[0] + "," + pop[1] + "," + pop[2] + "," + pop[3]);

            // System.out.printf("현재 red는 [%d, %d], 블루는 [%d, %d]. 지금까지 움직인 횟수: %d%n",
            // pop[0], pop[1], pop[2], pop[3],
            // pop[4]);

            // System.out.println("이제부터 탐색할게@@@~~~~\n");

            // 사방으로 갈 수 있는 길 ㄱㄱ
            for (int i = 0; i < 4; i++) {
                int[] dir = DIRS[i];

                // System.out.printf("dir별로 감 -> 현재 %d 번째 디렉션%n", i + 1);

                // 빨강
                int row = pop[0];
                int col = pop[1];

                // 블루
                int brow = pop[2];
                int bcol = pop[3];

                int nr = row + dir[0];
                int nc = col + dir[1];

                int bnr = brow + dir[0];
                int bnc = bcol + dir[1];

                int rcount = 0;
                int bcount = 0;

                boolean arrived = false;
                boolean cannot = false;
                // System.out.printf("nr, nc : [%d, %d]%n", nr, nc);
                while (nr >= 0 && nc >= 0 && nr < N && nc < M && (board[nr][nc] == '.' || board[nr][nc] == 'O')) {
                    rcount++;
                    // System.out.printf("while문 들어왔어. board[nr][nc] = %s%n", board[nr][nc]);

                    row = nr;
                    col = nc;

                    if (board[nr][nc] == 'O') {
                        arrived = true;

                        // System.out.println("타겟에 도착함!");
                        break;
                    }

                    nr += dir[0];
                    nc += dir[1];
                }

                // System.out.printf("레드 다 돌고 나서 좌표: row, col-> [%d, %d]%n", row, col);

                // System.out.printf("이제 블루 돌차례. 원래 값은 brow, bcol => [%d, %d]이고.. 넥스트는.. [%d,
                // %d]%n", brow, bcol, bnr,
                // bnc);

                while (bnr >= 0 && bnc >= 0 && bnr < N && bnc < M
                        && (board[bnr][bnc] == '.' || board[bnr][bnc] == 'O')) {

                    // System.out.printf("블루 와일문. 얘도 움직여요.%n");
                    bcount++;
                    brow = bnr;
                    bcol = bnc;

                    if (board[bnr][bnc] == 'O') {
                        // System.out.printf("블루가 타겟을 만나버림.%n");
                        cannot = true;

                        break;
                    }

                    bnr += dir[0];
                    bnc += dir[1];
                }

                // System.out.printf("이번에 red가 간 최종 coord: [%d, %d]%n", row, col);
                // System.out.printf("이번에 blue가 간 최종 coord: [%d, %d]%n", brow, bcol);

                if (!cannot) {
                    if (arrived) {
                        min = Math.min(min, count + 1);
                        // System.out.println("도착해가지고 패스 추가 안할게.");
                    } else {

                        if (row == brow && col == bcol) {
                            if (rcount > bcount) {
                                row -= dir[0];
                                col -= dir[1];
                            } else {
                                brow -= dir[0];
                                bcol -= dir[1];
                            }
                        }

                        // System.out.println("이번엔 갈 수 있어서 path에 추가할게.");
                        path.offer(new int[] { row, col, brow, bcol, count + 1 });
                    }
                }
                // System.out.println("----------------\n\n");

            }

        }

        System.out.println(min == Integer.MAX_VALUE || min > 10 ? -1 : min);

    }

}