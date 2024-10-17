import java.util.*;

class Solution {
    private boolean[][] visit;
    
    public int[] solution(String[] maps) {
        List<Integer> size = new ArrayList<>();
        
        visit = new boolean[maps.length][maps[0].length()];
        for(int i=0 ; i<maps.length ; i++){
            for(int j=0 ; j<maps[i].length() ; j++){
                if(visit[i][j] || maps[i].charAt(j) == 'X')
                    continue;
                
                size.add(bfs(i, j, maps));
            }
        }
        
        if(size.size() == 0)
            size.add(-1);
        
        Collections.sort(size);
        
        return size.stream().mapToInt(i->i).toArray();
    }
    
    private int bfs(int sy, int sx, String[] maps){
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{sy, sx});
        
        visit[sy][sx] = true;
        int[] dy = {0,0,1,-1}, dx = {1,-1,0,0};
        
        int ret = maps[sy].charAt(sx) - '0';
        
        while(!que.isEmpty()){
            int[] cur = que.poll();
            
            int y = cur[0], x = cur[1];
            
            for(int i=0 ; i<4 ; i++){
                int ny = y + dy[i], nx = x + dx[i];

                if(0 > ny || ny >= maps.length || 0 > nx || nx >= maps[0].length() 
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