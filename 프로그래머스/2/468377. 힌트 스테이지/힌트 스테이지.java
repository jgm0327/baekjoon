import java.util.*;

class Solution {
    List<List<Integer>> list;
    public int solution(int[][] cost, int[][] hint) {
        int answer = Integer.MAX_VALUE;
        int n = cost.length;
        
        /*
        n이 16밖에 없다.
        완탐 ㄱㄱ
        지금 있는 스테이지에서 힌트를 사는 것이 최적인지 확인하기 위해 밑에 애들도 확인
        */
        int[][] count = new int[n][n];
        int[] costs = new int[n];
        for(int i=0 ; i<n-1 ; i++){
            costs[i] = hint[i][0];
            for(int j=1 ; j<hint[i].length ; j++){
                count[i][hint[i][j] - 1]++;
            }
        }
        
        list = new ArrayList<>();
        list.add(new ArrayList<>());
        dfs(0, n - 1, 0, new ArrayDeque<>());
        
        for(int i=0 ; i<list.size() ; i++){
            Map<Integer, Boolean> map = new HashMap<>();
            int[] totalCount = new int[n];
            int maxValue = 0;
            
            for(int num : list.get(i))
                map.put(num, true);
            
            for(int r=0 ; r<n ; r++){
                maxValue += cost[r][Math.min(totalCount[r], n - 1)];
                if(map.containsKey(r)){
                    for(int c=0 ; c<count[r].length ; c++){
                        totalCount[c] += count[r][c];
                    }
                    maxValue += costs[r];
                }
            }
            
            answer = Math.min(answer, maxValue);
        }
        
        return answer;
    }
    
    void dfs(int start, int n, int visit, ArrayDeque<Integer> path){
        if(!path.isEmpty())
            list.add(new ArrayList<>(path));
        
        for(int i=start ; i<n ; i++){
            if((visit & (1 << i)) != 0)
                continue;
            
            path.add(i);
            dfs(i + 1, n, visit | (1 << i ), path);
            path.pollLast();
        }
    }
}