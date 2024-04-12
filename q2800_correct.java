import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.TreeSet;

public class q2800_correct {

    /*
기본 사례 처리: 입력된 수식에 괄호가 없는 경우, 수식을 그대로 출력하고 재귀를 종료

괄호 제거: 수식에서 괄호 쌍을 찾아 각 쌍을 제거한 후, 그 결과로 새로운 수식을 생성합니다.
 이를 위해 수식을 반복적으로 탐색하며 여는 괄호와 닫는 괄호의 위치를 찾습니다.

재귀 호출: 괄호를 제거한 새로운 수식에 대해 재귀적으로 같은 함수를 호출하여,
모든 괄호 쌍이 제거될 때까지 계속하여 괄호를 제거합니다.

중복 제거 및 출력: 생성된 모든 수식을 저장하되, 중복을 피하기 위해 Set 구조를 사용합니다.
재귀가 완료되면, 저장된 수식을 사전 순으로 정렬하여 출력합니다.*/
    static TreeSet<String> result = new TreeSet<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine(); //수식

        remove(input);

        while (!result.isEmpty()) {
            System.out.println(result.pollFirst());
        }
    }

    public static void remove(String input) {

        Stack<Integer> stack1 = new Stack<>(); //여는 괄호의 인덱스
        Stack<Integer> stack2 = new Stack<>(); //닫는 괄호의 인덱스

        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '(') {
                stack1.push(i);
            }
            else if(input.charAt(i) == ')') {
                stack2.push(i);
            }
        }

        int size = stack2.size();
        for (int i = 0; i < size; i++) {
            stack2.push(stack2.pop()); //역순으로 넣어주기 : 여는 괄호랑 순서 맞추려고
        }

        if (stack1.isEmpty() && stack2.isEmpty()) return;
        else if (!stack1.isEmpty() && !stack2.isEmpty()) {
           int open = stack1.pop();
           int close = stack2.pop();

           StringBuilder sb = new StringBuilder();

           for (int i = input.length()-1; i >= 0; i--) {
               if(i != open && i != close)
                   sb.append(input.charAt(i));
           }

           sb.reverse();
           result.add(sb.toString());

           remove(sb.toString());
        }
    }
}
