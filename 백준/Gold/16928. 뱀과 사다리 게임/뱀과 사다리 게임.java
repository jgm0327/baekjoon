import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        int[] ladders = new int[101];
        int[] snakes = new int[101];

        for(int i=0 ; i<101; i++){
            ladders[i] = i;
            snakes[i] = i;
        }

        for(int i=0 ; i<n ; i++){
            tokenizer = new StringTokenizer(br.readLine());
            int sour = Integer.parseInt(tokenizer.nextToken());
            int des = Integer.parseInt(tokenizer.nextToken());

            ladders[sour] = des;
        }

        for(int i=0 ; i<m ; i++){
            tokenizer = new StringTokenizer(br.readLine());
            int sour = Integer.parseInt(tokenizer.nextToken());
            int des = Integer.parseInt(tokenizer.nextToken());

            snakes[sour] = des;
        }

        bfs(ladders, snakes);
    }

    private static void bfs(final int[] ladders, final int[] snakes){
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{1, 0});

        boolean[] visit = new boolean[101];
        visit[1] = true;

        while(!que.isEmpty()){
            int[] cur = que.poll();
            int point = cur[0], cnt = cur[1];

            for(int i=1 ; i<=6 ; i++){
                int nextPoint = point + i;

                if(nextPoint == 100){
                    System.out.println(cnt + 1);
                    return;
                }

                if(visit[nextPoint])continue;
                visit[nextPoint] = true;

                if(snakes[nextPoint] != nextPoint){
                    nextPoint = snakes[nextPoint];
                }else{
                    nextPoint = ladders[nextPoint];
                }

                visit[nextPoint] = true;
                que.add(new int[]{nextPoint, cnt + 1});
            }
        }
    }
}