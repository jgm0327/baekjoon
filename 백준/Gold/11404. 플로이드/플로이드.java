import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        int[][] graph = new int[n + 1][n + 1];

        for(int i=1 ; i<=n ; i++){
            for(int j=1 ; j<=n ; j++){
                if(i == j)continue;
                graph[i][j] = Integer.MAX_VALUE;
            }
        }

        while(m-- > 0) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            int sour, des, weight;

            sour = Integer.parseInt(tokenizer.nextToken());
            des = Integer.parseInt(tokenizer.nextToken());
            weight = Integer.parseInt(tokenizer.nextToken());

            graph[sour][des] = Math.min(weight, graph[sour][des]);
        }

        for(int k=1 ; k<=n ; k++){
            for(int i=1 ; i<=n ; i++){
                for(int j=1 ; j<=n ; j++){
                    if(graph[i][k] == Integer.MAX_VALUE || graph[k][j] == Integer.MAX_VALUE)
                        continue;

                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        StringBuilder answer = new StringBuilder();

        for(int i=1 ; i<=n ; i++){
            for(int j=1 ; j<=n ; j++){
                answer.append(graph[i][j] == Integer.MAX_VALUE ? 0 : graph[i][j]).append(" ");
            }
            answer.append("\n");
        }

        System.out.print(answer);
    }
}