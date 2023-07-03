class Solution {
    private boolean[] visit;
    
    public int solution(int[] cards) {
        int answer = 0;
        
        for(int i=0 ; i<cards.length ; i++){
            int group1 = 0, group2 = 0;
            System.out.println(i + " ----------------------------------------");
            visit = new boolean[cards.length];
            
            group1 = getRemind(i, cards);
            if(group1 == 0)continue;
            
            for(int j=0 ; j<cards.length; j++){
                if(!visit[j]){
                    System.out.println(j + "************************************");
                    group2 = getRemind(j, cards);
                }
                System.out.println(group1 + " " + group2);
                answer = Math.max(answer, group1 * group2);
            }
        }
        
        return answer;
    }
    
    private int getRemind(int idx, final int[] cards){
        int ret = 0;
        while(!visit[idx]){
                ret++;
                visit[idx] = true;
                idx=cards[idx] - 1;
        }
        return ret;
    }
}