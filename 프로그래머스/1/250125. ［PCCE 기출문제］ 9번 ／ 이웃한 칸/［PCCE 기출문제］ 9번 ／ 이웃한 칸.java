class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0, n = board.length;
        
        final int[] dh = {0,1,-1,0}, dw = {1,0,0,-1};
        
        for(int i=0 ; i<4 ; i++){
            int hCheck = h + dh[i], wCheck = w + dw[i];
            
            if(0 > hCheck || hCheck >= n || 0 > wCheck || wCheck >= n 
               || !board[h][w].equals(board[hCheck][wCheck]))
                continue;
            
            answer++;
        }
        
        return answer;
    }
}