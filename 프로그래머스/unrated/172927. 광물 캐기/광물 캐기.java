import java.util.*;

class Solution {
    private Map<String, Integer> pickaxe;
    private int answer = Integer.MAX_VALUE, cnt;
    public int solution(int[] picks, String[] minerals) {
        pickaxe = Map.of("diamond", 0, "iron", 1, "stone", 2);
        for(int i=0 ; i<3 ; i++)cnt += picks[i];
        recur(picks, minerals, 0, 0);
        return answer;
    }
    
    private void recur(int[] picks, final String[] minerals, int start, int total){
        if(start >= minerals.length){
            answer = Math.min(total, answer);
            return;
        }
        
        for(int i=0 ; i<3 ; i++){
            if(picks[i] == 0)continue;
            picks[i]--;
            cnt--;
            int temp = 0;
            for(int j=start ; j<start+5; j++){
                if(j == minerals.length)break;
                temp += score(i, minerals[j]);
            }
            recur(picks, minerals, start+5, total+temp);
            if(cnt == 0){
                answer = Math.min(answer, total+temp);
            }
            cnt++;
            picks[i]++;
        }
    }
    
    private int score(int pick, String mineral){
        int comp = pick - pickaxe.get(mineral);
        if(comp <= 0)return 1;
        if(comp == 1)return 5;
        else return 25;
    }
}