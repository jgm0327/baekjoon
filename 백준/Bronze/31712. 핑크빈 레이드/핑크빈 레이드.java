import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{

    static class Player{
        int time, attack;

        public Player(int time, int attack){
            this.attack = attack;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Player[] players = new Player[3];

        for(int i=0 ; i<3 ; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            players[i] = new Player(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()));
        }

        int hp = Integer.parseInt(br.readLine());

        System.out.println(solution(players, hp));
    }

    private static int solution(Player[] players, int hp){
        int time = -1;

        while(hp > 0){
            time++;
            for(Player player : players){
                if(time % player.time != 0)
                    continue;
                hp -= player.attack;
            }
        }

        return time;
    }

}