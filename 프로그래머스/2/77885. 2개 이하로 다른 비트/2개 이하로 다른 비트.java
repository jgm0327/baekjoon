class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        int idx = 0;
        
        for(long number : numbers){
            long temp = number;
            long shift = 0;
            
            while(true){
                if((number | (1L << shift)) != number)
                    break;
                shift++;
            }
            
            number = number | (1L << shift);
            if(shift > 0)
                number = number ^ (1L << (shift - 1));
            
            answer[idx++] = number;
        }
        
        
        return answer;
    }
}