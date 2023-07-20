class Solution {
    private int[] answer, dy = {0, 0, 1, 1}, dx = {0, 1, 0, 1};
    
    public int[] solution(int[][] arr) {
        answer = new int[]{0, 0};
        recur(arr, 0, 0, arr.length);
        return answer;
    }
    
    private void recur(final int[][] arr, int y, int x, int size){
        if(size == 1 || isAllSame(arr, y, x, size)){
            answer[arr[y][x]]++;
            return;
        }
        
        int nsize = size / 2;
        for(int i=0 ; i<4 ; i++){
            int ny = y + nsize * dy[i], nx = x + nsize * dx[i];
            if(0 > ny || ny >= arr.length || nx < 0 || nx >= arr[0].length)
                continue;
            recur(arr, ny, nx, nsize);
        }
    }
    
    private boolean isAllSame(final int[][] arr, int y, int x, int size){
        int num = arr[y][x];
        for(int i = y ; i < y + size ; i++){
            for(int j = x ; j < x + size ; j++){
                if(num != arr[i][j])return false;
            }
        }
        return true;
    }
}