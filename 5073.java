
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        // 코드 작성

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;
        int a, b, c;

        while ((input = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            Set<Integer> set = new HashSet<>();

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0 && c == 0) {
                break;
            }

            int max = Math.max(a, b);
            max = Math.max(max, c);

            int sum = a + b + c - max;

            if (sum <= max) {
                System.out.println("Invalid");
                continue;
            }

            set.add(a);
            set.add(b);
            set.add(c);

            if (set.size() == 1) {
                System.out.println("Equilateral");
            } else if (set.size() == 2) {
                System.out.println("Isosceles");
            } else {

                System.out.println("Scalene");

            }

        }

    }
}


//최적 풀이
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        StringBuilder sb = new StringBuilder();
        String input;

        while ((input = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0 && c == 0) {
                break;
            }

            int max = Math.max(a, Math.max(b, c));

            if (a + b + c - max <= max) {
                sb.append("Invalid\n");
            } else if (a == b && b == c) {
                sb.append("Equilateral\n");
            } else if (a == b || b == c || a == c) {
                sb.append("Isosceles\n");
            } else {
                sb.append("Scalene\n");
            }
        }

        System.out.print(sb);
    }
}