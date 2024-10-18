class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        long totalD = 0, totalP = 0;
        
        for(int i=0 ; i<n ; i++){
            totalD += deliveries[i];
            totalP += pickups[i];
        }
        
        int deliveryStart = n - 1, pickupStart = n - 1;
        
        while(totalD > 0 || totalP > 0){
            while(deliveryStart > 0 && deliveries[deliveryStart] == 0){
                deliveryStart--;
            }
            
            int curCap = cap;
            for(int i = deliveryStart ; i >= 0 ; i--){
                if(curCap >= deliveries[i]){
                    curCap -= deliveries[i];
                    totalD -= deliveries[i];
                    deliveries[i] = 0;
                }else{
                    deliveries[i] -= curCap;
                    totalD -= curCap;
                    break;
                }
            }
            
            while(pickupStart > 0 && pickups[pickupStart] == 0){
                pickupStart--;
            }
            
            curCap = cap;
            for(int i = pickupStart ; i >= 0 ; i--){
                if(curCap >= pickups[i]){
                    curCap -= pickups[i];
                    totalP -= pickups[i];
                    pickups[i] = 0;
                }else{
                    pickups[i] -= curCap;
                    totalP -= curCap;
                    break;
                }
            }
            
            int last = Math.max(pickupStart, deliveryStart);
            answer += (last + 1) * 2;
        }
        
        return answer;
    }
}