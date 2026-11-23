
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        // 코드 작성

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        String game = st.nextToken();

        int max;

        switch (game) {
            case "Y" ->
                max = 1;
            case "F" ->
                max = 2;
            case "O" ->
                max = 3;
            default -> {
                max = 0;
            }
        }

        Set<String> already = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            already.add(name);

        }

        System.out.println(already.size() / max);

    }
}
