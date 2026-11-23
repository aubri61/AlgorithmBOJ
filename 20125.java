
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        // 코드 작성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] coord = new int[N][N];

        int[] head = new int[]{-1, -1};
        boolean headExist = false;

        int leftArm=0;
        int rightArm=0; 
        int leftLeg=0;
        int rightLeg=0;
        int waist = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            int rowStart = N + 1;
            int rowEnd = -1;

            for (int j = 0; j < N; j++) {
                coord[i][j] = line.charAt(j) == '_' ? 0 : 1;

                if (line.charAt(j) == '*' && head[0] == -1 && head[1] == -1) {
                    head = new int[]{i, j};
                    headExist = true;
                }

                if (line.charAt(j) == '*' && headExist) {
                    rowStart = Math.min(j, rowStart);
                    rowEnd = Math.max(rowEnd, j);
                }
            }

            //팔 이후 첫 다리
            if (leftArm >0 && rightArm >0 && rowEnd-rowStart >0 && waist ==0) {
                waist = i-(head[0]+2);
                leftLeg = 1;
                rightLeg = 1;
                continue;
            }

            //다리 이후
            if (leftLeg>0 && rightLeg>0 && rowEnd!=-1) {
                if (rowStart!=rowEnd ) {
                    leftLeg++;
                    rightLeg++;
                } else {
                    if (rowStart!=N+1 ) {
                        if( rowStart<head[1]) {

                        leftLeg++;
                        } else {
                            rightLeg++;
                        }
                    }
                }
            }

            // System.out.printf("rowSatrt: %d, rowEnd: %d, %n", rowStart, rowEnd);

            if (headExist && i == head[0] + 1) {

                leftArm = head[1] - rowStart;
                rightArm = rowEnd - head[1];

            }

        }

        int[] heart = new int[]{head[0] + 1, head[1]};

        // System.out.printf("head: [%d, %d]%n", head[0], head[1]);
        // System.out.printf("heart: [%d, %d]%n", heart[0], heart[1]);

        System.out.printf("%d %d%n", heart[0]+1, heart[1]+1);
        System.out.printf("%d %d %d %d %d%n", leftArm, rightArm, waist, leftLeg, rightLeg);

    
    }

}
