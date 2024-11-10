import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());

        int[] appliances = new int[k];
        ArrayDeque<Integer>[] order = new ArrayDeque[k + 1];
        for(int i=0 ; i<=k ; i++)
            order[i] = new ArrayDeque<>();

        tokenizer = new StringTokenizer(br.readLine());
        for(int i=0 ; i<k ; i++){
            appliances[i] = Integer.parseInt(tokenizer.nextToken());
            order[appliances[i]].add(i);
        }

        Map<Integer, Boolean> tap = new HashMap<>();
        int answer = 0;
        for(int i = 0 ; i < k ; i++){
            int appliance = appliances[i];

            if(tap.containsKey(appliance)){
                order[appliance].pollFirst();
                continue;
            }

            if(tap.size() < n){
                tap.put(appliance, true);   
            }
            else{
                int maxValue = 0, number = 0;
                for(int key : tap.keySet()){
                    if(order[key].isEmpty()){
                        number = key;
                        break;
                    }
                    
                    int o = order[key].peekFirst();
                    if(maxValue < o){
                        maxValue = o;
                        number = key;
                    }
                }

                tap.remove(number);
                if(!order[number].isEmpty() && order[number].peekFirst()< i)
                    order[number].pollFirst();
                answer++;
            }
            
            order[appliance].pollFirst();
            tap.put(appliance, true);
        }

        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }
}