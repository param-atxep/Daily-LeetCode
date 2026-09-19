class Solution {
    public int missingNumber(int[] nums) {
        // Better Approch
       int ans = 0;
       int sum = 0;
       for(int i = 0 ; i <nums.length ;i++){
            sum += nums[i];
            ans += i ;
       }
       return ((ans+nums.length)-sum);
        }
}