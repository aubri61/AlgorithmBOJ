
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        // 코드 작성

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            if (st.nextToken().equals("1")) {
                arr[i + 1] = 1;
            }
        }

        // System.out.printf("처음 리셋 하고 arr: %s%n",
        // Arrays.toString(Arrays.copyOfRange(arr, 1, N + 1)));

        int caseNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < caseNum; i++) {
            String[] vals = br.readLine().split(" ");

            int sex = Integer.parseInt(vals[0]);
            int num = Integer.parseInt(vals[1]);

            // System.out.printf("현재 %d 번째 보는 중 %s이고 숫자는 %d%n", i + 1, sex == 1 ? "남자" :
            // "여자", num);

            // 남학생
            if (sex == 1) {
                // System.out.println("남자에요");
                for (int j = 1; j <= N; j++) {
                    if (j % num == 0) {
                        arr[j] = arr[j] == 1 ? 0 : 1;
                    }
                }
            } else {
                int start = num;
                int end = num;

                // System.out.printf("여자네요. 처음 start, end: [%d, %d]%n", start, end);

                while (arr[start] == arr[end] && start > 0 && end <= N) {
                    // 왼쪽
                    int leftT = start - 1;
                    int rightT = end + 1;

                    if (leftT > 0 && rightT <= N && arr[leftT] == arr[rightT]) {
                        start = leftT;
                        end = rightT;
                    } else {
                        break;
                    }
                }

                // System.out.printf("이제 뒤집을 건데 여기부터[%d, %d]까지%n", start, end);

                for (int j = start; j <= end; j++) {
                    arr[j] = arr[j] == 1 ? 0 : 1;
                }
            }

            // System.out.printf("한번 하고 나서 arr: %s%n",
            // Arrays.toString(Arrays.copyOfRange(arr, 1, N + 1)));
            // System.out.println("----------");

        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(arr[i] + " ");

            if (i % 20 == 0) {
                sb.append("\n");
            }
        }
        System.out.println(sb);

        // System.out.println(Arrays.toString(Arrays.copyOfRange(arr, 1, N + 1)));
    }
}
