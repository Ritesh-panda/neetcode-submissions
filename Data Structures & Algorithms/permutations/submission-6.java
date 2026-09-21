class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> combo=new ArrayList<>();


        backtrack(ans,combo,nums,0);
        return ans;
    }
    private void backtrack(List<List<Integer>> ans,List<Integer> combo,int[] nums,int idx){
        if(combo.size()==nums.length){
            ans.add(new ArrayList<>(combo));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(combo.contains(nums[i])) continue;
            combo.add(nums[i]);
            backtrack(ans,combo,nums,i);
            combo.remove(combo.size()-1);
        }
    }
}