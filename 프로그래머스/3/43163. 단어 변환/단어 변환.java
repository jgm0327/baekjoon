import java.util.*;

class Solution {
    class Node{
        int dist;
        String value;
        
        public Node(int dist, String value){
            this.dist = dist;
            this.value = value;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        return bfs(begin, target, words);
    }
    
    private int bfs(String begin, String target, String[] words){
        Queue<Node> que = new ArrayDeque<>();
        que.add(new Node(0, begin));
        
        Map<String, Boolean> visit = new HashMap<>();
        
        while(!que.isEmpty()){
            Node node = que.poll();
            
            List<String> list = getNextWords(node.value, words, visit);
            
            for(String word : list){
                
                if(word.equals(target))
                    return node.dist + 1;
                
                visit.put(word, true);
                que.add(new Node(node.dist + 1, word));
            }
            
        }
        
        return 0;
    }
    
    private List<String> getNextWords(String sour, String[] words, Map<String, Boolean> visit){
        List<String> list = new ArrayList<>();
        
        for(String word : words){
            if(visit.containsKey(word) || !differentOneWordCharacterBetweenTwoWord(sour, word))
                continue;
            
            list.add(word);
        }
        
        return list;
    }
    
    private boolean differentOneWordCharacterBetweenTwoWord(String sour, String target){
        int cnt = 0;
        
        for(int i=0 ; i<sour.length() ; i++){
            if(sour.charAt(i) == target.charAt(i))
                continue;
            
            if(cnt == 1)
                return false;
            
            cnt++;
        }
        
        return true;
    }
}