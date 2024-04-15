package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class q2075 {

    static long [][] arr;
    static int N;
    static PriorityQueue<Long> big = new PriorityQueue<>(Comparator.reverseOrder());

    public static void main (String [] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new long [N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                long temp = Long.parseLong(st.nextToken());
                arr[i][j] = temp; big.add(temp);
            }
        }

        long num = 0;
        for (int i = 0; i < N; i++) {
            num = big.poll();
        }

        System.out.println(num);
    }
}
