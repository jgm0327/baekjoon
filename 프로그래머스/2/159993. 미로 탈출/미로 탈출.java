import java.util.*;

class Solution {
    public int solution(String[] maps) {
        int answer = 0;
        int[] start = new int[2], end = new int[2], lever = new int[2];
        
        for(int i=0 ; i<maps.length ; i++){
            for(int j=0 ; j<maps[i].length() ; j++){
                char ch = maps[i].charAt(j);
                
                if(ch == 'S')start = new int[]{i, j};
                if(ch == 'E')end = new int[]{i, j};
                if(ch == 'L')lever = new int[]{i, j};
            }
        }
        
        int dist1 = bfs(start, lever, maps);
        if(dist1 == -1)return -1;
        int dist2 = bfs(lever, end, maps);
        if(dist2 == -1)return -1;
        
        return dist1 + dist2;
    }
    
    private int bfs(int[] s, int[] e, String[] maps){
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{s[0], s[1], 0});
        
        int[] dy = {0,0,1,-1}, dx = {1,-1,0,0};
        boolean[][] visit = new boolean[maps.length][maps[0].length()];
        visit[s[0]][s[1]] = true;
        
        while(!que.isEmpty()){
            int[] cur = que.poll();
            int y = cur[0], x = cur[1], dist = cur[2];
            
            for(int i=0 ; i<4 ; i++){
                int ny = y + dy[i], nx = x + dx[i];
                
                if(0 > ny || ny >= maps.length || 0 > nx || nx >= maps[0].length() || visit[ny][nx] || maps[ny].charAt(nx) == 'X')
                    continue;
                
                if(ny == e[0] && nx == e[1])
                    return dist + 1;
                    
                visit[ny][nx] = true;
                que.add(new int[]{ny, nx, dist + 1});
            }
        }
        
        return -1;
    }
}