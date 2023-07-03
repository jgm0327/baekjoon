import java.util.*;

class Solution {
    private int n, m, answer;
    public int solution(String[] maps) {
        int[] start = new int[2], lever = new int[2], exit = new int[2];
        
        n = maps.length;
        m = maps[0].length();
        
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(maps[i].charAt(j) == 'S')start = new int[]{i, j};
                else if(maps[i].charAt(j) == 'L')lever = new int[]{i, j};
                else if(maps[i].charAt(j) == 'E')exit = new int[]{i, j};
            }
        }
        int[] temp = bfs(start[0], start[1], lever, maps);
        if(temp[0] == -1)return -1;
        temp = bfs(temp[0], temp[1], exit, maps);
        if(temp[0] == -1)return -1;
        return answer;
    }
    
    private int[] bfs(int sy, int sx, int[] target, final String[] maps){
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{sy, sx, 0});
        boolean[][] visit = new boolean[n][m];
        visit[sy][sx] = true;
        final int[] dy = {0,0,1,-1}, dx = {1,-1,0,0};
        
        while(!que.isEmpty()){
            int[] cur = que.poll();
            int y = cur[0], x = cur[1], cnt = cur[2];
            for(int i=0 ; i<4 ; i++){
                int ny = y + dy[i], nx = x + dx[i];
                if(ny < 0 || ny >= n || nx < 0 || nx >= m || visit[ny][nx] || maps[ny].charAt(nx) == 'X')continue;
                
                if(ny == target[0] && nx == target[1]){
                    answer += (cnt + 1);
                    return new int[] {ny, nx};
                }
                que.add(new int[]{ny, nx, cnt + 1});
                visit[ny][nx] = true;
            }
        }
        return new int[]{-1};
    }
}