import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class q1918 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String notation = br.readLine(); //중위 표기식 입력
        Stack<Character> stack = new Stack<>(); //스택
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < notation.length(); i++) {

            Character temp = notation.charAt(i);

            if (65 <= temp && temp <= 90) { //대문자일때 바로 append
                sb.append(temp);
            }
            else { //연산자일때
                if(!stack.isEmpty()) {
                    Character top = stack.peek();
                    if ((top == '*' || top == '/') && (temp == '+' || temp == '-')) {
                        sb.append(temp);
                        while (!stack.isEmpty()) {
                            Character tmp = stack.peek();
                            if (tmp != '(' && tmp != ')') {
                                sb.append(tmp);
                            }
                            stack.pop();
                        }
                    }
                    else {
                        stack.push(temp);
                    }
                } else {
                    stack.push(temp);
                }

            }
        }

        System.out.println(sb);

    }
}
