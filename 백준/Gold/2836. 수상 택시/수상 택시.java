import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Main{
    static class Route implements Comparable<Route>{
        int start, end;

        public Route(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Route o){
            if(this.end != o.end )return this.end - o.end;
            return this.start - o.start;
        }
    }
    private static int n, m;
    private static List<Route> routes;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        routes = new ArrayList<>();

        for(int i=0 ; i<n ; i++){
            stk = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());
            if(start <= end)continue;

            routes.add(new Route(start, end));
        }

        Collections.sort(routes);
        
        int start = routes.get(0).end, end = routes.get(0).start;
        long answer = 0;

        for(Route route : routes.subList(1, routes.size())){
            int s = route.end, e = route.start;

            if(s <= end){
                end = Math.max(end, e);
            }else{
                answer += 2 * (end - start);
                start = s;
                end = e;
            }
        }

        answer += 2 * (end - start);
        System.out.println(answer + m);
    }
}