import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        Map<Character, Boolean> map = new HashMap<>();
        for(int i=0 ; i<skip.length() ; i++){
            map.put(skip.charAt(i), true);
        }
        
        for(int i=0 ; i<s.length(); i++){
            int cnt = 0;
            char ch = s.charAt(i);
            while(cnt < index){
                ch = (char)(1 + (int)ch);
                if(ch > 'z')ch = (char)(ch - 'z' + 'a' - 1);
                if(map.containsKey(ch))continue;
                cnt++;
            }
            answer += ch;
        }
        return answer;
    }
}