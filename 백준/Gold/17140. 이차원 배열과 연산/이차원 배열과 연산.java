import java.io.*;
import java.util.*;

class Main {

    private static List<List<Integer>> board;
    private static int r, c, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        board = new ArrayList<>();

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        r = Integer.parseInt(tokenizer.nextToken()) - 1;
        c = Integer.parseInt(tokenizer.nextToken()) - 1;
        k = Integer.parseInt(tokenizer.nextToken());

        for(int i=1 ; i<=3 ; i++){
            List<Integer> row = new ArrayList<>();
            tokenizer = new StringTokenizer(br.readLine());

            for(int j=1 ; j<=3 ; j++){
                row.add(Integer.parseInt(tokenizer.nextToken()));
            }

            board.add(row);
        }

        int time = 0;
        while(board.size() <= r || board.get(0).size() <= c || board.get(r).get(c) != k){
            time++;

            if(time > 100){
                time = -1;
                break;
            }

            int maxSize = 0;

            if(board.size() >= board.get(0).size()){
                List<List<Integer>> temp = new ArrayList<>();

                for(int i=0 ; i<board.size() ; i++){
                    List<Integer> ret = sortRow(i);
                    maxSize = Math.max(maxSize, ret.size());
                    temp.add(ret);
                }

                for(int i=0 ; i<temp.size() ; i++){
                    fillByZero(temp, i, maxSize);
                }

                board = temp;
            }

            else{
                List<List<Integer>> temp = new ArrayList<>();

                for(int i=0 ; i<board.get(0).size() ; i++){
                    List<Integer> ret = sortCol(i);
                    maxSize = Math.max(maxSize, ret.size());
                    temp.add(ret);
                }

                
                for(int i=0 ; i<temp.size() ; i++){
                    fillByZero(temp, i, maxSize);
                };

                temp = rotate(temp);

                board = temp;
            }



        }

        bw.write(String.valueOf(time));
        bw.close();
        br.close();
    }

    private static List<Integer> sortRow(int y){
        List<Integer> ret = new ArrayList<>();
        int[] count = new int[101];

        for(int i=0 ; i<board.get(y).size() ;i++){
            count[board.get(y).get(i)]++;
        }

        List<int[]> temp = new ArrayList<>();
        for(int i=1 ; i<=100 ; i++){
            if(count[i] == 0) continue;

            temp.add(new int[]{i, count[i]});
        }

        Collections.sort(temp, (o1, o2) -> {
            if(o1[1] != o2[1])return o1[1] - o2[1];
            return o1[0] - o2[0];
        });

        for(int[] t : temp){
            ret.add(t[0]);
            if(ret.size() > 100)break;
            ret.add(t[1]);
            if(ret.size() > 100)break;
        }

        return ret;
    }
    
    private static void fillByZero(List<List<Integer>> temp, int y, int maxSize){
        int remainSize = maxSize - temp.get(y).size();

        for(int i=0 ; i<remainSize ; i++){
            if(temp.get(y).size() >= 100)break;
            temp.get(y).add(0);
        }
    }

    private static List<Integer> sortCol(int x){
        List<Integer> ret = new ArrayList<>();
        
        int[] count = new int[101];

        
        for(int i=0 ; i<board.size() ; i++){
            count[board.get(i).get(x)]++;
        }

        List<int[]> temp = new ArrayList<>();
        for(int i=1 ; i<=100 ; i++){
            if(count[i] == 0)continue;

            temp.add(new int[]{i, count[i]});
        }

        Collections.sort(temp, (o1, o2) -> {
            if(o1[1] != o2[1])return o1[1] - o2[1];
            return o1[0] - o2[0];
        });

        for(int[] t : temp){
            ret.add(t[0]);
            if(ret.size() > 100)break;
            ret.add(t[1]);
            if(ret.size() > 100)break;
        }

        return ret;
    }

    private static List<List<Integer>> rotate(List<List<Integer>> temp){
        List<List<Integer>> ret = new ArrayList<>();

        int size = temp.get(0).size();

        for(int i=0 ; i<size; i++){
            ret.add(new ArrayList<>());
        }

        for(int y = 0 ; y < temp.size() ; y++){
            for(int i=0 ; i<size; i++){
                ret.get(i).add(temp.get(y).get(i));
            }
        }   

        return ret;
    }

}