class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> combo=new ArrayList<>();
        Arrays.sort(nums);
        backtrack(ans,combo,nums,0);
        return ans;
    }
    private void backtrack(List<List<Integer>> ans,List<Integer> combo,int[] nums,int idx){
        
        ans.add(new ArrayList<>(combo));
            
        

        for(int i=idx;i<nums.length;i++){
            if(i>idx && nums[i]==nums[i-1]) continue;
            combo.add(nums[i]);
            backtrack(ans,combo,nums,i+1);
            combo.remove(combo.size()-1);
            
        }
    }
}