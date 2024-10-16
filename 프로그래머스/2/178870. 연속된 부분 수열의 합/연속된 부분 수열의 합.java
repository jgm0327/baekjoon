class Solution {
    public int[] solution(int[] sequence, int k) {
        if(sequence[0] == k)
            return new int[]{0,0};
        int[] answer = {0,0};
        int n = sequence.length;
        
        int left = 0, right = 1, len = Integer.MAX_VALUE;
        int total = sequence[0];
        
        while(right < n){
            if(right < n && sequence[right] + total <= k){
                total += sequence[right];
                
                if(total == k && len > right - left){
                    answer[0] = left;
                    answer[1] = right;
                    len = right - left;
                }
                
                right++;
            }
            else{
                total -= sequence[left++];
                
                if(total == k && len > right - left){
                    answer[0] = left;
                    answer[1] = right;
                    len = right - left;
                }
            }
            
            
            
            
        }
        
        return answer;
    }
}