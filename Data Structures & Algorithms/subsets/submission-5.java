class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, list, ans, 0);
        return ans;
    }
    private void backtrack(int[] nums, List<Integer> list, List<List<Integer>> ans, int idx) {
        if (idx >= nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[idx]);
        backtrack(nums, list, ans, idx + 1);
        list.remove(list.size() - 1);
        backtrack(nums, list, ans, idx + 1);
    }
}
