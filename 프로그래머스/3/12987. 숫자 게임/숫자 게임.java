import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        
        int left = 0, right = A.length - 1;
        
        for(int number : A){
            left = bisectLeft(B, left, number);
            
            if(left < B.length && B[left] > number){
                answer++;
                left++;
            }
        }
        
        return answer;
    }
    
    private int bisectLeft(int[] B, int start, int target){
        int left = start, right = B.length - 1;
        
        while(left <= right){
            int mid = (left + right) / 2;
            
            if(B[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        
        return left;
    }
}