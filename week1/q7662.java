package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class q7662 {

    static HashMap<Integer, Integer> map;

    public static void main(String [] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine()); //T개의 테스트 데이터

        for (int i = 0; i < T; i++) {

            int k = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> min = new PriorityQueue<>(); // 최소힙, 큰 절반
            PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder()); // 최대힙, 작은
            map = new HashMap<>(); int temp = 0; int temp1 = 0;

            for (int j = 0; j < k; j++) {

                String input = br.readLine();
                StringTokenizer st = new StringTokenizer(input, " ");

                String dOrI = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (Objects.equals(dOrI, "I")) {
                    min.add(num); max.add(num); map.put(num, map.getOrDefault(num, 0)+1);
                }
                else if (Objects.equals(dOrI, "D")) {

                    if (num == -1) { //최솟값 삭제
                        remove(min);
                    } else if (num == 1) { //최댓값 삭제
                        remove(max);
                    }
                }
            }
            if(!map.isEmpty()) {
                temp = remove(max); temp1 = remove(min);
                sb.append(temp).append(" ").append(temp1).append("\n");
            } else {
                sb.append("EMPTY\n");
            }
        }
        System.out.println(sb.toString());
    }

    public static int remove (PriorityQueue<Integer> queue) {

        while (true) {

            if(!queue.isEmpty()) {
                int result = queue.poll();

                if (map.getOrDefault(result, 0) == 0) {
                    continue;
                } else if (map.getOrDefault(result, 0) == 1) {
                    map.remove(result);
                    return result;
                } else {
                    map.put(result, map.getOrDefault(result, 0) - 1);
                    return result;
                }
            } else return 0;
        }
    }
}
