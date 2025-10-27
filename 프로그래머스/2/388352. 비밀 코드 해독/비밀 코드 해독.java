import java.util.*;
// 20분
class Solution {
    List<List<Integer>> list;
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;
        list = new ArrayList<>();
        getAllCases(1, n, new ArrayDeque<>());
        
        for(List<Integer> data : list){
             if(!checkCanPassword(data, q, ans))
                 continue;
            
            answer++;
        }
        
        return answer;
    }
    
    boolean checkCanPassword(List<Integer> data, int[][] q, int[] ans){
        for(int i=0 ; i<q.length ; i++){
            int cnt = 0;
            for(int target : data){
                boolean find = binarySearch(target, q[i]);
                if(!find)
                    continue;
                
                cnt++;
            }
            
            if(cnt != ans[i])
                return false;
            
        }   
        
        return true;
    }
    
    void getAllCases(int start, int n, ArrayDeque<Integer> path){
        if(path.size() == 5){
            list.add(new ArrayList<>(path));
            return;
        }
        
        for(int i=start ; i<=n ; i++){
            path.add(i);
            getAllCases(i + 1, n, path);
            path.pollLast();
        }
    }

    
    boolean binarySearch(int target, int[] arr){
        int left = 0, right = arr.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            
            if(target == arr[mid])return true;
            else if(target > arr[mid])left = mid + 1;
            else right = mid - 1;
        }
        
        return false;
    }
}