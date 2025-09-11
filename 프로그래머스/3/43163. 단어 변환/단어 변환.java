import java.util.*;

class Solution {
    
    class Word{
        int dist;
        long visit;
        String val;
        
        public Word(int dist, long visit, String val){
            this.dist = dist;
            this.visit = visit;
            this.val = val;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        Queue<Word> que = new ArrayDeque<>();
        que.add(new Word(0, 0, begin));
        
        Map<String, Boolean> visit = new HashMap<>();
        visit.put(begin, true);
        
        while(!que.isEmpty()){
            Word cur = que.poll();
            
            for(String word : words){
                if(visit.containsKey(word) || !onlyOneDifferent(word, cur.val))
                    continue;
                
                if(target.equals(word))
                    return cur.dist + 1;
                
                que.add(new Word(cur.dist + 1, 0, word));
                visit.put(word, true);
            }
        }
        
        return 0;
    }
    
    private boolean onlyOneDifferent(String word1, String word2){
        int cnt = 0;
        
        for(int i=0 ; i<word1.length() ; i++){
            if(word1.charAt(i) != word2.charAt(i))
                cnt++;
            
            if(cnt >= 2)
                break;
        }
        
        return cnt == 1;
    }
}