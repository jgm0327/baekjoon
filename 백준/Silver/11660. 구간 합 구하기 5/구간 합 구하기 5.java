import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        int[][] arr = new int[n + 1][n + 1];
        int[][] prefixSum = new int[n + 1][n + 1];

        for(int i=1 ; i<=n ; i++){
            tokenizer = new StringTokenizer(br.readLine());
            for(int j=1 ; j<=n ; j++){
                arr[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        for(int i=1 ; i<=n ; i++){
            for(int j=1 ; j<=n ; j++){
                prefixSum[i][j] = arr[i][j] + prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1];
            }
        }

        StringBuilder answer = new StringBuilder();
        while(m-- > 0){
            tokenizer = new StringTokenizer(br.readLine());

            int y1 = Integer.parseInt(tokenizer.nextToken());
            int x1 = Integer.parseInt(tokenizer.nextToken());
            int y2 = Integer.parseInt(tokenizer.nextToken());
            int x2 = Integer.parseInt(tokenizer.nextToken());

            int rangeSum = prefixSum[y2][x2] - prefixSum[y2][x1-1] - prefixSum[y1-1][x2] + prefixSum[y1-1][x1-1];

            answer.append(rangeSum).append("\n");
        }

        bw.write(answer.toString());
        bw.close();
    }
}