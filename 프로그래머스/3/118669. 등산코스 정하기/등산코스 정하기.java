import java.util.*;

class Solution {
    private List<int[]>[] graph;
    private Map<Integer, Boolean> gateNumbers, summitNumbers;
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        graph = new ArrayList[n + 1];
        for(int i=0 ; i<=n ; i++)
            graph[i] = new ArrayList<>();
        
        int maxValue = 0, minValue = Integer.MAX_VALUE;
        for(int[] path : paths){
            graph[path[0]].add(new int[]{path[1], path[2]});
            graph[path[1]].add(new int[]{path[0], path[2]});
            
            maxValue = Math.max(maxValue, path[2]);
            minValue = Math.min(minValue, path[2]);      
        }
        
        gateNumbers = new HashMap<>();
        for(int gate : gates){
            gateNumbers.put(gate, true);
        }
        
        summitNumbers = new HashMap<>();
        for(int summit : summits){
            summitNumbers.put(summit, true);
        }
        
        int left = minValue, right = maxValue;
        int number = Integer.MAX_VALUE, intensity = Integer.MAX_VALUE;
        
        Arrays.sort(summits);
        while(left <= right){
            int mid = (left + right) / 2;
            
            boolean exist = false;
            for(int summit : summits){
                if(dijkstra(summit, mid, n)){
                    intensity = mid;
                    number = summit;
                    exist = true;
                    break;
                }
            }
            
            if(exist)
                right = mid - 1;
            else
                left = mid + 1;
        }
        
        return new int[]{number, intensity};
    }
    
    private boolean dijkstra(int start, int k, int n){
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.add(new int[]{start, 0});
        
        int[] costs = new int[n + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[start] = 0;
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            
            int sour = cur[0], dist = cur[1];
            if(costs[sour] < dist)
                continue;
            
            for(int[] des : graph[sour]){
                int number = des[0], nextCost = dist + des[1];
                
                if(nextCost >= costs[number] || summitNumbers.containsKey(number) 
                   || des[1] > k)
                    continue;
                
                if(gateNumbers.containsKey(number))
                    return true;
                
                costs[number] = nextCost;
                pq.add(new int[]{number, nextCost});
            }
        }
        
        return false;
    }
}