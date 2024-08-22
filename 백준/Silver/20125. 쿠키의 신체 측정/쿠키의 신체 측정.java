import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[][] board = new char[n][n];
        int[] heartPosition = {-1,-1};
        boolean findHead = false;

        for(int i=0 ; i<n ; i++){
            String input = br.readLine();

            for(int j=0 ; j<n ; j++){
                board[i][j] = input.charAt(j);

                if(board[i][j] == '*' && !findHead){
                    findHead = true;
                    heartPosition = new int[]{i+1, j};
                }
            }
        }

        int leftArmLength = getLength(board, -1,0, heartPosition);
        int rightArmLength = getLength(board, 1, 0, heartPosition);
        int waistLength = getLength(board, 0, 1, heartPosition);
        int leftLegLength = getLength(board, 0, 1, new int[]{heartPosition[0] + waistLength, heartPosition[1] - 1});
        int rightLegLength = getLength(board, 0, 1, new int[]{heartPosition[0] + waistLength, heartPosition[1] + 1});

        StringBuilder answer = new StringBuilder();
        answer.append(heartPosition[0] + 1).append(" ").append(heartPosition[1] + 1).append("\n");

        answer.append(leftArmLength).append(" ").append(rightArmLength).append(" ").append(waistLength)
        .append(" ").append(leftLegLength).append(" ").append(rightLegLength);

        System.out.println(answer);

        br.close();
    }

    private static int getLength(char[][] board, int dx, int dy, int[] heartPosition){
        int len = 0, y = heartPosition[0]  + dy, x = heartPosition[1] + dx;

        while(board[y][x] == '*'){
            len++;
            y += dy;
            x += dx;

            if(y >= board.length || x >= board.length || y < 0 || x < 0)
                break;
        }

        return len;
    }
}