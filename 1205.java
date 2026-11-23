
import java.io.*;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        // 코드 작성

        //N = 다음에 들어올 인풋 갯수 / 첫줄 2번째: 태수 점수 / 첫줄 3번째: P. limit(랭킹 리밋)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());

        if (N == 0) {
            System.out.println("1");
            return;
        }

        st = new StringTokenizer(br.readLine());

        int res = -1;
        int pre = 0;

        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());

            // System.out.printf("현재 %d번째 돌고 값은: %d, pre: %d, rank: %d%n", i+1, cur, pre, rank);
            if (cur == score && res == -1) {
                res = i + 1;
                //일단 대기해야함 왜냐면 마지막 원소 보고 자리 잇는지 체크해야하니까.
                if (limit - N > 0) {
                    System.out.println(res);
                    return;
                }
                // System.out.printf("같아요. found: %d, rank: %d%n", found, rank);
            } else if (cur < score && res == -1) {
                System.out.println(i + 1);
                // System.out.printf("더 작은 애를 찾앗어. found: %d, rank: %d%n", found, rank);
                return;
            }
            pre = cur;
            // System.out.println("----------");
        }

        //가장 작은 수지만 아직 여유있을땐 마지막 랭킹에 올라감
        if (res == -1 && limit - N > 0) {
            res = N + 1;
        }
        // System.out.printf("끝나고 나서.. rank: %d, found: %d%n ", rank, found);

        //갱신 안 되는 경우 -> 같은 원소인데 아직 그거보다 작은 원소가 안나오고 같은 걸로 끝났을 때.
        if (limit - N == 0 && pre >= score) {
            res = -1;
        }

        System.out.println(res);

    }
}
