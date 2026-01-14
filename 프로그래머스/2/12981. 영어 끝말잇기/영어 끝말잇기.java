import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] count = new int[n + 1];
        count[1] = 1;
        
        int number = 2;
        Map<String, Boolean> exist = new HashMap<>();
        exist.put(words[0], true);
        
        for(int i=1; i<words.length ; i++){
            count[number]++;
            
            if(words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)
              || exist.containsKey(words[i]) || words[i].length() == 1)
                return new int[]{number , count[number]};
            
            exist.put(words[i], true);
            number++;
            if(number > n)
                number = 1;
        }

        return new int[]{0, 0};
    }
}