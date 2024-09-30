import java.util.*;

class Solution {
    private ArrayDeque<Integer> path;
    private Map<Integer, Boolean> remain;
    private List<Integer> answer;
    private List<Case> cases;
    private boolean[] visit;
    private int maxValue;
    
    class Case{
        List<Integer> A;
        List<Integer> B;
        
        public Case(ArrayDeque<Integer> A, Set<Integer> B){
            this.A = new ArrayList<>(A);
            this.B = new ArrayList<>(B);
        }
        
        @Override
        public String toString(){
            StringBuilder ret = new StringBuilder();
            
            ret.append("A: ");
            for(int a : A){
                ret.append(a).append(" ");
            }
            ret.append("\n");
            
            ret.append("B: ");
            for(int b : B){
                ret.append(b).append(" ");
            }
            ret.append("\n");
            
            return ret.toString();
        }
        
    }
    public int[] solution(int[][] dice) {
        int n = dice.length;
        
        remain = new HashMap<>();
        for(int i=0 ; i<n ; i++){
            remain.put(i, true);
        }
        
        cases = new ArrayList<>();
        answer = new ArrayList<>();
        path = new ArrayDeque<>();
        visit = new boolean[n];
        
        dfs(dice, n / 2, 0);
        
        for(Case c : cases){
            findMaxWinCount(c, dice);
        }
        
        return answer.stream().mapToInt(Integer::intValue)
            .map(i -> i + 1).toArray();
    }
    
    private void dfs(int[][] dice, int n, int start){
        if(n == 0){
            cases.add(new Case(path, remain.keySet()));
            return;
        }
        
        for(int i=start ; i<dice.length ; i++){
            if(visit[i])
                continue;
            
            visit[i] = true;
            remain.remove(i);
            path.add(i);
            
            dfs(dice, n - 1, i + 1);
            
            path.pollLast();
            remain.put(i, true);
            visit[i] = false;
        }
    }
    
    private int binarySearch(int target, List<Integer> B){
        int left = 0, right = B.size() - 1;
     
        while(left <= right){
            int mid = (left + right) / 2;
            
            if(target <= B.get(mid))right = mid - 1;
            else left = mid + 1;
        }
        
        return right;
    }
    
    private void findMaxWinCount(Case c, int[][] dice){
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        
        getTotal(dice, c.A, 0, 0, A);
        getTotal(dice, c.B, 0, 0, B);
        
        Collections.sort(B);
        int total = 0;
        for(int a : A){
            int idx = binarySearch(a, B);
            // System.out.println(idx);
            if(idx < 0 || a == B.get(idx))
                continue;
            total += (idx + 1);
        }
        // System.out.println(c.A);
        // System.out.println(c.B);
        // System.out.println(A);
        // System.out.println(B);
        // System.out.println("total: " + total);
        if(maxValue < total){
            maxValue = total;
            answer = c.A;
            // System.out.println("enter");
        }
    }
    
    private void getTotal(int[][] dice, List<Integer> idx, int depth, int total, List<Integer> list){
        if(depth == idx.size()){
            list.add(total);
            return;
        }
        // System.out.println(depth + " " + idx);
        
        for(int i=0 ; i<6 ; i++){
            getTotal(dice, idx, depth + 1, total + dice[idx.get(depth)][i], list);
        }
    }
}