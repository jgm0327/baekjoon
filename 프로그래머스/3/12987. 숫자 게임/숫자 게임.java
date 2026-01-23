import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        /*
            1 3 5 7
            2 2 6 8
        */
        boolean[] visit = new boolean[A.length];
        for(int i=0 ; i<B.length ; i++){
            int idx = bisectLeft(B[i], A);
            
            if(idx < 0)
                continue;
            
            idx = Math.min(idx, A.length - 1);
            while(idx >= 0 && (visit[idx] || A[idx] >= B[i])){
                idx--;
            }
            
            if(idx < 0)
                continue;
            
            visit[idx] = true;
            answer++;
        }
        return answer;
    }
    
    int bisectLeft(int target, int[] arr){
        int left = 0, right = arr.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            
            if(target < arr[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }
        
        return left;
    }
}