package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class q4195 {
    static int size = 100_001;
    static HashMap<String , Integer> friends;
    static int[] root, rank;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int size1 = Integer.parseInt(br.readLine()); // 친구 관계의 수
            friends = new HashMap<>(); // 매 테스트 케이스마다 초기화

            root = new int [2 * size1]; // 충분히 큰 배열 생성
            rank = new int [2 * size1];

            for (int j = 0; j < 2 * size1; j++) {
                root[j] = j; // 자기 자신을 가리키도록 초기화
                rank[j] = 1; // 초기 크기는 1
            }

            int index = 0;
            for (int k = 0; k < size1; k++) {
                String line = br.readLine();
                StringTokenizer st = new StringTokenizer(line);

                String name1 = st.nextToken();
                String name2 = st.nextToken();

                if (!friends.containsKey(name1)) {
                    friends.put(name1, index++);
                }
                if (!friends.containsKey(name2)) {
                    friends.put(name2, index++);
                }

                int to = friends.get(name1);
                int from = friends.get(name2);
                int networkSize = union(to, from);
                sb.append(networkSize + "\n");
            }
        }

        System.out.println(sb.toString());
    }

    public static int find(int x) {
        if (root[x] != x) {
            root[x] = find(root[x]); // 경로 압축
        }
        return root[x];
    }

    static int union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            if (rank[x] > rank[y]) {
                root[y] = x;
                rank[x] += rank[y];
                return rank[x];
            } else {
                root[x] = y;
                rank[y] += rank[x];
                return rank[y];
            }
        }
        return rank[x]; // 같은 집합에 속한 경우
    }
}
