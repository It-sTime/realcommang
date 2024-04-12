import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class q7662 {

    public static void main(String [] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); //T개의 테스트 데이터

        for (int i = 0; i < T; i++) {

            int k = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> min = new PriorityQueue<>(); // 최소힙, 큰 절반
            PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder()); // 최대힙, 작은

            for (int j = 0; j < k; j++) {

                String input = br.readLine();
                StringTokenizer st = new StringTokenizer(input, " ");

                String dOrI = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (Objects.equals(dOrI, "I")) {
                    min.add(num); max.add(num);
                }
                else if (Objects.equals(dOrI, "D")) {
                    if(!min.isEmpty() && !max.isEmpty()) {
                        if (num == -1) { //최솟값 삭제
                            int temp = min.poll();
                            max.remove(temp);
                        } else if (num == 1) { //최댓값 삭제
                            int temp1 = max.poll();
                            min.remove(temp1);
                        }
                    }
                }
            }

            if(!min.isEmpty() && !max.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                sb.append(max.poll());
                sb.append(" ");
                sb.append(min.poll());
                sb.append('\n');
                System.out.println(sb.toString());
            } else {
                System.out.println("EMPTY");
            }
        }

    }
}
