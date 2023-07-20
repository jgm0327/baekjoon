import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> list = Arrays.stream(num_list).boxed().collect(Collectors.toList());
        
        switch(n){
            case 1:
                answer = list.subList(0, slicer[1] + 1);
                break;
            case 2:
                answer = list.subList(slicer[0], num_list.length);
                break;
            case 3:
                answer = list.subList(slicer[0], slicer[1] + 1);
                break;
            case 4:
                for(int i=slicer[0] ; i<=slicer[1] ; i+=slicer[2]){
                    answer.add(num_list[i]);
                }
                break;
        }
        return answer.stream().mapToInt(v -> v).toArray();
    }
}