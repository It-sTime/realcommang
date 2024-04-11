import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class q1655 {

    static PriorityQueue<Integer> min = new PriorityQueue<>(); // 최소힙, 큰 절반
    static PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder()); // 최대힙, 작은 절반

    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());

            if (max.size() == min.size()) {
                max.add(input);
            } else {
                min.add(input);
            }

            // 최대 힙의 루트가 최소 힙의 루트보다 큰 경우 두 힙의 루트를 교환
            if (!min.isEmpty() && (max.peek() > min.peek())) {
                min.add(max.poll());
                max.add(min.poll());
            }

            System.out.println(max.peek());
        }
    }
}
