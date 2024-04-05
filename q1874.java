import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class q1874 {

    static int[] arr;
    static ArrayList<Integer> stack = new ArrayList<>();
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n]; // 목표 수열

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine()); // 수열 입력
        }

        StringBuilder sb = new StringBuilder();
        int num = 1;

        for (int i = 0; i < n; i++) {
            int temp = arr[i];

            if (temp >= num) {
                while (temp >= num) {
                    stack.add(num++);
                    sb.append("+\n");
                }
            }

            if (stack.size() > 0 && stack.get(stack.size() - 1) == temp) {
                sb.append("-\n");
                stack.remove(stack.size() - 1);
            } else {
                System.out.println("NO");
                return;
            }
        }

        System.out.println(sb);
    }
}
