class Solution {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int)(end - begin) + 1];
        int f = (int)begin;
        int l = (int)end;
        
        int idx = 0;
        for(int i=f ; i<=l ; i++){
            answer[idx] = 1;
            
            for(int div = 2 ; div <= Math.sqrt(i) ; div++){
                if(i % div == 0){
                    if(i / div > 10_000_000)
                        answer[idx] = div;
                    else{
                        answer[idx] = i / div;
                        break;
                    }
                }
            }
            
            System.out.println();
            idx++;
        }
        
        if(f == 1)
            answer[0] = 0;
        
        return answer;
    }
}