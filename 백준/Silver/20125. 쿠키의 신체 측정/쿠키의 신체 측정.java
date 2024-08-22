import java.io.*;
import java.util.*;

class Main {

    static char[][] board;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        board = new char[n][n];
        int[] start = {-1,-1};
        boolean findHead = false;

        for(int i=0 ; i<n ; i++){
            String input = br.readLine();

            for(int j=0 ; j<n ; j++){
                board[i][j] = input.charAt(j);

                if(board[i][j] == '*' && !findHead){
                    findHead = true;
                    start = new int[]{i+1, j};
                }
            }
        }

        int leftArm = getLength(-1,0, start);
        int rightArm = getLength(1, 0, start);
        int waist = getLength(0, 1, start);
        int leftLeg = getLength(0, 1, new int[]{start[0] + waist, start[1] - 1});
        int rightLeg = getLength(0, 1, new int[]{start[0] + waist, start[1] + 1});

        StringBuilder answer = new StringBuilder();
        answer.append(start[0] + 1).append(" ").append(start[1] + 1).append("\n");

        answer.append(leftArm).append(" ").append(rightArm).append(" ").append(waist)
        .append(" ").append(leftLeg).append(" ").append(rightLeg);

        System.out.println(answer);

        br.close();
    }

    private static int getLength(int dx, int dy, int[] start){
        int len = 0, y = start[0]  + dy, x = start[1] + dx;

        while(board[y][x] == '*'){
            len++;
            y += dy;
            x += dx;

            if(y >= n || x >= n || y < 0 || x < 0)
                break;
        }

        return len;
    }
}