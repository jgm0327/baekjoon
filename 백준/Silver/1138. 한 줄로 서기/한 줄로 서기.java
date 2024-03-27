import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] left = new int[n + 1];
        StringTokenizer stk = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            left[i] = Integer.parseInt(stk.nextToken());
        }

        int[] answer = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int count = 0, idx = 0;

            for (int j = 0; j < n; j++) {
                if (answer[j] != 0)
                    continue;

                if (answer[j] == 0 && count == left[i]) {
                    idx = j;
                    break;
                }

                if (answer[j] == 0) {
                    count++;
                }
            }

            answer[idx] = i;
        }

        for(int i=0 ; i<n ; i++){
            System.out.print(answer[i] + " ");
        }
    }
}