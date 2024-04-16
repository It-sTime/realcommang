package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class q2470 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Long> arrayList = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            arrayList.add(Long.parseLong(st.nextToken()));
        }

        Collections.sort(arrayList);

        int i = 0;
        int j = arrayList.size() - 1;
        long minus = Long.MAX_VALUE;
        long result1 = 0;
        long result2 = 0;

        while (i < j) {

            long temp = arrayList.get(j) + arrayList.get(i);
            long tempABS = Math.abs(temp);

            if (tempABS <= minus) {
                result1 = arrayList.get(i);
                result2 = arrayList.get(j);
                minus = tempABS;
            }

            if (temp > 0) j--;
            else i++;
        }

        System.out.println(Math.min(result1, result2) + " " + Math.max(result2, result1));
    }
}
