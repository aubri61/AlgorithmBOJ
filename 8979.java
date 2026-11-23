
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        // 코드 작성

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] cases = new int[N][4];
        int[] target = new int[4];

        for (int i = 0; i < N; i++) {

            String[] line = br.readLine().split(" ");

            int idx = Integer.parseInt(line[0]);
            int gold = Integer.parseInt(line[1]);
            int silver = Integer.parseInt(line[2]);
            int bronze = Integer.parseInt(line[3]);

            if (idx == K) {
                target = new int[]{idx, gold, silver, bronze};
            }

            // System.out.printf("%d 번째 메달 -> 금: %d, 은: %d, 동: %d%n", idx, gold, silver, bronze);

            cases[i] = new int[]{idx, gold, silver, bronze};
        }

        int rating = 1;

        for (int i = 0; i < N; i++) {

            int[] cur = cases[i];

            if (cur[0] == K) {
                continue;
            }

            if (cur[1] > target[1]) {
                rating++;
            } else if (cur[1] == target[1]) {
                if (cur[2] > target[2]) {
                    rating++;
                } else if (cur[2] == target[2]) {
                    if (cur[3] > target[3]) {
                        rating++;
                    }
                }
            }
        }

        System.out.println(rating);
    }
}
