import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Integer> count = new HashMap<>();
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        List<String> words = new ArrayList<>();

        for(int i=0 ; i<n ; i++){
            String word = br.readLine();
            if(word.length() < m)
                continue;

            if(!count.containsKey(word))
                words.add(word);
            count.put(word, count.getOrDefault(word, 0) + 1);
        }

        Collections.sort(words, (o1, o2) -> {
            if(count.get(o1) != count.get(o2))
                return count.get(o2) - count.get(o1);
            if(o1.length() != o2.length())
                return o2.length() - o1.length();
            return o1.compareTo(o2);
        });

        StringBuilder answer = new StringBuilder();
        for(String word : words){
            answer.append(word).append("\n");
        }

        bw.write(answer.toString());
        bw.close();
        br.close();
    }
}