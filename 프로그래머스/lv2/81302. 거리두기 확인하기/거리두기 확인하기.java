import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        int idx = 0;
        for(String[] place : places){
            int flag = 1;
            for(int i=0 ; i<5 ; i++){
                for(int j=0 ; j<5 ; j++){
                    if(place[i].charAt(j) == 'P'){
                        if(!bfs(place, i, j)){
                            flag = 0;
                            break;
                        }
                    }
                }
                if(flag == 0)break;
            }
            answer[idx++] = flag;
        }
        return answer;
    }
    
    private boolean bfs(final String[] place, int sy, int sx){
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{sy, sx, 0});
        boolean[][] visit = new boolean[5][5];
        visit[sy][sx] = true;
        final int[] dy = {0,0,-1,1}, dx = {1,-1,0,0};
        
        while(!que.isEmpty()){
            int[] cur = que.poll();
            int y = cur[0], x = cur[1], cnt = cur[2];
            
            for(int i=0 ; i<4 ; i++){
                int ny = y + dy[i], nx = x + dx[i];
                if(0 > ny || ny >= 5 || 0 > nx || nx >= 5 || visit[ny][nx] || place[ny].charAt(nx) == 'X')continue;
                if(cnt + 1 <= 2 && place[ny].charAt(nx) == 'P')return false;
                if(cnt + 1 == 2)continue;
                que.add(new int[]{ny, nx, cnt + 1});
                visit[ny][nx] = true;
            }
        }
        return true;
    }
}