class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        if(nums.length==0){
            ans.add(list);
            return ans;
        }
        if(nums.length==1){
            list.add(nums[0]);
            ans.add(list);
            return ans;
        }
        backtrack(nums,ans,list,used);
        return ans;
    }
    private void backtrack(int[] nums,List<List<Integer>> ans,List<Integer> list,boolean[] used){
        if(list.size()==nums.length){
            ans.add(new ArrayList<>(list));
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;

            list.add(nums[i]);
            used[i]=true;
            backtrack(nums,ans,list,used);
            list.remove(list.size()-1);
            used[i]=false;
        }
    }
}
