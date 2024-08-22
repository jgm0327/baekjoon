import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String T = br.readLine();

        System.out.println(bfs(S, new StringBuilder(T)));

        br.close();
    }

    private static int bfs(final String S, StringBuilder T){
        Queue<StringBuilder> que = new ArrayDeque<>();
        que.add(new StringBuilder(T));

        Map<String, Boolean> visit = new HashMap<>();

        while(!que.isEmpty()){
            StringBuilder cur = new StringBuilder(que.poll());

            if(cur.charAt(cur.length() - 1) == 'A'){
                String temp = new String(cur.deleteCharAt(cur.length() - 1));

                if(S.equals(temp))return 1;

                if(!visit.containsKey(temp) && S.length() < temp.length()){
                    que.add(new StringBuilder(temp));
                    visit.put(temp.toString(), true);
                }

                cur.append('A');
            }

            if(cur.charAt(0) == 'B'){
                String temp = new String(cur.deleteCharAt(0).reverse());

                if(S.equals(temp))return 1;

                if(!visit.containsKey(temp) && S.length() < temp.length()){
                    que.add(new StringBuilder(temp));
                    visit.put(temp.toString(), true);
                }
            }
        }

        return 0;
    }
}