class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        
        int cnt = 1, idx = -1;
        while(cnt <= n){
            for(int j=0 ; j<w && cnt <= n ; j++){
                
                if(num == cnt)
                    idx = j;
                if(idx == j)
                    answer++;
                
                cnt++;
            }
            
            for(int j=w-1 ; j>=0 && cnt <= n ; j--){
                
                if(num == cnt)
                    idx = j;
                if(idx == j)
                    answer++;
                
                cnt++;
            }
        }
        
        return answer;
    }
}