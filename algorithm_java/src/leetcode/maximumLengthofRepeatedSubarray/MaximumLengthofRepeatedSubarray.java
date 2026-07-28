package leetcode.maximumLengthofRepeatedSubarray;

public class MaximumLengthofRepeatedSubarray {
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int max = 0;

        for(int i=0;i<n;i++){
            int len = Math.min(m, n-i);
            max = Math.max(max, getMax(nums1,nums2,i,0,len));
        }
        for(int j=0;j<m;j++){
            int len = Math.min(n, m-j);
            max = Math.max(max, getMax(nums1,nums2,0,j,len));
        }
        return max;
    }
    public int getMax(int[]A,int[]B,int i,int j,int len){
        int max = 0;
        int count = 0;
        for(int k=0;k<len;k++){
            if(A[i+k]==B[j+k]){
                count++;
                max = Math.max(max,count);
            }else{
                count = 0;
            }
        }
        return max;
    }
}
