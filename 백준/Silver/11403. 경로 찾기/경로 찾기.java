import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{

    private static int n;
    private static int[][] graph;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];

        for(int i=0 ; i<n ; i++){
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());

            for(int j=0 ; j<n ; j++){
                graph[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        for(int k=0 ; k<n ; k++){
            for(int i=0 ; i<n ; i++){
                for(int j=0 ; j<n ; j++){
                    if(graph[i][k] == 0 || graph[k][j] == 0)
                        continue;

                    graph[i][j] = 1;
                }
            }
        }

        StringBuilder answer = new StringBuilder();

        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<n ; j++){
                answer.append(graph[i][j]).append(" ");
            }
            answer.append("\n");
        }

        System.out.print(answer);
    }
}