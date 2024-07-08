import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
    private static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());

        int[][] arr = new int[n + 1][m + 1];

        
        int answer = Integer.MIN_VALUE;
        for(int i=1 ; i<=n ; i++){
            tokenizer = new StringTokenizer(br.readLine());
            for(int j=1 ; j<=m ; j++){
                arr[i][j] = Integer.parseInt(tokenizer.nextToken());
                answer = Math.max(arr[i][j], answer);
            }
        }

        int[][] prefixSum = new int[n + 1][m + 1];
        for(int i=1 ; i<=n ; i++){
            for(int j=1 ; j<=m ; j++){
                prefixSum[i][j] = arr[i][j] + prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
            }
        }

        for(int sizeY = 1 ; sizeY <= n ; sizeY++){
            for(int sizeX = 1 ; sizeX <= m ; sizeX++){
                answer = Math.max(answer, maxValueBySquare(sizeY, sizeX, prefixSum));
            }
        }

        for(int size=1 ; size<=n ; size++){
            answer = Math.max(answer, MaxValueByVertical(size, prefixSum));
        }

        for(int size=1 ; size<=m ; size++){
            answer = Math.max(answer, MaxValueByHorizon(size, prefixSum));
        }
        
        bw.write(answer+"");
        bw.close();
    }

    private static int maxValueBySquare(int sizeY, int sizeX, final int[][] prefixSum){
        int ret = Integer.MIN_VALUE;

        for(int i=1 ; i<=n-sizeY; i++){
            for(int j=1 ; j<=m-sizeX; j++){
                int sum = prefixSum[i+sizeY][j+sizeX] - prefixSum[i+sizeY][j-1] - prefixSum[i-1][j+sizeX] + prefixSum[i-1][j-1];
                ret = Math.max(ret, sum);
            }
        }

        return ret;
    }

    private static int MaxValueByHorizon(int size, final int[][] prefixSum){
        int ret = Integer.MIN_VALUE;

        for(int i=1 ; i<=n ; i++){
            for(int j=1 ; j<=m-size ; j++){
                int sum = prefixSum[i][j+size] - prefixSum[i][j-1] - prefixSum[i-1][j+size] + prefixSum[i-1][j-1];
                ret = Math.max(ret, sum);
            }
        }

        return ret;
    }

    private static int MaxValueByVertical(int size, final int[][] prefixSum){
        int ret = Integer.MIN_VALUE;

        // 1 1 2 1
        for(int j=1 ; j<=m ; j++){
            for(int i=1 ; i<=n-size ; i++){
                int sum = prefixSum[i+size][j] - prefixSum[i+size][j-1] - prefixSum[i-1][j] + prefixSum[i-1][j-1];
                ret = Math.max(ret, sum);
            }
        }

        return ret;
    }
}