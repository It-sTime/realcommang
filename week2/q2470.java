package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class q2470 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Long> arr = new PriorityQueue<>();
        ArrayList<Long> arrayList = new ArrayList<>();
        TreeMap<Long, Long[]> minuses = new TreeMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            arr.add(Long.parseLong(st.nextToken()));
        }

        for (int i = 0; i < N; i++) {
            arrayList.add(arr.poll());
        }

        int i = 0; int j = arrayList.size()-1;
        long minus = Math.abs(arrayList.get(j) + arrayList.get(0));

        while (i < j) {

             long temp = arrayList.get(j) + arrayList.get(i);
             long tempABS = Math.abs(temp);

             //System.out.println(tempABS);

             if (tempABS <= minus) {
                 minuses.put(tempABS, new Long[] {arrayList.get(i), arrayList.get(j)});
                 i++; minus = tempABS;
             } else {
                 j--;
             }
        }

        if (!minuses.isEmpty()) {
            Long[] result;
            result = minuses.get(minuses.firstKey());
            System.out.println(result[0] + " " + result[1]); //+ " " + minuses.get(idx)[1]);
        }
//        } else {
//            System.out.println(arrayList.get(0) + " " + arrayList.get(arrayList.size()-1));
//        }
    }
}
