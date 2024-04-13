import java.util.*;

class Solution {
    private int n, m;
    private int[] amounts;
    
    public int solution(int[][] land) {
        int answer = 0;
        n = land.length;
        m = land[0].length;
        
        int number = 2;
        amounts = new int[(n * m) + 2];
        
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(land[i][j] != 1)
                    continue;
                bfs(i, j, land, number);
                number++;
            }   
        }
        
        for(int j=0 ; j<m ; j++){
            boolean[] visit = new boolean[number];
            int total = 0;
            
            for(int i=0 ; i<n ; i++){
                if(visit[land[i][j]] || land[i][j] == 0)
                    continue;
                
                total += amounts[land[i][j]];
                visit[land[i][j]] = true;
            }
            answer = Math.max(answer, total);
        }
        
        return answer;
    }
    
    private void bfs(int y, int x, int[][] land, int number){
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{y, x});
        
        land[y][x] = number;
        
        final int[] dy = {0,0,1,-1}, dx = {1,-1,0,0};
        
        int cnt = 0;
        while(!que.isEmpty()){
            int[] cur = que.poll();
            int curY = cur[0], curX = cur[1];
            
            cnt++;
            
            for(int i=0 ; i<4 ; i++){
                int nextY = curY + dy[i], nextX = curX + dx[i];
                
                if(0 > nextY || nextY >= n || 0 > nextX || nextX >= m 
                   || land[nextY][nextX] != 1)
                    continue;
                
                que.add(new int[]{nextY, nextX});
                land[nextY][nextX] = number;
            }
        }
        amounts[number] = cnt;
    }
}