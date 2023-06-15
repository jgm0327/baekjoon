class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        backtracking(numbers, target, 0, 0);
        return answer;
    }
    
    private void backtracking(int[] numbers, int target, int i, int total){
        if(i >= numbers.length){
            if(total == target)answer++;
            return;
        }
        backtracking(numbers, target, i + 1, total + numbers[i]);
        backtracking(numbers, target, i + 1, total - numbers[i]);
    }
}