class Solution {
    public String solution(int a, int b) {
        String[] day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int[] year = {0,3,3,4,4,4,4,4,4,4,4,4,4};
        int[] month = {0,1,4,4,0,2,5,0,3,6,1,4,6};
        
        return day[(year[a] + month[a] + b) % 7];
    }
}