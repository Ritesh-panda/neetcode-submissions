class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        Arrays.sort(candidates);
        sum(candidates,0,target,ans,list);
        return ans;
    }
    private void sum(int[] candidates,int idx,int target,List<List<Integer>> ans, List<Integer> list){
        if(target==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(target<0){
            return;
        }
        for(int i=idx;i<candidates.length;i++){
            if(i > idx && candidates[i] == candidates[i - 1])
            continue;
            list.add(candidates[i]);
            sum(candidates,i+1,target-candidates[i],ans,list);
            list.remove(list.size()-1);
        }
    }
}
