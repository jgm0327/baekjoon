import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        
        int n = Integer.parseInt(input[0]);
        String game = input[1];

        Map<String, Integer> gameIndex = Map.of("Y", 0, "F", 1, "O", 2);
        final int[] needPeople = {1, 2, 3};

        Map<String, Boolean> exist = new HashMap<>();
        int answer = 0, count = 0;
        for(int i=0 ; i<n ; i++){
            String name = br.readLine();

            if(exist.containsKey(name))continue;

            count++;
            exist.put(name, true);
            if(count == needPeople[gameIndex.get(game)]){
                answer++;
                count = 0;
            }
        }

        System.out.println(answer);
        br.close();
    }
}