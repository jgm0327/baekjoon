import java.io.*;
import java.util.*;

class Main {

    private static int answer;
    private static int[][] scores;
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int C = Integer.parseInt(br.readLine());
        while(C-- > 0){
            scores = new int[11][11];
            visit = new boolean[11];
            answer = 0;

            for(int i=0 ; i<11 ; i++){
                StringTokenizer tokenizer = new StringTokenizer(br.readLine());

                for(int j=0 ; j<11 ; j++){
                    scores[i][j] = Integer.parseInt(tokenizer.nextToken());
                }
            }

            dfs(0, 0);
            bw.append(answer+"").append("\n");
        }
        
        bw.flush();
        bw.close();
    }

    private static void dfs(int playerNumber, int total){
        if(playerNumber == 11){
            answer = Math.max(answer, total);
            return;
        }

        for(int ability=0 ; ability<11 ; ability++){
            if(visit[ability] || scores[playerNumber][ability] == 0)
                continue;

            visit[ability] = true;
            dfs(playerNumber + 1, total + scores[playerNumber][ability]);
            visit[ability] = false;
        }
    }
}