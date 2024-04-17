package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.BatchUpdateException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class q1092 {
    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> krain = new ArrayList<>(); //크레인 무게 제한=
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            krain.add(Integer.parseInt(st.nextToken()));
        }


        int M = Integer.parseInt(br.readLine());
        ArrayList<Integer> boxes = new ArrayList<>();//박스의 무게
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            boxes.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(krain, Collections.reverseOrder());
        Collections.sort(boxes, Collections.reverseOrder());

        if(boxes.get(0) > krain.get(0)) {
            System.out.println("-1");
            return;
        }

        int time = 0;
        while (!boxes.isEmpty()) {
            int idx = 0; int krainIdx = 0;
            while (krainIdx < N) { //크레인 갯수
                if(idx == boxes.size()) break;
                else if(krain.get(krainIdx) >= boxes.get(idx)) {
                    boxes.remove(idx); krainIdx++;
                } else idx++;
            }
            time++;
        }

        System.out.println(time);
    }
}
