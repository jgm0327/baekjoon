class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for(int len = 1 ; len < s.length() ; len++){
            StringBuilder comp = new StringBuilder(s.substring(0, len));
            int idx = 0, cnt = 0;
            boolean isCompressed = false;
            // System.out.println("-------------------------------------------------");
            // System.out.println(len+"\n");
            StringBuilder compressWord = new StringBuilder();
            while(idx < s.length()){
                int end_idx = idx + len;
                if(end_idx > s.length())break;
                
                if(comp.toString().equals(s.substring(idx, end_idx))){
                    isCompressed = true;
                    idx = end_idx;
                    cnt++;
                }else if(isCompressed){
                    if(cnt <= 1)compressWord.append(comp.toString());
                    else compressWord.append(cnt + comp.toString());
                    cnt = 0;
                    comp = new StringBuilder(s.substring(idx, end_idx));
                    isCompressed = false;
                }else{
                    compressWord.append(comp.toString());
                    idx++;
                    comp = new StringBuilder(s.substring(idx, end_idx + 1));
                }
            }
            while(idx < s.length())compressWord.append(s.charAt(idx++));
            if(isCompressed){
                if(cnt <= 1)compressWord.append(comp.toString());
                else compressWord.append(cnt + comp.toString());
            }
            if(compressWord.length() == 0)continue;
            answer = Math.min(answer, compressWord.length());
        }
        return answer;
    }
}