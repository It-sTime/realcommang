package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class q20728 {
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 첫 번째 줄에서 테스트 케이스의 수를 읽어옵니다.

        for (int i = 0; i < N; i++) {

            String[] line = br.readLine().split(" "); // 다음 줄을 읽어서 공백을 기준으로 분리합니다.
            int size = Integer.parseInt(line[1]); // 나눠줄 주머니 크기

            String[] line1 = br.readLine().split(" ");
            long[] candies = new long[line1.length];

            for (int j = 0; j < line1.length; j++) {
                candies[j] = Long.parseLong(line1[j]); // 사탕 배열을 long 타입으로 파싱하여 저장
            }

            Arrays.sort(candies); // 사탕 배열 정렬 큰수부터

            Long MIN = Long.MAX_VALUE; long small; long big;

            for (int k = line1.length-1; k >= size-1; k--) {

                big = candies[k];

              if ((k-size+1) >= 0) {
                  small = candies[k-size+1];
                  if(big-small < MIN) MIN = big-small;
                  if (MIN == 0) break;
              }

            }
            System.out.println("# " + i + " " + MIN);
        }

        br.close(); // 리소스 해제
    }
}
