import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[][] villages = new int[n][2];
        long total = 0;
        for(int i=0 ; i<n ; i++){
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(tokenizer.nextToken());
            int a = Integer.parseInt(tokenizer.nextToken());

            villages[i] = new int[]{x, a};
            total += a;
        }

        Arrays.sort(villages, (o1, o2) -> o1[0] - o2[0]);

        long cnt = 0;
        for(int i=0 ; i<n ; i++){
            cnt += villages[i][1];
            if((total + 1) / 2 <= cnt){
                bw.write(String.valueOf(villages[i][0]));
                break;
            }
        }

        bw.close();
        br.close();
    }
}