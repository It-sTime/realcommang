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
                if(stack.isEmpty()) {
                    stack.push(temp);
                }
                else {
                    if (temp == '(') { //(는 스택에 바로 푸시
                        stack.push(temp);
                    } else if (temp == ')') { // (가 나올때까지 팝
                        while (!stack.isEmpty() && stack.peek() != '(') {
                            Character top = stack.pop();
                            if(top != '(') {
                                sb.append(top);
                            }
                        }
                    } else if (Rank(temp) - Rank(stack.peek()) < 0) { //스택 맨위 우선순위 > 현재 우선순위
                        sb.append(stack.pop());
                    } else {
                        stack.push(temp);
                    }
                }
            }
        }

        if(!stack.isEmpty()) {
            while(!stack.isEmpty()) {
                sb.append(stack.pop());
            }
        }

        System.out.println(sb);

    }

    static int Rank (Character a) {
        if(a == '(' || a == ')') {
            return 3;
        }
        else if(a == '*' || a == '/') {
            return 2;
        }
        else {
            return 1;
        }
    }
}
