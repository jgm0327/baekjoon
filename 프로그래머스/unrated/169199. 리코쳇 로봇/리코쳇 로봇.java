import java.util.*;

class Solution {
    private int[] start, end;
    boolean[][] visit;
    
    public int solution(String[] board) {
        int answer = 0;
        for(int i=0;  i<board.length; i++){
            for(int j=0 ; j<board[i].length() ; j++){
                if(board[i].charAt(j) == 'R')start = new int[]{i, j};
                else if(board[i].charAt(j) == 'G')end = new int[]{i, j};
            }
        }
        answer = bfs(board);
        return answer;
    }
    
    private int bfs(final String[] board){
        Queue<int[]> que = new LinkedList<>();
        int sy = start[0], sx = start[1];
        que.add(new int[]{sy, sx, 0});
        visit = new boolean[board.length][board[0].length()];
        final int[] dy = {0,0,1,-1}, dx = {1,-1,0,0};
        
        while(!que.isEmpty()){
            int[] cur = que.poll();
            int y = cur[0], x = cur[1], cnt = cur[2];
            for(int i=0 ; i<4 ; i++){
                int[] next = slip(board, y, x, dy[i], dx[i]);
                int ny = next[0], nx = next[1];
                if(ny == end[0] && nx == end[1])return cnt + 1;
                if(ny < 0 || ny >= board.length || nx < 0 || nx >= board[0].length() || visit[ny][nx])continue;
                visit[ny][nx] = true;
                que.add(new int[]{ny, nx, cnt + 1});
            }
        }
        return -1;
    }
    
    private int[] slip(final String[] board, int y, int x, int dy, int dx){
        int end = Math.max(board.length, board[0].length());
        int retY = y, retX = x;
        for(int i=1 ; i<=end ; i++){
            int ny = y + i * dy, nx = x + i * dx;
            if(ny < 0 || ny >= board.length || nx < 0 || nx >= board[0].length() || board[ny].charAt(nx) == 'D'){
                return new int[]{retY, retX};
            }
            retY = ny;
            retX = nx;
        }
        return new int[]{-1, -1};
    }
}