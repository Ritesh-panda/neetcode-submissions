class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>list=new ArrayList<>();
        List<Integer>combo=new ArrayList<>();
        int n=nums.length;
        backtrack(nums,n,0,list,combo);
        return list;
    }
    private void backtrack(int[] nums,int n, int idx,
    List<List<Integer>>list,List<Integer>combo){
        if(idx==n){
            list.add(new ArrayList<>(combo));//because original combo is being used there in the recursion we need to make a copy otherwise it will be keep removing and add things which are not desired
            return;
        }//inclusion of the idx
            combo.add(nums[idx]);
            backtrack(nums,n,idx+1,list,combo);
            combo.remove(combo.size()-1); 
            //exclusion of the idx
            backtrack(nums,n,idx+1,list,combo);
    }
}