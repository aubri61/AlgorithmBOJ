
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        // 코드 작성

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String target1 = "KBS1";
        String target2 = "KBS2";

        int kbs1Idx = -1;
        int kbs2Idx = -1;

        String res = "";

        for (int i = 0; i < N; i++) {
            String chan = br.readLine();

            if (chan.equals(target2)) {
                kbs2Idx = i;
            }

            if (chan.equals(target1)) {
                kbs1Idx = i;

                //일단 1번 -> 사이즈 만큼 1 한 뒤에 4 하기.
                //kb2 => 사이즈만큼 1 하고 그거 -1 만큼 4하면 됨.
                //쟁점: kbs1보다 kbs2가 위에 잇을 경우. -> 이때 자리 바뀌니까.
                res += "1".repeat(i);
                res += "4".repeat(i);
            }

        }

        if (kbs2Idx < kbs1Idx) {
            res += "1".repeat(kbs2Idx + 1);
            res += "4".repeat(kbs2Idx);
        } else {
            res += "1".repeat(kbs2Idx);
            res += "4".repeat(kbs2Idx - 1);
        }

        System.out.println(res);

    }
}
