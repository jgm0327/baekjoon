import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
    private static final String[] mbtiType = {"ISTJ", "ISFJ", "INFJ", "INTJ", "ISTP", "ISFP",
    "INFP", "INTP", "ESTP", "ESFP", "ENFP", "ENTP", "ESTJ", "ESFJ", "ENFJ", "ENTJ"};

    private static HashMap<String, Integer> mbti;
    private static int distTotal;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();

        while(T-- > 0){
            int n = Integer.parseInt(br.readLine());

            StringTokenizer tokenizer = new StringTokenizer(br.readLine());

            initMbti();

            for(int i=0 ; i<n ; i++){
                String type = tokenizer.nextToken();
                mbti.put(type, mbti.get(type) + 1);
            }

            distTotal = Integer.MAX_VALUE;

            dfs(new ArrayDeque<>());

            answer.append(distTotal).append("\n");
        }

        System.out.print(answer);
    }

    private static void initMbti(){
        mbti = new HashMap<>();

        for(String type : mbtiType){
            mbti.put(type, 0);
        }
    }

    private static void dfs(ArrayDeque<String> path){
        if(path.size() == 3){
            String[] select = new String[3];
            int idx = 0;

            for(String type : path){
                select[idx++] = type;
            }

            distTotal = Math.min(distTotal, calculateDistance(select[0], select[1]) + calculateDistance(select[1], select[2]) + calculateDistance(select[0], select[2]));
            return;
        }

        for(int i=0 ; i<16 ; i++){
            String type = mbtiType[i];
            if(mbti.get(type) == 0)
                continue;

            mbti.put(type, mbti.get(type) - 1);
            path.add(mbtiType[i]);
            dfs(path);
            path.pollLast();
            mbti.put(type, mbti.get(type) + 1);
        }
    }

    private static int calculateDistance(String stu1, String stu2){
        int dist = 0;

        for(int i=0 ; i<4 ; i++){
            if(stu1.charAt(i) == stu2.charAt(i))
                continue;

            dist++;
        }

        return dist;
    }
}