import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Main{
    private static Map<String, Integer> pre;
    private static Map<String, List<String>> graph;
    private static Map<String, List<String>> child;
    private static List<String> nameList;
    private static Set<String> first;

    private static int n, m;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        nameList = new ArrayList<>();
        pre = new HashMap<>();
        graph = new HashMap<>();
        child = new HashMap<>();

        StringTokenizer stk = new StringTokenizer(br.readLine());

        for(int i=0 ; i<n ; i++){
            String name = stk.nextToken();
            nameList.add(name);
            pre.put(name, 0);
            graph.put(name, new ArrayList<>());
            child.put(name, new ArrayList<>());
        }

        Collections.sort(nameList);

        m = Integer.parseInt(br.readLine());
        
        while(m-- > 0){
            stk = new StringTokenizer(br.readLine());
            String asc = stk.nextToken();
            String desc = stk.nextToken();

            graph.get(desc).add(asc);
            pre.put(asc, pre.get(asc) + 1);
        }
        
        Queue<String> que = new LinkedList<>();
        
        first = new TreeSet<>();
        for(String name : nameList){
            if(pre.get(name) != 0)
                continue;

            que.add(name);
            first.add(name);
        }
        
        topologicalSort(que);
        
        // 출력
        StringBuilder answer = new StringBuilder();

        answer.append(first.size()).append("\n");

        for(String name : first){
            answer.append(name).append(" ");
        }
        answer.append("\n");

        for(String name : nameList){
            answer.append(name).append(" ")
            .append(child.get(name).size()).append(" ");

            Collections.sort(child.get(name));
            for(String childName : child.get(name)){
                answer.append(childName).append(" ");
            }

            answer.append("\n");
        }

        System.out.print(answer);
        
    }

    private static void topologicalSort(Queue<String> que){
        while(!que.isEmpty()) {
            String sour = que.poll();

            for(String des : graph.get(sour)){
                pre.put(des, pre.get(des) - 1);
                
                if(pre.get(des) == 0){
                    que.add(des);
                    child.get(sour).add(des);
                    continue;
                }

            }
        }
    }
}