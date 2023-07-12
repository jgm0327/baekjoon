import java.util.*;
import java.text.SimpleDateFormat;

class Solution {
    
    private final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    private class Car{
        String number;
        String time;
        public Car(String number, String time){
            this.number = number;
            this.time = time;
        }
        
        public int timeDiff(String comp) throws Exception{
            Date sour = sdf.parse(time);
            Date des = sdf.parse(comp);
            return (int)((des.getTime() - sour.getTime()) / 60000);
        }
    }
    
    public int[] solution(int[] fees, String[] records) throws Exception{
        ArrayList<Integer> answer = new ArrayList<>();
        int basicTime = fees[0], basicRate = fees[1], perMinute = fees[2], perRate = fees[3];
        
        TreeMap<String, Integer> carFees = new TreeMap<>();
        HashMap<String, Car> cars = new HashMap<>();
        
        for(int i=0 ; i<records.length ; i++){
            String[] str = records[i].split(" ");
            String time = str[0], number = str[1], inOrOut = str[2];
            
            if("IN".equals(inOrOut)){
                cars.put(number, new Car(number, time));
            }else{
                int diff = cars.get(number).timeDiff(time);
                cars.remove(number);
                if(carFees.containsKey(number)){
                    diff += carFees.get(number);
                }
                carFees.put(number, diff);
            }
        }
        
        for(String key : cars.keySet()){
            int time = cars.get(key).timeDiff("23:59");
            if(carFees.containsKey(key)){
                time += carFees.get(key);
            }
            carFees.put(key, time);
        }
        
        for(Integer value : carFees.values()){
            int diff = value-basicTime;
            int cost = basicRate;
            if(diff > 0)
                cost += (int)Math.ceil((double)diff / perMinute) * perRate;
            answer.add(cost);
        }
        
        return answer.stream().mapToInt(v->v).toArray();
    }
}