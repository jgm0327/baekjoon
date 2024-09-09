import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());

        int[] sandAmount = new int[n + 1];

        tokenizer = new StringTokenizer(br.readLine());
        for(int i=1 ; i<=n ; i++){
            sandAmount[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int[] stonePos = new int[k];
        tokenizer = new StringTokenizer(br.readLine());
        for(int i=0 ; i<k ; i++){
            stonePos[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int[][] interval = new int[k][2];
        int sum = 0, idx = k - 1;
        for(int i=n ; i>=1 ; i--){
            sum += sandAmount[i];

            if(idx >= 0 && stonePos[idx] == i){
                interval[idx] = new int[]{sum, i};
                sum = 0;
                idx--;
            }
        }

        Arrays.sort(interval, (o1, o2) -> o2[0] - o1[0]);
        
        int[] wallPos = new int[m];
        
        for(int i=0 ; i<m ; i++){
            wallPos[i] = interval[i][1];
        }

        Arrays.sort(wallPos);
        StringBuilder answer = new StringBuilder();
        for(int i=0 ; i<m ; i++){
            answer.append(wallPos[i]).append("\n");
        }

        bw.write(answer.toString());
        bw.close();
        br.close();
    }
}