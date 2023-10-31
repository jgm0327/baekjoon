class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        
        int left = 0, right = 200000001;
        
        while(left <= right){
            int mid = (left + right) / 2;
            int cnt = 0;
            boolean flag = false;
            
            for(int i=0 ; i<stones.length ; i++){
                if(stones[i] - mid <= 0)cnt++;
                else cnt = 0;
                if(cnt >= k){
                    flag = true;
                    break;
                }
            }
            
            if(flag){
                right = mid - 1;
            }else{
                left = mid + 1;
                answer = Math.max(answer, mid);
            }
        }
        
        return answer + 1;
    }
}