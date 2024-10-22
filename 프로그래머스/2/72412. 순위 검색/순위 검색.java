import java.util.*;

class Solution {
    List<String> keys;
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        Map<String, List<Integer>> scores = new HashMap<>();
        String[][] str = {{"cpp", "java", "python"}, {"backend", "frontend"}, {"junior", "senior"}, {"chicken", "pizza"}};
        
        for(String i : info){
            String[] split = i.split(" ");
            String key = generateKey(split);
            
            if(!scores.containsKey(key)){
                scores.put(key, new ArrayList<>());
            }
            
            scores.get(key).add(Integer.parseInt(split[4]));
        }
        
        for(String key : scores.keySet()){
            Collections.sort(scores.get(key));
        }
        
        for(int i=0 ; i<query.length ; i++){
            String[] split = query[i].split(" ");
            
            keys = new ArrayList<>();    
            combination(str, split, 0, new StringBuilder());
            
            int ret = 0;
            for(String key : keys){
                if(!scores.containsKey(key))
                    continue;
                int idx = binarySearch(scores.get(key), Integer.parseInt(split[7]));
                ret += scores.get(key).size() - idx;
            }
            
            answer[i] = ret;
        }
        
        return answer;
    }
    
    private int binarySearch(List<Integer> list, int target){
        int left = 0, right = list.size() - 1;
        int ret = 0;
        while(left <= right){
            int mid = (left + right) / 2;
            
            if(list.get(mid) < target)
                left = mid + 1;
            else {
                right = mid - 1;
            }
        }
        
        return left;
    }
    
    private String generateKey(String[] infos){
        StringBuilder key = new StringBuilder();
        
        for(int i=0 ; i<infos.length - 1 ; i++){
            key.append(infos[i]);
        }
        
        return key.toString();
    }
    
    private void combination(String[][] str, String[] q, int depth, StringBuilder path){
        if(depth >= 7){
            keys.add(path.toString());
            return;
        }
        
        if(!q[depth].equals("-")){
            path.append(q[depth]);
            combination(str, q, depth + 2, path);
            path.delete(path.length() - q[depth].length(), path.length());
            return;
        }
        
        for(String s : str[depth / 2]){
            path.append(s);
            combination(str, q, depth + 2, path);
            path.delete(path.length() - s.length(), path.length());   
        }
    }
}