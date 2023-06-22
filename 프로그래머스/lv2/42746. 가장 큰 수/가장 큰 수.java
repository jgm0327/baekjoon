import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        String[] list = new String[numbers.length];

        for(int i=0 ; i<numbers.length; i++){
            list[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(list, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        for(String num : list){
            answer.append(num);
        }
        if(answer.toString().replaceAll("0", "").length() == 0)return "0";
        return answer.toString();
    }
}