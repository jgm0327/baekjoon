import java.io.*;
import java.util.*;

class Main {

    private static int n, m, remainFuel;
    private static int[] dy = {0,0,1,-1}, dx = {1,-1,0,0};
    private static int[][] board;
    private static boolean[] arrived;
    private static List<int[]> passengers;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        remainFuel = Integer.parseInt(tokenizer.nextToken());

        board = new int[n + 1][n + 1];

        for(int i=1 ; i<=n ; i++){
            tokenizer = new StringTokenizer(br.readLine());

            for(int j=1 ; j<=n ; j++){
                board[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        tokenizer = new StringTokenizer(br.readLine());

        int taxiY = Integer.parseInt(tokenizer.nextToken());
        int taxiX = Integer.parseInt(tokenizer.nextToken());

        passengers = new ArrayList<>();
        for(int i=0 ; i<m ; i++){
            tokenizer = new StringTokenizer(br.readLine());

            int startY = Integer.parseInt(tokenizer.nextToken());
            int startX = Integer.parseInt(tokenizer.nextToken());
            int endY = Integer.parseInt(tokenizer.nextToken());
            int endX = Integer.parseInt(tokenizer.nextToken());

            passengers.add(new int[]{startY, startX, endY, endX});
        }

        int size = passengers.size();
        arrived = new boolean[size];

        while(size != 0){
            
            int taxiPos = findPassengerNearBy(taxiY, taxiX);
            if(remainFuel < 0)break;
            
            int[] passenger = passengers.get(taxiPos);
            int[] desPos = getDistance(passenger[0], passenger[1], passenger[2], passenger[3], true);

            // System.out.println(remainFuel);
            if(remainFuel < 0)
                break;

            // System.out.println(taxiY + " " + taxiX);
            taxiY = desPos[0];
            taxiX = desPos[1];
            
            size--;
        }

        bw.write(String.valueOf(remainFuel));
        bw.close();
        br.close();
    }

    private static int findPassengerNearBy(int y, int x){
        int minDist = Integer.MAX_VALUE, idx = 0;
        int[] ret = new int[4];

        for(int i=0 ; i<passengers.size() ; i++){
            if(arrived[i])continue;

            int[] pos = getDistance(y, x, passengers.get(i)[0], passengers.get(i)[1], false);
            // System.out.println(pos[2]);

            if(minDist == pos[2]){
                if(pos[0] < ret[0]){
                    ret = new int[]{pos[0], pos[1], pos[2], i};
                    idx = i;
                }
                else if(pos[0] == ret[0] && pos[1] < ret[1]){
                    ret = new int[]{pos[0], pos[1], pos[2], i};
                    idx = i;
                }
            }

            else if(minDist > pos[2]){
                idx = i;
                minDist = pos[2];
                ret = new int[]{pos[0], pos[1], pos[2], i};
            }
        }

        remainFuel -= ret[2];

        if(remainFuel <= 0){
            remainFuel = -1;
            return -1;
        }

        arrived[idx] = true;
        // System.out.println("pa: " + remainFuel);

        return idx;
    }

    private static int[] getDistance(int startY, int startX, int endY, int endX, boolean isDestination){
        if(startY == endY && startX == endX){
            return new int[]{startY, startX, 0};
        }

        if(remainFuel == -1)
            return new int[]{-1, -1, -1};

        Queue<int[]> que = new ArrayDeque<>();
        boolean[][] visit = new boolean[n + 1][n + 1];

        que.add(new int[]{startY, startX, 0});
        visit[startY][startX] = true;

        while(!que.isEmpty()){
            int[] cur = que.poll();

            int y = cur[0], x = cur[1];
            for(int i=0 ; i<4 ; i++){
                int ny = y + dy[i], nx = x + dx[i];

                if(0 >= ny || ny > n || 0 >= nx || nx > n 
                || visit[ny][nx] || board[ny][nx] == 1)
                    continue;

                if(ny == endY && nx == endX){
                    if(isDestination){
                        // System.out.println("de: " + remainFuel + " " + (cur[2] + 1));
                        remainFuel -= (cur[2] + 1);

                        if(remainFuel < 0){
                            remainFuel = -1;
                            return new int[]{-1, -1, -1};
                        }
                        
                        remainFuel += (cur[2] + 1) * 2;

                        // System.out.println(remainFuel);
                    }

                    return new int[]{ny, nx, cur[2] + 1};
                }

                que.add(new int[]{ny, nx, cur[2] + 1});
                visit[ny][nx] = true;
            }
        }

        remainFuel = -1;
        return new int[]{-1, -1, -1};
    }
}