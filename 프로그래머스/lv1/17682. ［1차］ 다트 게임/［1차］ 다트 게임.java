import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        LinkedList<Integer> result = new LinkedList<>();
        Map<Character, Integer> power = Map.of('S', 1, 'D', 2, 'T', 3);
        
        String score = "";
        int number = 0;
        for(int i = 0 ; i < dartResult.length() ; i++){
            char ch = dartResult.charAt(i);
            if('0' <= ch && ch <= '9'){
                score += ch;
            }else if(ch == 'S' || ch == 'D' || ch == 'T'){
                number = power(Integer.parseInt(score), power.get(ch));
                result.add(number);
                score = "";
                number = 0;
            }
            else if(ch == '*'){
                int data;
                data = result.pollLast();
                if(!result.isEmpty()){
                    result.add(2 * result.pollLast());
                }
                result.add(2 * data);
            }
            else if(ch == '#'){
                result.add(-result.pollLast());
            }
        }
        
        while(!result.isEmpty()){
            System.out.println(result.peek());
            answer += result.poll();
        }
        System.out.println(number);
        answer += number;
        return answer;
    }
    
    private int power(int number, int pow){
        int ret = 1;
        for(int i=0 ; i<pow ; i++){
            ret *= number;
        }
        return ret;
    }
}