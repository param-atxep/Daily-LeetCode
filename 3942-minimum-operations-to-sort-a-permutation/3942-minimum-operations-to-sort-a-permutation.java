import java.util.function.IntPredicate;

class Solution {
    public int minOperations(int[] nums) {
        int length = nums.length;
        int zeroIndex = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                zeroIndex = i;
                break;
            }
        }
        final int anchorIndex = zeroIndex;
        IntPredicate isNonDecreasing = step -> {
            for (int i = 1; i < length; i++) {
                int prevIndex = (anchorIndex + (i - 1) * step + length) % length;
                int currIndex = (anchorIndex + i * step + length) % length;

                if (nums[prevIndex] > nums[currIndex]) {
                    return false;
                }
            }

            return true;
        };

        int answer = Integer.MAX_VALUE;
        if (isNonDecreasing.test(1)) {
            answer = Math.min(answer, zeroIndex);
            answer = Math.min(answer, length - zeroIndex + 2);
        }
        if (isNonDecreasing.test(-1)) {
            answer = Math.min(answer, zeroIndex + 2);
            answer = Math.min(answer, length - zeroIndex);
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}
