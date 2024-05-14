import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> answer = new ArrayList<>();
        int extIdx = findIndex(ext);
        int sortIdx = findIndex(sort_by);
        
        Arrays.sort(data, (o1, o2) -> o1[sortIdx] - o2[sortIdx]);
        
        for(int[] filterData : data){
            if(filterData[extIdx] >= val_ext)
                continue;
            
            answer.add(filterData);
        }
        
        return answer.stream()
            .toArray(int[][]::new);
    }
    
    private int findIndex(String by){
        if(by.equals("code"))return 0;
        if(by.equals("date"))return 1;
        if(by.equals("maximum"))return 2;
        return 3;
    }
}