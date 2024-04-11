import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class q5397 {

    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine()); //몇줄 입력받을지

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            output(input);
        }

    }

    public static void output(String input) {

        /*왼쪽 스택 []
        오른쪽 스택 []

        백스페이스 : 왼쪽 스택에서 최상단 문자 제거
        문자 : 왼쪽 스택에 문자 추가
        < : 왼쪽에서 pop, 오른쪽에 push
        > : 오른쪽에서 pop, 왼쪽에 push*/

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char temp = input.charAt(i);

            if(temp == '<') {
                if(!left.isEmpty()) {
                    right.push(left.pop());
                }
            }
            else if(temp == '>') {
                if(!right.isEmpty()) {
                    left.push(right.pop());
                }
            }
            else if(temp == '-') {
                if(!left.isEmpty()) {
                    left.pop();
                }
            }
            else {
                left.push(temp);
            }
        }

        StringBuilder pwd = new StringBuilder();

        while (!left.isEmpty()) {
            right.push(left.pop());
        }

        while (!right.isEmpty()) {
            pwd.append(right.pop());
        }

        System.out.println(pwd.toString());
    }
}
