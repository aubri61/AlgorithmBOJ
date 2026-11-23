
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        // 코드 작성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;

        while (!(line = br.readLine()).equals("end")) {

            String res = "acceptable.";

            int vowelCount = 0;
            int consoCount = 0;
            boolean hasVowel = false;
            char pre = '1';

            //조건
            //1. 모음 반드시 한개 -> 체크 여부
            //2. 모음 3개 연속/자음 3개연속 ㄴㄴ
            //3. 같은 글자 연속 두번 x but ee, oo ㅇㅋ
            for (char c : line.toCharArray()) {

                if (pre == c && !(c == 'e' || c == 'o')) {
                    res = "not acceptable.";
                    break;
                }

                boolean isVowel = "aeiou".indexOf(c) >= 0;

                if (isVowel) {
                    hasVowel = true;
                    vowelCount++;
                    consoCount = 0;

                    if (vowelCount == 3) {
                        res = "not acceptable.";
                        break;
                    }
                } else {
                    consoCount++;
                    vowelCount = 0;
                    if (consoCount == 3) {
                        res = "not acceptable.";
                        break;
                    }
                }

                pre = c;

            }

            if (!hasVowel) {
                res = "not acceptable.";

            }

            System.out.printf("<%s> is %s%n", line, res);

        }

    }
}
