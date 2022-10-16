class Solution {
    public String solution(String s) {
        String answer = "";
        char[] str = s.toCharArray();
        int idx = 0;
        
        for(int i=0 ; i<str.length; i++){
            char temp = str[i];
            if(temp == ' '){
                idx = 0;
                answer += temp;
                continue;
            }
            if(idx % 2 == 0 && ('a' <= str[i] && str[i] <= 'z'))
                temp = (char)(str[i] - 32);
            else if(idx % 2 == 1 && ('A' <= str[i] && str[i] <= 'Z'))
                temp = (char)(str[i] + 32);
            idx += 1;
            answer += temp;
        }
        
        return answer;
    }
}