class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        long deliveryTotal = 0, pickupTotal = 0;
        
        for(int i=0 ; i<n ; i++){
            deliveryTotal += deliveries[i];
            pickupTotal += pickups[i];
        }
        
        int deliveryStart = n - 1, pickupStart = n - 1;
        
        while(deliveryTotal > 0 || pickupTotal > 0){
            while(deliveries[deliveryStart] == 0 && deliveryStart > 0)
                deliveryStart--;
            
            int curCap = cap;
            for(int i = deliveryStart ; i >= 0 ; i--){
                if(deliveries[i] > curCap){
                    deliveries[i] -= curCap;
                    deliveryTotal -= curCap;
                    break;
                }
                
                curCap -= deliveries[i];
                deliveryTotal -= deliveries[i];
                deliveries[i] = 0;
            }
            
            while(pickups[pickupStart] == 0 && pickupStart > 0)
                pickupStart--;
            
            curCap = cap;
            for(int i = pickupStart ; i >= 0 ; i--){
                if(pickups[i] > curCap){
                    pickups[i] -= curCap;
                    pickupTotal -= curCap;
                    break;
                }
                
                curCap -= pickups[i];
                pickupTotal -= pickups[i];
                pickups[i] = 0;
            }
            
            answer += Math.max(deliveryStart + 1, pickupStart + 1) * 2;
        }
        
        return answer;
    }
}