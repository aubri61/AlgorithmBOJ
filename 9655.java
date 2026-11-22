
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        // 코드 작성

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        if (num % 2 == 0) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }

    }
}
