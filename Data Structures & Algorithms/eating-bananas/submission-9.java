class Solution {
    public int minEatingSpeed(int[] piles, int h) {
       long sum=0;
        for(int i=0;i<piles.length;i++){
          sum+=(long)piles[i];
        }
        int rate=(int)Math.ceil((double)sum/h);
       
        while(true){
        long hours=0;
        for(int i=0;i<piles.length;i++){
            hours+=(long)Math.ceil((double)piles[i]/rate);
            

        }
        if(hours<=h){return rate;}
        
        rate++;
        }
    }
}
