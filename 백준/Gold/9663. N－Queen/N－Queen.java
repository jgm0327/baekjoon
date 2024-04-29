import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{

    private static int n, answer;
    private static int[] board;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        board = new int[n];

        answer = 0;
        backtracking(0);
        System.out.println(answer);
    }

    private static void backtracking(int depth){
        if(depth == n){
            answer++;
            return;
        }

        for(int i=0 ; i<n ; i++){
            board[depth] = i;
            if(!check(depth))continue;
            backtracking(depth + 1);
        }
        
    }
    
    private static boolean check(int y){
        for(int i=0 ; i<y ; i++){
            if(board[y] == board[i])return false;
            if(y - i == Math.abs(board[y] - board[i]))return false;
        }

        return true;
    }
}