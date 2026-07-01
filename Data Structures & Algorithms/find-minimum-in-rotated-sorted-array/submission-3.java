class Solution {
    public int findMin(int[] nums) {
        if(nums.length==0) return -1;
        
            int min=Arrays.stream(nums).min().orElse(0);
        
        return min;

    }
}
