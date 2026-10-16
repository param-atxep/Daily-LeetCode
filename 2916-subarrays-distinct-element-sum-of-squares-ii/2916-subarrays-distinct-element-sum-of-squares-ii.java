import java.util.*;

class LazySegmentTree {
    int n, mod;
    long[] lazy, sum, sq;

    LazySegmentTree(int n, int mod) {
        this.n = n;
        this.mod = mod;
        lazy = new long[4 * n];
        sum = new long[4 * n];
        sq = new long[4 * n];
    }

    void push(int i, int l, int r) {
        long x = lazy[i], len = r - l + 1;
        sq[i] = (sq[i] + 2 * x * sum[i] + x * x * len) % mod;
        sum[i] = (sum[i] + x * len) % mod;

        if (l < r) {
            lazy[2 * i + 1] += x;
            lazy[2 * i + 2] += x;
        }
        lazy[i] = 0;
    }

    void update(int i, int s, int e, int l, int r) {
        if (lazy[i] > 0) push(i, s, e);
        if (e < l || s > r) return;

        if (l <= s && e <= r) {
            lazy[i] = 1;
            push(i, s, e);
            return;
        }

        int m = (s + e) / 2;
        update(2 * i + 1, s, m, l, r);
        update(2 * i + 2, m + 1, e, l, r);

        sum[i] = (sum[2 * i + 1] + sum[2 * i + 2]) % mod;
        sq[i] = (sq[2 * i + 1] + sq[2 * i + 2]) % mod;
    }

    void updateRange(int l, int r) {
        update(0, 0, n - 1, l, r);
    }

    int getTreeSquaredSums() {
        return (int) sq[0];
    }
}

class Solution {
    public int sumCounts(int[] nums) {
        int mod = 1_000_000_007, ans = 0, n = nums.length;
        Map<Integer, Integer> last = new HashMap<>();
        LazySegmentTree tree = new LazySegmentTree(n, mod);

        for (int r = 0; r < n; r++) {
            int l = last.getOrDefault(nums[r], -1) + 1;
            tree.updateRange(l, r);
            last.put(nums[r], r);
            ans = (int) ((ans + (long) tree.getTreeSquaredSums()) % mod);
        }

        return ans;
    }
}