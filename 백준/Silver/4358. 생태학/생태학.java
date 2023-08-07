import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, Integer> map = new TreeMap<>();
        
        String tree = "";
        int size = 0;

        while((tree = br.readLine()) != null){
            map.put(tree, map.getOrDefault(tree, 0) + 1);
            size++;
        }

        for(String key : map.keySet()){
            System.out.printf("%s %.4f\n", key, ((double)map.get(key) / size) * 100);
        }
        br.close();
    }
}