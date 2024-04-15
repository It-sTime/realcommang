package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class q1715 {

    public static void main(String [] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Long> cards = new PriorityQueue<>();
        Long result = 0L;

        for (int i = 0; i < n; i++) {
            Long card = Long.parseLong(br.readLine());
            cards.add(card);
        }

        //minHeap
        if(n == 1) System.out.println(0);
        else {
            for (int i = 0; i < n-1; i++) {
                long temp = 0L;
                temp += cards.remove() + cards.remove();
                cards.add(temp);
                result += temp;
            }

            System.out.println(result);
        }
    }
}
