import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    private static int n;
    private static int[][] image;
    private static StringBuilder answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        image = new int[n][n];

        for(int i=0 ; i<n ; i++){
            String str = br.readLine();
            for(int j=0 ; j<n ; j++){
                image[i][j] = (int)(str.charAt(j) - '0');
            }
        }

        answer = new StringBuilder();
        recur(0,0,n);
        System.out.println(answer);
        br.close();
    }

    public static void recur(int y, int x, int size){
        if(size == 1 || isSameAll(y, x, size)){
            answer.append(image[y][x]);
            return;
        }
        int half = size / 2;
        answer.append("(");
        recur(y, x, half);
        recur(y, x + half, half);
        recur(y + half, x, half);
        recur(y + half, x + half, half);
        answer.append(")");
    }

    private static boolean isSameAll(int y, int x, int size){
        int bit = image[y][x];
        for(int i=y ; i<y+size ; i++){
            for(int j=x ; j<x+size ; j++){
                if(bit != image[i][j])return false;
            }
        }
        return true;
    }
}