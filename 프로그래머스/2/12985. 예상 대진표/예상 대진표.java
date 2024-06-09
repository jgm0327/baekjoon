import java.util.*;

class Solution
{
    int answer = -1;
    public int solution(int n, int a, int b)
    {
        List<Integer> players = new ArrayList<>();
        
        for(int i=1 ; i<=n ; i++){
            players.add(i);
        }
        
        /*
        2 3 7 8
        1 2 3 4 5 6 7 8
        */
        
        if(a > b){
            int temp = a;
            a = b;
            b = temp;
        }
        
        dfs(1, players, a, b);
        
        return answer;
    }
    
    private void dfs(int depth, List<Integer> players, final int a, final int b){
        if(players.size() == 2){
            answer = depth;
            return;
        }
        
        List<Integer> winPlayers = new ArrayList<>();
        
        for(int i = 0 ; i < players.size() ; i += 2){
            
            int p1 =  players.get(i), p2 = players.get(i + 1);
            
            if(p1 == a && p2 == b){
                answer = depth;
                return;
            }
            
            if(p1 == a || p1 == b)winPlayers.add(p1);            
            else winPlayers.add(p2);
        }
        
        dfs(depth + 1, winPlayers, a, b);
    }
}