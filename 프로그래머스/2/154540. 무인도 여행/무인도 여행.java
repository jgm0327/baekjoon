import java.util.*;

class Solution {
    final int[] dy = {0, 0, 1, -1}, dx = {1, -1, 0, 0};
    boolean[][] visit;
    int n, m;
    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        n = maps.length;
        m = maps[0].length();
        
        visit = new boolean[n][m];
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(visit[i][j] || maps[i].charAt(j) == 'X')
                    continue;
                
                answer.add(bfs(i, j, maps));
            }
        }
        
        if(answer.size() == 0)
            answer.add(-1);
        
        Collections.sort(answer);
        return answer.stream().mapToInt(i->i).toArray();
    }
    
    int bfs(int startY, int startX, String[] maps){
        visit[startY][startX] = true;
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{startY, startX});
        
        int ret = maps[startY].charAt(startX) - '0';
        while(!que.isEmpty()){
            int[] cur = que.poll();
            
            int y = cur[0], x = cur[1];
            
            for(int i=0 ; i<4 ; i++){
                int ny = y + dy[i], nx = x + dx[i];
                
                if(0 > ny || ny >= n || 0 > nx || nx >= m 
                   || visit[ny][nx] || maps[ny].charAt(nx) == 'X')
                    continue;
                
                visit[ny][nx] = true;
                ret += maps[ny].charAt(nx) - '0';
                que.add(new int[]{ny, nx});
            }
        }
        return ret;
    }
}