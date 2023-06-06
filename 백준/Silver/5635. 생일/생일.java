import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main{
    private static int n;
    private static class Person implements Comparable<Person>{
        String name;
        int year, month, day;

        public Person(String name, String year, String month, String day){
            this.name = name;
            this.year = Integer.parseInt(year);
            this.month = Integer.parseInt(month);
            this.day = Integer.parseInt(day);
        }

        @Override
        public int compareTo(Person o){
            if(this.year > o.year)return -1;
            else if(this.year < o.year)return 1;
            if(this.month > o.month)return -1;
            else if(this.month < o.month)return 1;
            if(this.day > o.day)return -1;
            else if(this.day < o.day)return 1;
            return 0;
        }
    }
    private static List<Person> list;

    public static void main(String[] args) throws IOException{
        ioOperation();
        solution();
    }

    private static void ioOperation() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        for(int i=0 ; i<n ; i++){
            String[] values = br.readLine().split(" ");
            list.add(new Person(values[0], values[3], values[2], values[1]));            
        }
        br.close(); 
    }

    private static void solution(){
        Collections.sort(list);
        System.out.println(list.get(0).name + "\n" + list.get(n - 1).name);
    }
}