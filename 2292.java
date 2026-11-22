
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        // 코드 작성

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());

        if (input == 1) {
            System.out.println("1");
            return;
        }

        // System.out.printf("input은: %d%n", input);
        int sum = 0;
        input -= 1;

        int q = (int) Math.ceil((double) input / 6);

        for (int i = 1; i < 1000000000; i++) {

            sum += i;

            if (sum >= q) {
                System.out.println(i+1);
                return;
            }

        }

    }
}
