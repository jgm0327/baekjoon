import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    static int n, m;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            boolean[] isOpened = new boolean[n + 1];
            Arrays.fill(isOpened, true);

            for (int i = 2; i <= n; i++) {
                for (int j = i; j <= n; j += i) {
                    isOpened[j] = !isOpened[j];
                }
            }

            int count = 0;
            for(int i=1 ; i<=n ; i++)
                if(isOpened[i])
                    count++;

            answer.append(count).append("\n");
        }

        System.out.println(answer);

        br.close();
    }
}