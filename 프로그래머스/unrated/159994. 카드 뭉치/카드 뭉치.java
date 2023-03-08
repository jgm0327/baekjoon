import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        int idx1=0, idx2=0, len1=cards1.length, len2=cards2.length;
        for(String str : goal){
            if(idx1 < len1 && cards1[idx1].equals(str))idx1++;
            else if(idx2 < len2 && cards2[idx2].equals(str))idx2++;
            else return "No";
        }
        return "Yes";
    }
}