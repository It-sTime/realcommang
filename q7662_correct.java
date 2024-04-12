import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class q7662_correct {

    static public void main (String []  args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<Integer, Integer> treeMap;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            int k = Integer.parseInt(br.readLine());
            treeMap = new TreeMap<>();

            for (int j = 0; j < k; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                String dOrI = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (Objects.equals(dOrI, "D")) {

                    if(treeMap.isEmpty()) continue;

                    int temp;
                    if (num == -1) { //최솟값
                        temp = treeMap.firstKey();
                    } else {
                        temp = treeMap.lastKey();
                    }

                    if(treeMap.put(temp, treeMap.get(temp)-1)==1) {
                        treeMap.remove(temp);
                    }

                } else {
                    treeMap.put(num, treeMap.getOrDefault(num, 0)+1);
                }
            }


            if (!treeMap.isEmpty()) {
                sb.append(treeMap.lastKey()).append(" ").append(treeMap.firstKey()).append("\n");
            } else {
                sb.append("EMPTY\n");
            }
        }
        System.out.print(sb.toString());
    }

}
