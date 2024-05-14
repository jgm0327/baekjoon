import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0, n = friends.length;
        int[][] histories = new int[n][n];
        
        // {{받은 선물, 준 선물}}
        int[][] giftCount = new int[n][2];
        
        HashMap<String, Integer> nameIdx = new HashMap<>();
        
        for(int i=0 ; i<n ; i++){
            nameIdx.put(friends[i], i);
        }
        
        for(String gift : gifts){
            String[] split = gift.split(" ");
            int A = nameIdx.get(split[0]), B = nameIdx.get(split[1]);
            
            histories[A][B]++;
            giftCount[A][1]++;
            giftCount[B][0]++;
        }
        
        int[] zisu = new int[n];
        for(int i=0 ; i<n ; i++){
            zisu[i] = giftCount[i][1] - giftCount[i][0];
        }
            
        int[] nextGiftCount = new int[n];
        
        for(int A=0 ; A<n ; A++){
            for(int B=A+1 ; B<n ; B++){
                if(histories[A][B] > histories[B][A]){
                    nextGiftCount[A]++;
                }else if(histories[A][B] < histories[B][A]){
                    nextGiftCount[B]++;
                }else if((histories[A][B] == 0 && histories[B][A] == 0) 
                         || histories[A][B] == histories[B][A]){
                    if(zisu[A] > zisu[B])nextGiftCount[A]++;
                    else if(zisu[A] < zisu[B])nextGiftCount[B]++;
                }
            }
        }
        
        
        for(int i=0 ; i<n ; i++){
            answer = Math.max(answer, nextGiftCount[i]);
        }
        
        return answer;
    }
}