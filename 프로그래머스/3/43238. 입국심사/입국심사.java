class Solution {
    public long solution(int n, int[] times) {
        long left = 0, right = (long)1e18;
        while(left <= right){
            long mid = (left + right) / 2;
            
            long total = 0;
            for(int time : times){
                total += (mid / time);
            }
            
            if(total >= n)
                right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }
}