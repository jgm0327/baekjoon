import java.io.*;
import java.util.*;

class Main {
    private static int n, answer;
    private static int[][] eggs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        eggs = new int[n][2];

        for(int i=0 ; i<n ; i++){
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());

            eggs[i][0] = Integer.parseInt(tokenizer.nextToken());
            eggs[i][1] = Integer.parseInt(tokenizer.nextToken());
        }

        dfs(0, 0);

        System.out.println(answer);

        br.close();
    }

    private static void dfs(int holdEggNumber, int total){

        for(int i=0 ; i<n ; i++){
            if(holdEggNumber == i || eggs[i][0] <= 0)
                continue;

            int t1 = eggs[holdEggNumber][0], t2 = eggs[i][0];

            eggs[holdEggNumber][0] -= eggs[i][1];
            eggs[i][0] -= eggs[holdEggNumber][1];

            
            if(eggs[holdEggNumber][0] <= 0)total++;
            if(eggs[i][0] <= 0)total++;
            
            answer = Math.max(total, answer);

            int nextNumber = holdEggNumber + 1;

            while(nextNumber < n && eggs[nextNumber][0] <= 0){
                nextNumber++;
            }
            
            if(nextNumber < n)
                dfs(nextNumber, total);

            if(eggs[holdEggNumber][0] <= 0)total--;
            if(eggs[i][0] <= 0)total--;

            eggs[holdEggNumber][0] = t1;
            eggs[i][0] = t2;
        }
    }
}