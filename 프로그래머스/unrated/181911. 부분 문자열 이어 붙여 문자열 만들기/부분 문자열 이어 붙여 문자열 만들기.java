class Solution {
    public String solution(String[] my_strings, int[][] parts) {
        StringBuilder answer = new StringBuilder();
        for(int i=0 ; i<my_strings.length ; i++){
            int s = parts[i][0], e = parts[i][1];
            String str = my_strings[i].substring(s, e + 1);
            answer.append(str);
        }
        return answer.toString();
    }
}