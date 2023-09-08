import java.util.*;

class Solution {
    private boolean flag;
    private char[] ch = {'A', 'E', 'I', 'O', 'U'};
    private int answer = 0, cnt = 0;
    public int solution(String word) {
        flag = false;
        recur(0, new StringBuilder(), word);
        return answer -1;
    }
    
    private void recur(int depth, StringBuilder sb, String word){
        //System.out.println(sb);
        cnt++;
        if(sb.toString().equals(word)){
            flag = true;
            answer = cnt;
            return;
        }
        if(depth == 5){
            return;
        }
        for(int i=0 ; i<5 ; i++){
            sb.append(ch[i]);
            recur(depth + 1, sb, word);
            if(flag)return;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}