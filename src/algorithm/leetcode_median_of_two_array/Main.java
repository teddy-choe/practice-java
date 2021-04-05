package algorithm.leetcode_median_of_two_array;

public class Main {
    public static void main(String[] args) {
        int[] nums1 = {0,0,0,0,0};
        int[] nums2 = {-1,0,0,0,0,0,1};

        double answer = findMedianSortedArrays(nums1, nums2);

        System.out.println(answer);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double answer = 0;

        int[] mergedArr = new int[nums1.length + nums2.length];

        int leftIndex = 0;
        int rightIndex = 0;

        for (int i=0; i<nums1.length+nums2.length; i++) {
            if (leftIndex == nums1.length) {
                while (rightIndex < nums2.length) {
                    mergedArr[i++] = nums2[rightIndex];
                    rightIndex++;
                }
                break;
            }

            if (rightIndex == nums2.length) {
                while (leftIndex < nums1.length) {
                    mergedArr[i++] = nums1[leftIndex];
                    leftIndex++;
                }
                break;
            }

            int currentLeft = nums1[leftIndex];
            int currentRight = nums2[rightIndex];

            if (currentLeft >= currentRight) {
                mergedArr[i] = currentRight;
                rightIndex++;
            }

            if (currentLeft <= currentRight) {
                mergedArr[i] = currentLeft;
                leftIndex++;
            }
        }

        int median = mergedArr.length / 2;

        if (mergedArr.length%2 == 0) {
            answer = ((double)mergedArr[median-1] + (double)mergedArr[median]) / 2;
        } else {
            answer = mergedArr[median];
        }

        return answer;
    }
}
