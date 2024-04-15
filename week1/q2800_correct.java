package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

public class q2800_correct {
    static TreeSet<String> result = new TreeSet<>();  // 결과를 저장할 TreeSet, 중복 제거와 자동 정렬을 제공
    static List<int[]> pairs = new ArrayList<>();     // 괄호 쌍의 인덱스를 저장할 리스트
    static String input;                              // 사용자로부터 입력받은 수식 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine(); // 수식 입력 받기

        // 괄호 쌍 찾기
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                stack.push(i);  // 여는 괄호 위치를 스택에 푸시
            } else if (input.charAt(i) == ')') {
                pairs.add(new int[]{stack.pop(), i});  // 여는 괄호와 매칭되는 닫는 괄호 위치 저장
            }
        }

        // 괄호 제거 재귀 함수 호출
        remove(0, new boolean[pairs.size()]);

        // 결과 출력
        result.remove(input); // 원본 수식 제거
        for (String expr : result) {
            System.out.println(expr);
        }
    }

    public static void remove(int start, boolean[] removed) {
        // 현재 상태에서 괄호를 제거한 결과 수식 추가
        StringBuilder sb = new StringBuilder();
        boolean[] used = new boolean[input.length()];
        for (int i = 0; i < removed.length; i++) {
            if (removed[i]) {
                int[] pair = pairs.get(i);
                used[pair[0]] = true;  // 제거된 여는 괄호 위치를 true로 설정
                used[pair[1]] = true;  // 제거된 닫는 괄호 위치를 true로 설정
            }
        }
        for (int i = 0; i < input.length(); i++) {
            if (!used[i]) sb.append(input.charAt(i));  // 사용되지 않은 위치의 문자만 추가
        }
        result.add(sb.toString());  // 결과 TreeSet에 추가

        // 다음 괄호 쌍 제거 시도
        for (int i = start; i < pairs.size(); i++) {
            removed[i] = true;              // 현재 괄호 쌍을 제거하고
            remove(i + 1, removed);         // 다음 괄호 쌍을 계속해서 제거
            removed[i] = false;             // 현재 괄호 쌍을 다시 복원
        }
    }
}
