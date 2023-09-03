import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        while(T-- > 0){
            int n = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> pq = new TreeMap<>();
            for(int i=0 ; i<n ; i++){
                StringTokenizer stk = new StringTokenizer(br.readLine());
                String opt = stk.nextToken();
                int data = Integer.parseInt(stk.nextToken());

                if(opt.equals("I")){
                    pq.put(data, pq.getOrDefault(data, 0) + 1);
                }else if(!pq.isEmpty()){
                    if(data == 1){
                        int last = pq.lastKey();
                        pq.put(last, pq.get(last) - 1);
                        if(pq.get(last) == 0) pq.remove(last);
                    }else{
                        int first = pq.firstKey();
                        pq.put(first, pq.get(first) - 1);
                        if(pq.get(first) == 0)pq.remove(first);
                    }
                }
            }
            if(pq.isEmpty())answer.append("EMPTY\n");
            else answer.append(pq.lastKey()).append(" ").append(pq.firstKey()).append("\n");
        }
        System.out.print(answer);
        br.close();
    }
}