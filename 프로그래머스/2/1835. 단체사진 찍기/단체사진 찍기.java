import java.util.*;

class Solution {
    class Distance{
        int name1, name2;
        int dist;
        char sign;
        
        public Distance(int name1, int name2, char sign, int dist){
            this.name1 = name1;
            this.name2 = name2;
            this.sign = sign;
            this.dist = dist;
        }
    }
    
    Distance[] distances;
    int[] idx;
    char[] names = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    int answer = 0;
    public int solution(int n, String[] data) {
        distances = new Distance[n];
        idx = new int[26];
        
        for(int i=0 ; i<data.length ; i++){
            int first = data[i].charAt(0) - 'A';
            int second = data[i].charAt(2) - 'A';
            char sign = data[i].charAt(3);
            int dist = data[i].charAt(4) - '0' + 1;
            
            distances[i] = new Distance(first, second, sign, dist);
        }
        
        return dfs(0, n, 0);
    }
    
    int dfs(int visit, int n, int depth){
        if(depth == 8){
            if(canMakeLine(n)) return 1;
            return 0;
        }
        
        int ret = 0;
        for(int i=0 ; i<8 ; i++){
            if((visit & (1 << i)) != 0)
                continue;
            
            idx[names[i] - 'A'] = depth;
            ret += dfs(visit | (1 << i), n, depth + 1);
        }
        
        return ret;
    }
    
    boolean canMakeLine(int n){
        for(int i=0 ; i<n ; i++){
            int f = distances[i].name1;
            int s = distances[i].name2;
            int dist = distances[i].dist;
            char sign = distances[i].sign;
            
            if(sign == '>' && Math.abs(idx[f] - idx[s]) <= dist)
                return false;
            else if(sign == '<' && Math.abs(idx[f] - idx[s]) >= dist)
                return false;
            else if(sign == '=' && Math.abs(idx[f] - idx[s]) != dist)
                return false;  
        }
        return true;
    }
}