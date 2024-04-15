package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class q10799 {

    public static void main(String args[]) throws IOException {
        //')' : 레이저 => 스택 사이즈 더하기, 파이프 끝 => 1 더하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> stack = new Stack<>();

        //괄호열
        String bracket = br.readLine();
        int result = 0;
        int size = 0;

        for (int i = 0; i < bracket.length(); i++) {

            char temp = bracket.charAt(i);

            switch (temp) {
                case '(' :
                    stack.push("(");
                    break;
                case ')' :
                    String a = stack.pop();

                    if(bracket.charAt(i-1) == '(' ) {
                        result += stack.size();
                    }else {
                        result += 1;
                    }

            }
        }

        System.out.println(result);
    }
}
