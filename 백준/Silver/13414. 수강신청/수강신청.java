import java.io.*;
import java.util.*;

class Main {
    static class Student implements Comparable<Student>{
        String id;
        int order;

        public Student(String id, int order){
            this.id = id;
            this.order = order;
        }

        @Override
        public int compareTo(Student o){
            return this.order - o.order;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] split = br.readLine().split(" ");

        int m = Integer.parseInt(split[0]);
        int n = Integer.parseInt(split[1]);

        Map<String, Integer> order = new HashMap<>();

        for(int i=0 ; i<n ; i++){
            String studentId = br.readLine();

            order.put(studentId, i + 1);
        }

        PriorityQueue<Student> pq = new PriorityQueue<>();
        for(String id : order.keySet()){
            pq.add(new Student(id, order.get(id)));
        }

        StringBuilder answer = new StringBuilder();
        while(!pq.isEmpty() && m-- > 0){
            answer.append(pq.poll().id).append("\n");
        }

        bw.write(answer.toString());

        bw.flush();
        bw.close();

        br.close();
    }
}