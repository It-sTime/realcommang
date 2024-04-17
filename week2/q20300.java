package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class q20300 {

    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Long> health = new ArrayList<>(); //근손실 정도
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            health.add(Long.parseLong(st.nextToken()));
        }
        Collections.sort(health);
        int temp = N%2; long MAX = Long.MIN_VALUE;
        if (temp == 0) {
            for (int i = 0; i < (N/2) +1; i++) {
                long sum = health.get(i) + health.get(N-1-i);
                MAX = Math.max(sum, MAX);
            }
        } else {
            MAX = health.get(N-1);
            for (int i = 0; i < (N/2)+1; i++) {
                long sum = health.get(i) + health.get(N-i-2);
                MAX = Math.max(sum, MAX);
            }
        }
        System.out.println(MAX);
    }
}
