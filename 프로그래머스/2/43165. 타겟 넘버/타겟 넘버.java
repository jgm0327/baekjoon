class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        return dfs(numbers, 0, target, 0);
    }
    
    private int dfs(int[] numbers, int idx, int target, int total){
        if(numbers.length == idx){
            if(total == target)
                return 1;
            return 0;
        }
        
        return dfs(numbers, idx + 1, target, total + numbers[idx]) + dfs(numbers, idx + 1, target, total - numbers[idx]);
    }
}