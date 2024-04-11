import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class q2800 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String bracket = br.readLine();
        Stack<Integer> stack1 = new Stack<>(); // '('
        Stack<Integer> stack2 = new Stack<>(); // ')'

        for (int i = 0; i < bracket.length(); i++) {

            if (bracket.charAt(i) == '(') {
                stack1.push(i); //pop할 경우 사전순
            } else if (bracket.charAt(i) == ')') {
                stack2.push(i); //pop할 경우 사전순의 반대
            }
        }

        int[] arr1 = new int[stack1.size()]; //순서 인덱스 담김
        int[] arr2 = new int[stack2.size()];

        int size = stack1.size();
        int a = 0;

        while (!stack1.isEmpty()) {
            arr2[size - a - 1] = stack2.pop();
            arr1[a] = stack1.pop();
            a++;
        }

        List<String> binaries = generateBinary(size);
        TreeSet<String> expressions = new TreeSet<>();

        for (String binary : binaries) {

            StringBuilder s = new StringBuilder(bracket);

            for (int i = 0; i < binary.length(); i++) {
                if (binary.charAt(i) == '0') {
                    s.replace(arr1[i], arr1[i] + 1, "a");
                    s.replace(arr2[i], arr2[i] + 1, "a");
                }
            }

            String expr = s.toString().replaceAll("a", "");
            expressions.add(expr);
        }

        expressions.remove(bracket);

        for (String expr : expressions) {
            System.out.println(expr);
        }
    }
        public static List<String> generateBinary(int n) {
        List<String> result = new ArrayList<>();
        int maxNumber = (1 << n) - 1;

        for (int i = 0; i <= maxNumber; i++) {
            if(i != maxNumber) {
                String binaryString = Integer.toBinaryString(i);
                while(binaryString.length() < n) {
                    binaryString = "0" + binaryString;
                }
                result.add(binaryString);
            }
        }
        return result;
    }
}
