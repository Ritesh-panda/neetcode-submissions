class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>list=new ArrayList<>();
        List<Integer> combo=new ArrayList<>();
        int n=candidates.length;
        backtrack(candidates,list,combo,n,0,target);
        return list;
    }
    private void backtrack(
        int[] candidates,
        List<List<Integer>>list,
        List<Integer> combo,
        int n,int idx,int target)
        {
            if(target==0){
                list.add(new ArrayList<>(combo));
                return;
            }
            if(target<0){
                return;
            }
            if(target>0){
                for(int i=idx;i<candidates.length;i++){
                    combo.add(candidates[i]);
                    backtrack(candidates,list,combo,n,i,target-candidates[i]);// why here not idx+1 as we will add that same thing again
                    combo.remove(combo.size()-1);
                    /*
                    backtrack(candidates,list,combo,n,idx+1,target-candidates[i]);this line is not required. as we are doing a for loop.
                    how? the for loop is itself going from first index to the last index when we go beyond the goal like target<0
                    we return and remove that thing and goes one example 2+2+2+2+2==8 and target is 7
                    we do return and then the combo will have 2,2,2 which is 6 but this combo isnt added in the list.
                    so after that i=3 now combo will have 3 and the target is 1 now and we will finish the loop as 3, 6,7 all are greater and will give the result negative.
                    so now we will remove one more 2
                    now it will have 2,2 only which is 4 and target is 6 then it will get to the i==3 where we will get the sum==7 and we will add the copy in the list
                    and life goes on and on and on and on.
                    */
                }

            }
        }
}