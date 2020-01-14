package leetcode;

public class code001 {

        public int[] twoSum(int[] nums, int target) {
            int i,j;
            int a[] = new int[2];
            for(i=0;i<=nums.length-1;i++){
                for(j=0;j<=nums.length;j++){
                    if(i+j==target){
                        a[0] = i;
                        a[1] = j;
                        return a;
                    }
                }
            }
            return a;
        }


}
