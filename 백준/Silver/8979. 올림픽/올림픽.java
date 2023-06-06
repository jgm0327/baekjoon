import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main{
    private static int n, k;
    private static class Country implements Comparable<Country>{
        int num, gold, silver, bronze;
        
        public Country(String num, String gold, String silver, String bronze){
            this.num = Integer.parseInt(num);
            this.gold = Integer.parseInt(gold);
            this.silver = Integer.parseInt(silver);
            this.bronze = Integer.parseInt(bronze);
        }

        @Override
        public int compareTo(Country o){
            if(o.gold > this.gold)return 1;
            else if(o.gold < this.gold)return -1;
            if(o.silver > this.silver)return 1;
            else if(o.silver < this.silver)return -1;
            if(o.bronze > this.bronze)return 1;
            return -1;
        }
    }
    private static List<Country> countries;

    public static void main(String[] args) throws IOException{
        ioOperation();
        solution();
    }

    private static void ioOperation() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");

        countries = new ArrayList<>();
        n = Integer.parseInt(size[0]);
        k = Integer.parseInt(size[1]);

        for(int i=0 ; i<n ; i++){
            String[] values = br.readLine().split(" ");
            countries.add(new Country(values[0], values[1], values[2], values[3]));
        }
        br.close(); 
    }

    private static void solution(){
        Collections.sort(countries);
        int rank = 1;
        Country first = countries.get(0);
        int gold = first.gold, silver = first.silver, bronze = first.bronze;

        for(int i=0 ; i<n ; i++){
            if(!(gold == countries.get(i).gold && silver == countries.get(i).silver && bronze == countries.get(i).bronze)){
                rank = i + 1;
            }

            if(k == countries.get(i).num){
                System.out.println(rank);
                break;
            }

            gold = countries.get(i).gold;
            silver = countries.get(i).silver;
            bronze = countries.get(i).bronze;
        }
    }
}