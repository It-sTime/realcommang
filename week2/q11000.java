package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class q11000 { //시간초과
    public static void main (String [] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<PriorityQueue<Integer>> lectures = new ArrayList<>();
        ArrayList<PriorityQueue<Integer>> lectures1 = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if (lectures.isEmpty()) {
                PriorityQueue<Integer> lec = new PriorityQueue<>(Comparator.reverseOrder());
                PriorityQueue<Integer> lec1 = new PriorityQueue<>();

                lec.add(s); lec.add(e); lectures.add(lec);
                lec1.add(s); lec1.add(e); lectures1.add(lec1);
            }
            else {
                int size = lectures.size(); int j;

                for (j = 0; j < size; j++) {
                    if(lectures.get(j).peek() <= s) {
                        if(lectures.get(j).peek() == s) {
                            lectures.get(j).add(e);
                            lectures1.get(j).add(e);
                        } else {
                            lectures.get(j).add(s);
                            lectures.get(j).add(e);
                            lectures1.get(j).add(s);
                            lectures1.get(j).add(e);
                        }
                        break;
                    } else if (lectures1.get(j).peek() >= e) {
                        if(lectures1.get(j).peek() == e) {
                            lectures.get(j).add(s);
                            lectures1.get(j).add(s);
                        } else {
                            lectures.get(j).add(s);
                            lectures.get(j).add(e);
                            lectures1.get(j).add(s);
                            lectures1.get(j).add(e);
                        }
                        break;
                    }
                }

                if(j == size) {
                    PriorityQueue<Integer> lec = new PriorityQueue<>(Comparator.reverseOrder());
                    PriorityQueue<Integer> lec1 = new PriorityQueue<>();

                    lec.add(s); lec.add(e); lectures.add(lec);
                    lec1.add(s); lec1.add(e); lectures1.add(lec1);
                }
            }
        }
        System.out.println(lectures.size());
    }
}
