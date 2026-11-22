
import java.io.IOException;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        // 코드 작성
        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int W = sc.nextInt();
        int N = sc.nextInt();
        int M = sc.nextInt();


        int res = 0;

        res += (int) Math.ceil((double)W/(M+1));
        res *= (int) Math.ceil((double)H/(N+1));

        System.out.println(res);

    }
}
