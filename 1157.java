
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        // 코드 작성

        int[] arr = new int[26];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        char maxChar = '?';
        int maxCount = 0;

        for (char c : s.toLowerCase().toCharArray()) {

            arr[c - 'a']++;

            // System.out.printf("현재 char: %s, 시작할때 maxchar: %s, maxcount: %d%n", c, maxChar, maxCount);

            if (arr[c - 'a'] > maxCount) {
                maxCount = arr[c - 'a'];
                maxChar = c;
                // System.out.println("얘가 맥스보다 더 커서 새로할게요.");
                // System.out.printf("max Count: %d, maxChar: %s%n", maxCount, maxChar);
            } else if (arr[c - 'a'] == maxCount) {
                maxChar = '?';
                // System.out.println("똑같앙!!!!");
                // System.out.printf("max Count: %d, maxChar: %s%n", maxCount, maxChar);

            }
            // System.out.println("--------");

        }

        // System.out.println(Arrays.toString(arr));

        System.out.println(String.valueOf(maxChar).toUpperCase());

    }

}
