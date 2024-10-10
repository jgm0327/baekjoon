import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());

        int[] ice = new int[1_000_001];
        int endIdx = 0;
        
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine());

            int g = Integer.parseInt(tokenizer.nextToken());
            int x = Integer.parseInt(tokenizer.nextToken());

            ice[x] = g;
            endIdx = Math.max(x, endIdx);
        }

        int windowSize = 2 * k + 1;
        int total = 0;

        for (int i = 0; i < Math.min(windowSize, endIdx + 1); i++) {
            total += ice[i];
        }

        int answer = total;

        for (int i = windowSize; i <= endIdx; i++) {
            total += ice[i];
            total -= ice[i - windowSize]; 
            answer = Math.max(answer, total);
        }

        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }
}
