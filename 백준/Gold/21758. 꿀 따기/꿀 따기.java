import java.io.*;
import java.util.*;

class Main {
    private static int[][] lab;
    private static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int[] pos = new int[n + 1];
        int[] prefixSum = new int[n + 1];
        for(int i=1 ; i<=n ; i++){
            pos[i] = Integer.parseInt(tokenizer.nextToken());
            prefixSum[i] = prefixSum[i - 1] + pos[i];
        }

        int answer = 0;
        // 벌통 왼쪽
        int total = 0;
        for(int i=2 ; i<n ; i++){
            total = Math.max(total, prefixSum[i - 1] - prefixSum[0] + (prefixSum[n - 1] - pos[i]));
        }
        answer = total;

        // 벌통 가운데
        total = 0;
        for(int i=2 ; i<n ; i++){
            total = Math.max(total, prefixSum[i] - prefixSum[1] + prefixSum[n-1] - prefixSum[i - 1]);
        }
        answer = Math.max(answer, total);

        // 벌통 오른쪽
        total = 0;
        for(int i=2 ; i<n ; i++){
            total = Math.max(total, prefixSum[n] - prefixSum[1] - pos[i] + prefixSum[n] - prefixSum[i]);
        }
        answer = Math.max(answer, total);

        bw.write(answer+"");

        bw.close();
    }
}