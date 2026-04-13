import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {};
        int[] count = new int[n];
        Map<String, Boolean> exist = new HashMap<>();

        for(int i=0 ; i<words.length ; i++){
            String word = words[i];
            count[i % n]++;
            if((i > 0 && words[i - 1].charAt(words[i - 1].length() - 1) != word.charAt(0))
                || exist.containsKey(word)){
                return new int[]{(i % n) + 1, count[i % n]};
            }
            
            exist.put(word, true);
        }

        return new int[]{0, 0};
    }
}