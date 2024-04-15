package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class q1918_correct {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String notation = br.readLine();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < notation.length(); i++) {
            char ch = notation.charAt(i);

            if(Character.isLetter(ch)) {
                sb.append(ch);
            } else {
                switch (ch) {
                    case '(' :
                        stack.push(ch);
                        break;
                    case ')' :
                        while (!stack.isEmpty() && stack.peek() != '(') {
                            sb.append(stack.pop());
                        }
                        if(!stack.isEmpty()) stack.pop();
                        break;
                    default:
                        while(!stack.isEmpty() && Rank(stack.peek()) >= Rank(ch)) {
                            sb.append(stack.pop());
                        }
                        stack.push(ch);
                        break;

                }
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb.toString());
    }

    static int Rank(char ch) {
        if (ch == '*' || ch == '/') {
            return 2;
        } else if (ch == '+' || ch == '-') {
            return 1;
        }
        return 0; // Return 0 for '('
    }
}
