Problem: Sort Colors (Dutch National Flag)
🔹 Sort Colors
Core Idea
We maintain three pointers:
low → next position for 0
mid → current element
high → next position for 2
Rules:
If nums[mid] == 0 → swap(low, mid), low++, mid++
If nums[mid] == 1 → mid++
If nums[mid] == 2 → swap(mid, high), high--

CODE:-
class SortColors {
    public static void sortColors(int[] nums) {

        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {

            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            }
            else if (nums[mid] == 1) {
                mid++;
            }
            else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {

        int[] nums = {2, 0, 2, 1, 1, 0};

        sortColors(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
