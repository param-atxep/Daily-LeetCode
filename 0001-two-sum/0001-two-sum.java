class Solution {
    public int[] twoSum(int[] nums, int target) {
    HashMap<Integer , Integer> map = new HashMap();
    for(int i = 0 ; i < nums.length ;i++){
        int cal = target - nums[i];
        if(map.containsKey(cal)){
            return new int[]{i,map.get(cal)};
        }else{
            map.put(nums[i],i);
        }
    }
    return new int[]{};
    }
}