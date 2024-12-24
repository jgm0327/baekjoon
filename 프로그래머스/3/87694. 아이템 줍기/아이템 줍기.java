import java.util.*;

class Solution {
    private int[][] board;
    private int[] dy = {0, 0, 1, -1}, dx = {1, -1, 0, 0};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        board = new int[101][101];
        
        // 좌표 2배 확장 및 전체 채우기
        for (int[] rec : rectangle) {
            for (int i = rec[0] * 2; i <= rec[2] * 2; i++) {
                for (int j = rec[1] * 2; j <= rec[3] * 2; j++) {
                    board[i][j] = 1;
                }
            }
        }
        
        for (int[] rec : rectangle) {
            for (int i = rec[0] * 2 + 1; i < rec[2] * 2; i++) {
                for (int j = rec[1] * 2 + 1; j < rec[3] * 2; j++) {
                    board[i][j] = 2;
                }
            }
        }
        
        return bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2) / 2;
    }
    
    public int bfs(int startY, int startX, int endY, int endX) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[101][101];
        
        queue.add(new int[]{startY, startX, 0});
        visited[startY][startX] = true;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int y = cur[0], x = cur[1], dist = cur[2];
            
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i], nx = x + dx[i];
                
                if (!isIn(ny, nx) || visited[ny][nx] || board[ny][nx] != 1) {
                    continue;
                }
                if(ny == endY && nx == endX)
                    return dist + 1;
                
                visited[ny][nx] = true;
                queue.add(new int[]{ny, nx, dist + 1});
            }
        }
        
        return 0;
    }
    
    private boolean isIn(int y, int x) {
        return y >= 0 && y <= 100 && x >= 0 && x <= 100;
    }
}
