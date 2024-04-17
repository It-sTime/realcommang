package SWExpertAcademy;


import java.util.Scanner;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class q20728
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader("SWExpertAcademy/sin.txt"));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine(), " "); //주머니2개
            int pouch1 = Integer.parseInt(st.nextToken());
            int pouch = Integer.parseInt(st.nextToken()); //pouch 값으로 나뉨
            st = new StringTokenizer(br.readLine(), " ");
            ArrayList<Long> candies = new ArrayList<>();

            while (st.hasMoreTokens()) {
                candies.add(Long.parseLong(st.nextToken()));
            }

            Collections.sort(candies, Comparator.reverseOrder());

            int size = pouch;
            int idx = 0; long MIN = Long.MAX_VALUE;

            while (idx+size-1 <= candies.size()-1) {
                long temp = candies.get(idx) - candies.get(idx+size-1);
                if (temp < MIN) MIN = temp;
                idx++;
            }

            System.out.println(MIN);
        }
    }
}

