class Solution {
    public int[] solution(String[] wallpaper) {
        int n = wallpaper.length, m = wallpaper[0].length();
        int sy = Integer.MAX_VALUE, sx = Integer.MAX_VALUE, ey = 0, ex = 0;
        
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(wallpaper[i].charAt(j) == '#'){
                    sy = Math.min(sy, i);
                    sx = Math.min(sx, j);
                    ey = Math.max(ey, i + 1);
                    ex = Math.max(ex, j + 1);
                }
            }
        }
        return new int[]{sy, sx, ey, ex};
    }
}