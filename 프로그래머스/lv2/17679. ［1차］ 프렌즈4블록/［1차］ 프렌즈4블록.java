import java.util.*;

class Solution {
    private final int[] dy = {0,0,1,1}, dx = {0,1,0,1};
    private boolean[][] visit;
    private List<int[]> list;
    private StringBuilder[] temp;
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        temp = new StringBuilder[board.length];
        
        for(int i=0 ; i<m ;i++){
            temp[i] = new StringBuilder();
            for(int j=0 ; j<n ; j++){
                temp[i].append(board[i].charAt(j));
            }
        }
        
        while(true){
            visit = new boolean[m][n];
            list = new ArrayList<>();
            insertList(m, n);
            if(list.size() == 0)break;
            remove();
            down(m, n);
        }
        
        for(int i=0 ; i<m ; i++){
            for(int j=0 ; j<n ; j++){
                if(temp[i].charAt(j) == '-')answer++;
            }
        }
        return answer;
    }
    
    private boolean insertList(int m, int n){
        boolean flag = true;
        for(int i=0 ; i<m ; i++){
            for(int j=0 ; j<n ; j++){
                if(temp[i].charAt(j) != '-' && twoByTwo(i, j, m, n) && !visit[i][j]){
                    list.add(new int[]{i, j});
                    visit[i][j] = true;
                    flag = false;
                }
            }
        }
        return flag;
    }
    
    private void remove(){
        for(int[] cur : list){
            int y = cur[0], x = cur[1];
            for(int i=0 ; i<4 ; i++){
                int ny = y +dy[i], nx = x +dx[i];
                temp[ny].setCharAt(nx, '-');
            }
        }
    }
    
    private boolean twoByTwo(int y, int x, int m, int n){
        for(int i=0 ; i<4 ; i++){
            int ny = y + dy[i], nx = x + dx[i];
            if(ny < 0 || ny >= m || nx < 0 || nx >= n || temp[y].charAt(x) != temp[ny].charAt(nx))return false;
        }
        return true;
    }
    
    private void down(int m, int n){
        for(int i=m-2 ; i >= 0 ; i--){
            for(int j=0 ; j<n  ; j++){
                char ch = temp[i].charAt(j);
                if(ch == '-')continue;
                int idx = i;
                while(idx + 1 < m && temp[idx + 1].charAt(j) == '-'){
                    char t = ch;
                    temp[idx].setCharAt(j, temp[idx+1].charAt(j));
                    temp[idx+1].setCharAt(j, t);
                    idx++;
                }
            }
        }
    }
    
}