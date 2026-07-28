class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        find(candidates, target, 0, new ArrayList<>());
        return result;
    }

    public void find(int[] candidates, int target, int index, List<Integer> list) {

        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {

            list.add(candidates[i]);

            find(candidates, target - candidates[i], i, list);

            list.remove(list.size() - 1);
        }
    }
}
