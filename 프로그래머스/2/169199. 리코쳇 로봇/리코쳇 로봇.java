import java.util.*;

class Solution {
    public int solution(String[] board) {
        int[] start = {-1,-1};
        int[] end = {-1,-1};
        
        for(int row = 0 ; row < board.length ; row++){
            for(int col = 0 ; col < board[0].length() ; col++){
                char ch = board[row].charAt(col);
                
                if(ch == 'R')start = new int[]{row, col};
                if(ch == 'G')end = new int[]{row, col};
            }
        }
        
        return bfs(start, end, board);
    }
    
    private int bfs(int[] start, int[] end, String[] board){
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{start[0], start[1], 0});
        
        final int[] dy = {0,0,1,-1}, dx = {1,-1,0,0};
        boolean[][][] visit = new boolean[board.length][board[0].length()][4];
        
        Arrays.fill(visit[start[0]][start[1]], true);
        
        int ret = Integer.MAX_VALUE;
        while(!que.isEmpty()){
            int[] cur = que.poll();
            int y = cur[0], x = cur[1], time = cur[2];
            
            for(int i=0 ; i<4 ; i++){
                int[] next = move(dy[i], dx[i], y, x, board);
                
                int ny = next[0], nx  = next[1];
                
                if(visit[ny][nx][i])
                    continue;
                
                if(ny == end[0] && nx == end[1]){
                    ret = Math.min(time + 1, ret);
                    continue;
                }
                    
                
                visit[ny][nx][i] = true;
                que.add(new int[]{ny, nx, time + 1});
            }
        }
        
        return ret == Integer.MAX_VALUE ? -1 : ret;
    }
    
    private int[] move(int dy, int dx, int y, int x, String[] board){
        int ny = y + dy, nx = x + dx;
        
        while(0 <= ny && ny < board.length && 0 <= nx && nx < board[0].length()){
            if(board[ny].charAt(nx) == 'D'){
                return new int[]{ny - dy, nx - dx};
            }
            
            ny += dy;
            nx += dx;
        }
        
        return new int[]{ny - dy, nx - dx};
    }
}