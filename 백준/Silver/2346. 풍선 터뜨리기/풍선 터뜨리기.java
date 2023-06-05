import java.util.ArrayDeque;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main{
    private static int n;
    private static ArrayDeque<int[]> que;

    public static void main(String[] args) throws IOException{
        ioOperation();
        solution();
    }

    private static void ioOperation() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        que = new ArrayDeque<>();
        String[] str = br.readLine().split(" ");
        for(int i=1 ; i<=n ; i++){
            que.add(new int[]{Integer.parseInt(str[i-1]), i});
        }
        br.close();
    }

    private static void solution(){
        List<Integer> list = new ArrayList<>();
        while(!que.isEmpty()){
            int[] arr = que.poll();
            int value = arr[0];
            list.add(arr[1]);
            int len = value > 0 ? value : Math.abs(value) + 1;
            for(int i=1 ; i<len ; i++){
                int[] temp;
                if(que.isEmpty())break;
                if(value > 0){
                    temp = que.pollFirst();
                    que.addLast(temp);
                }else{
                    temp = que.pollLast();
                    que.addFirst(temp);
                }
            }
        }

        for(int v : list){
            System.out.print(v + " ");
        }
    }
}