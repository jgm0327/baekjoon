import java.util.*;

class Solution {
    int[] pre;
    int n;
    List<Integer>[] graph;
    
    public long solution(int[] a, int[][] edges) {
        long answer = 0;
        n = a.length;
        
        pre = new int[n];
        graph = new ArrayList[n];
        
        int total = 0;
        long[] arr = new long[n];
        for(int i=0 ; i<n ; i++){
            total += a[i];
            arr[i] = a[i];
            graph[i] = new ArrayList<>();
        }
        
        if(total != 0)
            return -1;
        
        for(int[] edge : edges){
            int s = edge[0], d = edge[1];
            
            graph[s].add(d);
            graph[d].add(s);
            
            pre[s]++;
            pre[d]++;
        }
        
        ArrayDeque<Integer> que = new ArrayDeque<>();
        boolean[] visit = new boolean[n];
        for(int i=0 ; i<n ; i++){
            if(pre[i] != 1)
                continue;
            que.add(i);
            visit[i] = true;
        }
        
        return topology(que, visit, arr);
    }
    
    long topology(ArrayDeque<Integer> que, boolean[] visit, long[] a){
        long ret = 0;
        
        while(!que.isEmpty()) {
            int sour = que.poll();
            
            // System.out.println(sour);
            for(int des : graph[sour]){
                pre[des]--;
                
                // System.out.println(Arrays.toString(a));
                if(!visit[des]) {
                    ret += Math.abs(a[sour]);   
                    a[des] += a[sour];
                    a[sour] = 0;
                }
                
                if(pre[des] != 1)
                    continue;
                
                visit[des] = true;
                que.add(des);
            }
        }
        
        for(long num : a){
            if(num != 0){
                ret += Math.abs(num);
                break;
            }
        }
        
        return ret;
    }
}