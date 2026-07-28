class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        backtrack(0, candidates, target, list, ans);

        return ans;
    }

    private void backtrack(int idx, int[] candidates, int target,
                           List<Integer> list, List<List<Integer>> ans) {

        // Found a valid combination
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        // Target exceeded
        if (target < 0) {
            return;
        }

        // Try every candidate starting from idx
        for (int i = idx; i < candidates.length; i++) {

            // Choose
            list.add(candidates[i]);

            // Explore
            // i is passed because the same number can be reused
            backtrack(i, candidates, target - candidates[i], list, ans);

            // Undo (Backtrack)
            list.remove(list.size() - 1);
        }
    }
}