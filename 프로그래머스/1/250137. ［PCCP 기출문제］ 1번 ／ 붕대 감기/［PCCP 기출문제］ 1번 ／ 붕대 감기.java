class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health, prev = 0, cnt = 0;
        
        for(int[] attack : attacks){
            int timeDiff = attack[0] - prev - 1;
            
            answer += bandage[1] * timeDiff;
            cnt = (timeDiff / bandage[0]) * bandage[2];
            answer += cnt;
            
            if(answer > health)
                answer = health;
            
            answer -= attack[1];
            prev = attack[0];
            
            if(answer <= 0){
                answer = -1;
                break;
            }
        }
        
        return answer;
    }
}