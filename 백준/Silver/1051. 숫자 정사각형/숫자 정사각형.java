import java.util.ArrayDeque;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main{
    private static int n, m;
    private static int[][] graph;

    public static void main(String[] args) throws IOException{
        ioOperation();
        solution();
    }

    private static void ioOperation() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        n = Integer.parseInt(size[0]);
        m = Integer.parseInt(size[1]);

        graph = new int[n][m];
        for(int i=0 ; i<n ; i++){
            String values = br.readLine();
            for(int j=0 ; j<m ; j++){
                graph[i][j] = values.charAt(j) - '0';
            }
        }
        br.close(); 
    }

    private static void solution(){
        int ret = 1, len = Math.min(n, m);

        for(int i=1 ; i <= len ; i++){
            ret = Math.max(ret, findMax(i));
        }
        System.out.println(ret);
    }

    private static int findMax(int size){
        int max = 0;
        for(int i=0 ; i <= n - size ; i++){
            for(int j=0 ; j <= m - size ; j++){
                if(graph[i][j] == graph[i][j+size-1] 
                && graph[i][j+size-1] == graph[i+size-1][j+size-1] 
                && graph[i+size-1][j+size-1] == graph[i+size-1][j])
                return size * size;
            }
        }
        return 0;
    }
}