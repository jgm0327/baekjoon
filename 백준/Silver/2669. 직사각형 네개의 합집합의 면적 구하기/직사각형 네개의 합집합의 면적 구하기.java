import java.util.ArrayDeque;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main{
    private static int[][] coordinate;
    private static boolean[][] graph;

    public static void main(String[] args) throws IOException{
        ioOperation();
        solution();
    }

    private static void ioOperation() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        coordinate = new int[4][4];
        graph = new boolean[101][101];

        for(int i=0 ; i<4 ; i++){
            String[] values = br.readLine().split(" ");
            for(int j=0 ; j<4 ; j++){
                coordinate[i][j] = Integer.parseInt(values[j]);
            }
        }
        br.close(); 
    }

    private static void solution(){
        for(int i=0 ; i<4 ; i++){
            marking(coordinate[i]);
        }       

        int ret = 0;
        for(int i=1 ; i<=100 ; i++){
            for(int j=1 ; j<=100 ; j++){
                if(!graph[i][j])continue;
                ret++;
            }
        }
        System.out.println(ret);
    }

    private static void marking(final int[] size){
        for(int i=size[0] ; i<size[2] ; i++){
            for(int j=size[1] ; j<size[3] ; j++){
                graph[i][j] = true;
            }
        }
    }
}