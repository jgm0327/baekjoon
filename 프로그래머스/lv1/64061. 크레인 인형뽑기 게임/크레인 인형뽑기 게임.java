import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        LinkedList<Integer> stk = new LinkedList<>();
        
        for(int move : moves){
            int doll = down(board, move - 1);
            if(doll == -1)continue;
            if(stk.isEmpty() || stk.peekLast() != doll){
                stk.add(doll);
                continue;
            }
            answer++;
            while(!stk.isEmpty() && stk.peekLast() == doll){
                answer++;
                stk.pollLast();
            }
        }
        return answer;
    }
    
    private static int down(int[][] board, int move){
        for(int i=0 ; i<board.length ; i++){
            int doll = board[i][move];
            if(doll != 0){
                board[i][move] = 0;
                return doll;
            }
        }
        return -1;
    }
}