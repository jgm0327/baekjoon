import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int set = 0;
        StringBuilder sb = new StringBuilder();
        while(T-- > 0){
            String[] values = br.readLine().split(" ");
            if(values.length == 1){
                if(values[0].equals("all")){
                    set = 0;
                    for(int i=0 ; i<20 ; i++){
                        set |= (1 << i);
                    }
                }else if(values[0].equals("empty")){
                    set = 0;
                }
            }else{
                int num = Integer.parseInt(values[1]);
                if(values[0].equals("add")){
                    set |= (1 << (num - 1));
                }else if(values[0].equals("remove")){
                    set &= ~(1 << (num - 1));
                }else if(values[0].equals("check")){
                    sb.append(((1 << (num - 1)) | set) == set ? "1" : "0")
                     .append("\n");
                }else if(values[0].equals("toggle")){
                    if(((1 << (num - 1)) | set) == set){
                        set &= ~(1 << (num - 1));
                    }else{
                        set |= (1 << (num - 1));
                    }
                }
            }
        }
        System.out.println(sb);
        br.close();
    }
}