import java.util.*;

class Solution {
    List<int[]>[] graph;
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = {0, 0};
        graph = new ArrayList[n + 1];
        for(int i=0 ; i<=n ; i++)
            graph[i] = new ArrayList<>();
        
        int right = 0, left = Integer.MAX_VALUE;
        for(int[] path : paths){
            int a = path[0], b = path[1], d = path[2];
            graph[a].add(new int[]{b, d});
            graph[b].add(new int[]{a, d});
            
            right = Math.max(right, d);
            left = Math.min(left, d);
        }
        Arrays.sort(gates);
        Arrays.sort(summits);
        
        while(left <= right){
            int mid = (left + right) / 2;
            
            boolean flag = false;
            int start = 0;
            for(int num : summits){
                if(bfs(num, mid, gates, summits)){
                    start = num;
                    flag = true;
                    break;
                }
            }
            
            if(flag){
                right = mid - 1;
                answer[0] = start;
                answer[1] = mid;
            }
            else
                left = mid + 1;
        }
        
        return answer;
    }
    
    boolean bfs(int start, int max, int[] gates, int[] summits){
        Queue<Integer> que = new ArrayDeque<>();
        que.add(start);
        
        boolean[] visit = new boolean[graph.length];
        visit[start] = true;
        
        while(!que.isEmpty()){
            int cur = que.poll();
            
            for(int[] next : graph[cur]){
                if(visit[next[0]] || binarySearch(next[0], summits) 
                   || next[1] > max)
                    continue;
                
                if(binarySearch(next[0], gates))
                    return true;
                
                visit[next[0]] = true;
                que.add(next[0]);
            }
        }
        
        return false;
    }
    
    boolean binarySearch(int target, int[] arr){
        int left = 0, right = arr.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            
            if(target == arr[mid])
                return true;
            else if(target < arr[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }
        return false;
    }
}