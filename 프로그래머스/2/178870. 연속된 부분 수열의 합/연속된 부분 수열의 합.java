class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0, 1000000};
        
        int left = 0, right = 0;
        int total = 0;
        
        while(left <= right && right < sequence.length){
            if(total + sequence[right] > k){
                total -= sequence[left++];
            }else if(total + sequence[right] < k){
                total += sequence[right++];
            }else{
                if(answer[1] - answer[0] > right - left){
                    answer = new int[]{left, right};
                }
                total += sequence[right++];
            }
        }
        
        return answer;
    }
}