import java.io.*;
import java.util.*;

class Main {

    private static List<List<Integer>> cases;
    private static int[][] points;
    private static boolean[] visit;
    private static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new char[5][5];
        points = new int[25][2];

        int idx = 0;

        for(int i=0 ; i<5 ; i++){
            String input = br.readLine();
            for(int j=0 ; j<5 ; j++){
                board[i][j] = input.charAt(j);
                points[idx++] = new int[]{i, j};
            }
        }

        cases = new ArrayList<>();
        visit = new boolean[25];

        combination(0, 0, new ArrayDeque<>());

        int answer = 0;

        for(List<Integer> c : cases){
            if(isConnectedAndMoreThanFour(c)){
                answer++;
            }
        }

        System.out.println(answer);

        br.close();
    }

    private static void combination(int depth, int start, ArrayDeque<Integer> path){
        if(depth == 7){
            cases.add(new ArrayList<>(path));
            return;
        }

        for(int i=start ; i<25 ; i++){
            if(visit[i])continue;

            visit[i] = true;
            path.add(i);

            combination(depth + 1, i + 1, path);

            visit[i] =false;
            path.pollLast();
        }
    }

    private static boolean isConnectedAndMoreThanFour(List<Integer> team){
        int sCount = 0, connectedCount = 0;

        final int[] dy = {0,0,1,-1}, dx = {1,-1,0,0};
        boolean[][] visit = new boolean[5][5];

        Queue<int[]> que = new ArrayDeque<>();
        int start = team.get(0);
        que.add(points[start]);
        visit[points[start][0]][points[start][1]] = true;

        while(!que.isEmpty()){
            int[] cur = que.poll();

            int y = cur[0], x = cur[1];

            if(board[y][x] == 'S')sCount++;
            connectedCount++;

            for(int i = 0 ; i < 4 ; i++){
                int ny = y + dy[i], nx = x + dx[i];

                if(ny < 0 || ny >= 5 || nx < 0 || nx >= 5 
                || !exist(team, ny, nx) || visit[ny][nx])continue;

                que.add(new int[]{ny, nx});
                visit[ny][nx] = true;
            }
        }

        return connectedCount == 7 && sCount >= 4;
    }

    private static boolean exist(List<Integer> team, int y, int x){
        for(int t : team){
            if(points[t][0] == y && points[t][1] == x)
                return true;
        }

        return false;
    }

}