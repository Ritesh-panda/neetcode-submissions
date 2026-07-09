class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left=1;
        int right=Arrays.stream(piles).max().getAsInt();
        int ans=right;//as of now the best one is this maxpile
        while(left<=right){
            int mid=(left+right)/2;
            long totalHours=0;
            for(int i=0;i<piles.length;i++){
                totalHours+=(piles[i]+mid-1)/mid; //instead of(ceil)i/mid which is i/hour(also mid in this case) for rate 
            }
            if(totalHours<=h){//here = is for within
                ans=mid;
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return ans;
    }
}
