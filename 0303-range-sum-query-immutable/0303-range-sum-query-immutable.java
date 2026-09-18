class NumArray {
    private int[] prefixSum;
    public NumArray(int[] nums) {
        int length = nums.length;
        prefixSum = new int[length + 1];
              for (int i = 0; i < length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
    }
    public int sumRange(int left, int right) {
        return prefixSum[right + 1] - prefixSum[left];
    }
}
