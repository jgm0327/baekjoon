import java.util.*;

class Solution {
    Map<String, Integer> chIdx;
    final String[] names = {"A", "C", "F", "J", "M", "N", "R", "T"};
    int answer = 0;
    
    class Dist{
        String name1, name2;
        char comp;
        int dist;
        
        public Dist(String name1, String name2, char comp, int dist){
            this.name1 = name1;
            this.name2 = name2;
            this.comp = comp;
            this.dist = dist;
        }
    }
    
    public int solution(int n, String[] data) {
        chIdx = new HashMap<>();
        
        for(int i=0 ; i<8 ; i++){
            chIdx.put(names[i], -1);
        }
        
        Dist[] dists = new Dist[n];
        for(int i=0 ; i<n ; i++){
            char ch = data[i].charAt(3);
            
            String[] splitNumber = data[i].split(Character.toString(ch));
            int dist = Integer.parseInt(splitNumber[1]);
            
            String[] splitName = splitNumber[0].split("~");
            
            dists[i] = new Dist(splitName[0], splitName[1], ch, dist);
        }
        
        dfs(0, dists);
        return answer;
    }
    
    private void dfs(int depth, final Dist[] dists){
        if(depth == 8){
            if(canGetLine(dists)){
                answer++;
            }
            return;
        }
        
        for(String name : names){
            if(chIdx.get(name) != -1)continue;
            
            chIdx.put(name, depth);
            dfs(depth + 1, dists);
            chIdx.put(name, -1);
        }
    }
    
    private boolean canGetLine(final Dist[] dists){
        for(Dist dist : dists){
            String name1 = dist.name1, name2 = dist.name2;
            char comp = dist.comp;
            int d = Math.abs(chIdx.get(name1) - chIdx.get(name2)) - 1;
            
            if(comp == '>' && d <= dist.dist){
                return false;
            }else if(comp == '<' && d >= dist.dist){
                return false;
            }else if(comp == '=' && dist.dist != d){
                return false;
            }
        }
        return true;
    }
}
    