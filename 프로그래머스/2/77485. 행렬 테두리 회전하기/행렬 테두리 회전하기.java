class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int n = queries.length;
        int[] answer = new int[n];
        int[][] board = new int[rows + 1][columns + 1];
        
        for(int i=1 ; i<=rows ; i++){
            for(int j=1 ; j<=columns ; j++){
                board[i][j] = ((i - 1) * columns) + j;
            }
        }
        
        for(int t=0 ; t<n; t++){
            int[] query = queries[t];
            answer[t] = rotation(board, query);
        }
        return answer;
    }
    
    private int rotation(int[][] board, int[] query){
        int y1 = query[0], x1 = query[1], y2 = query[2], x2 = query[3];
        int min = board[y1][x1];
        int temp = board[y1][x1];
        
        for(int i=y1 ; i<y2 ; i++){
            board[i][x1] = board[i+1][x1];
            min = Math.min(min, board[i][x1]);
        }
        
        for(int i=x1 ; i<x2 ; i++){
            board[y2][i] = board[y2][i+1];
            min = Math.min(min, board[y2][i]);
        }
        
        for(int i=y2 ; i > y1 ; i--){
            board[i][x2] = board[i - 1][x2];
            min = Math.min(min, board[i][x2]);
        }
        
        for(int i=x2 ; i > x1 ; i--){
            board[y1][i] = board[y1][i-1];
            min = Math.min(min, board[y1][i]);
        }
        
        board[y1][x1+1] = temp;
        
        return min;
    }
}