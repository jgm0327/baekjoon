class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0, 1000000};
        
        int left = 0, right = 0;
        int total = sequence[0];
        
        while(left <= right && right < sequence.length){
            if(total > k){
                total -= sequence[left++];
            }else if(total < k){
                right++;
                if(right >= sequence.length)
                    break;
                total += sequence[right];
            }else{
                if(answer[1] - answer[0] > right - left){
                    answer = new int[]{left, right};
                }
                
                right++;
                if(right >= sequence.length)
                    break;
                total += sequence[right];
            }
        }
        
        return answer;
    }
}