class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        backtrack(0,nums,ans,list);
        return ans;
    }
    private void backtrack(int idx,int[] nums,List<List<Integer>> ans,List<Integer> list){
        if(idx>=nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        
        list.add(nums[idx]);
        backtrack(idx+1,nums,ans,list);
        list.remove(list.size()-1);
        while (idx < nums.length - 1 && nums[idx] == nums[idx + 1])
        {
                  idx++;
        }
        backtrack(idx+1,nums,ans,list);

    }
}
