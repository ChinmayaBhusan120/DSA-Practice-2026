Problem Statement

You are given an array fruits.
You have 2 baskets, and each basket can hold only one type of fruit.
You must pick fruits from a contiguous subarray.
Return the maximum number of fruits you can collect.
Example
Input:  [1,2,1]
Output: 3
Input:  [0,1,2,2]
Output: 3


We maintain:
left
right
HashMap to count fruit frequencies
Condition:
while (map.size() > 2)
    shrink window
Track max window size.


CODE---->>>>


import java.util.HashMap;

class FruitIntoBaskets {

    public static int totalFruit(int[] fruits) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < fruits.length; right++) {

            map.put(fruits[right], 
                    map.getOrDefault(fruits[right], 0) + 1);

            while (map.size() > 2) {

                map.put(fruits[left], 
                        map.get(fruits[left]) - 1);

                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }

                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {

        int[] fruits = {0,1,2,2};
        System.out.println("Result: " + totalFruit(fruits));
    }
}
