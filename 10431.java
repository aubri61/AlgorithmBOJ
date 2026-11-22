
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        // 코드 작성

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int t = 0;

        while (t < num) {
            String line = br.readLine();

            StringTokenizer st = new StringTokenizer(line);

            // System.out.println("line: " + line);
            // System.out.println("token count: " + st.countTokens());

            int caseNum = Integer.parseInt(st.nextToken());
            int count = 0;

            Deque<Integer> stack = new ArrayDeque<>();
            Deque<Integer> temp = new ArrayDeque<>();

            for (int i = 0; i < 20; i++) {
                int curNum = Integer.parseInt(st.nextToken());
                if (stack.isEmpty()) {
                    stack.push(curNum);
                } else {

                    while (!stack.isEmpty() && stack.peek() > curNum) {
                        temp.push(stack.pop());
                        count++;
                    }

                    stack.push(curNum);

                    while (!temp.isEmpty()) {
                        stack.push(temp.pop());
                    }

                }

            }

            System.out.printf("%d %d%n", caseNum, count);
            t++;
        }

    }
}
