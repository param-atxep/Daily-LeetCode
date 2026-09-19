class Solution {
    public int missingNumber(int[] nums) {
        // Brute Force Approch
        for(int i = 0 ; i <= nums.length ;i++){
            boolean flag = false;
            for(int j = 0 ; j < nums.length ;j++){
                if(i == nums[j]){
                    flag = true ;
                }
            }
            if(!flag){
                return i;
            }
        }
        return -1;
        }
}