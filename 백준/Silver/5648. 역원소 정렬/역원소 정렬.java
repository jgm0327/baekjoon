import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = sc.nextInt();

        List<Long> list = new ArrayList<>();
        for(int i=0 ; i<n ; i++){
            list.add(Long.parseLong(new StringBuilder(sc.next()).reverse().toString()));
        }

        Collections.sort(list);

        StringBuilder answer = new StringBuilder();
        for(long number : list){
            answer.append(number).append("\n");
        }

        bw.write(answer.toString());
        bw.close();
    }
}