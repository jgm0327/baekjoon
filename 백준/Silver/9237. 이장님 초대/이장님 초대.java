import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        String[] values = br.readLine().split(" ");
        for(int i=0 ; i<n ; i++){
            list.add(Integer.parseInt(values[i]));
        }
        Collections.sort(list, Collections.reverseOrder());
        
        int answer = 0;
        for(int i=0 ; i<n ; i++){
            int time = list.get(i);
            if(answer < time + i){
                answer = time + i;
            }
        }
        System.out.println(answer + 2);
        br.close();
    }
}