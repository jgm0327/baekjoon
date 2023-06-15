import java.util.*;

class Solution {
    boolean[][] visit;
    int n, m;
    public int[] solution(String[] maps) {
        int[] answer = {};
        n = maps.length;
        m = maps[0].length();
        visit = new boolean[n][m];
        
        List<Integer> list = new ArrayList<>();
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(visit[i][j] || maps[i].charAt(j) == 'X') continue;
                list.add(bfs(i, j, maps));
            }
        }        
        if(list.size() == 0)list.add(-1);
        Collections.sort(list);
        return list.stream().mapToInt(v -> v).toArray();
    }
    
    private int bfs(int Y, int X, final String[] maps){
        Queue<int[]> que = new LinkedList<>();
        visit[Y][X] = true;
        que.add(new int[]{Y, X});
        final int[] dy = {0,0,1,-1}, dx = {1,-1,0,0};
        
        int ret = maps[Y].charAt(X) - '0';
        while(!que.isEmpty()){
            int[] cur = que.poll();
            int y = cur[0], x = cur[1];
            
            for(int i=0 ; i<4 ; i++){
                int ny = dy[i] + y, nx = dx[i] + x;
                if(ny < 0 || ny >= n || nx < 0 || nx >= m || visit[ny][nx] || maps[ny].charAt(nx) == 'X')continue;
                que.add(new int[]{ny, nx});
                ret += (maps[ny].charAt(nx) - '0');
                visit[ny][nx] = true;
            }
            
        }
        return ret;
    }
}