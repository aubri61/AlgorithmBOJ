
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        // 코드 작성

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        int max = 0;

        for (int i = 1; i <= N; i++) {
            String[] line = br.readLine().split(" ");
            int time = Integer.parseInt(line[0]);
            int money = Integer.parseInt(line[1]);

            // System.out.printf("%d 번째 보는 중입니다 -> 걸리는 시간 %d, 돈은 %d%n", i, time, money);
            // System.out.printf("현재 dp 값: %d%n", dp[i]);
            dp[i] = Math.max(dp[i], dp[i - 1]);

            if (i + time - 1 <= N) {
                dp[i + time - 1] = Math.max(dp[i - 1] + money, dp[i + time - 1]);
            }

            // System.out.println("------");
        }

        for (int i = 1; i <= N; i++) {
            max = Math.max(max, dp[i]);
        }

        // System.out.println(Arrays.toString(dp));
        System.out.println(max);
    }

}
