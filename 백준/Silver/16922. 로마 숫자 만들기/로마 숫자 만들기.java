import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class Main{
    private static Map<Integer, Map<Integer, Boolean>> visit;
    private static Map<Integer, Boolean> answer;
    private static final int[] number = {1, 5, 10, 50};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        visit = new HashMap<>();
        answer = new HashMap<>();

        dfs(0, n, 0);
        System.out.println(answer.size());
    }

    private static void dfs(int depth, int end, int total){
        if(depth == end){
            answer.put(total, true);
            return;
        }

        for(int i=0 ; i<4 ; i++){
            int nextTotal = total + number[i];

            if(visit.containsKey(nextTotal) 
            && visit.get(nextTotal).containsKey(depth))
                continue;

            if(!visit.containsKey(nextTotal))visit.put(nextTotal, new HashMap<>());
            visit.get(nextTotal).put(depth, true);
            dfs(depth + 1, end, nextTotal);
        }
    }

}