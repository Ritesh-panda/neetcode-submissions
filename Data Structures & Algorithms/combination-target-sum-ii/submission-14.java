class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        // Similar to Combination Sum 1, but here we cannot reuse
        // the same candidate index more than once.

        // We sort the array so that we can skip duplicates
        // and stop exploring when a candidate exceeds the target.
        Arrays.sort(candidates);

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> combo = new ArrayList<>();

        backtrack(list, combo, candidates, target, 0);

        return list;
    }

    private void backtrack(
        List<List<Integer>> list,
        List<Integer> combo,
        int[] candidates,
        int target,
        int idx
    ) {

        // If the remaining target becomes negative,
        // this combination has exceeded the goal.
        // So we stop exploring this path.
        if (target < 0) {
            return;
        }

        // If the remaining target becomes 0,
        // we have found a valid combination.
        // We store a copy because combo will keep changing
        // as recursion continues and backtracking happens.
        if (target == 0) {
            list.add(new ArrayList<>(combo));
            return;
        }

        // We only need to explore further when target is positive.
        if (target > 0) {

            // Try every candidate from idx onward.
            // The loop itself moves to the next candidate
            // after the current recursive path is explored.
            for (int i = idx; i < candidates.length; i++) {

                // If the same value was already considered
                // at this recursion level, skip it.
                // This prevents duplicate combinations.
                if (i > idx && candidates[i] == candidates[i - 1]) {
                    continue;
                }

                // Since the array is sorted, if this candidate
                // is greater than the remaining target,
                // all later candidates will also be too large.
                // So we stop this loop.
                if (candidates[i] > target) {
                    break;
                }

                // Choose the current candidate and add it to combo.
                combo.add(candidates[i]);

                // Reduce the remaining target by the chosen value.
                // We pass i + 1 because each candidate index
                // can be used only once in Combination Sum 2.
                backtrack(
                    list, combo, candidates,
                    target - candidates[i], i + 1
                );

                // The recursive call has finished exploring
                // this choice and its possible combinations.
                // Remove the last element to restore combo
                // before the loop tries the next candidate.
                combo.remove(combo.size() - 1);
            }
        }
    }
}