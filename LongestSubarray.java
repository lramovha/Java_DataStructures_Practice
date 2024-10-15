import java.util.HashMap;
import java.util.List;

class LongestSubarray {

    /*
     * Complete the 'longestSubarray' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int longestSubarray(List<Integer> arr) {
        // HashMap to store the frequency of the numbers in the current window
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int maxLength = 0;
        int start = 0;  // Pointer for the start of the sliding window

        for (int end = 0; end < arr.size(); end++) {
            int number = arr.get(end);

            // Add the current number to the frequency map
            freqMap.put(number, freqMap.getOrDefault(number, 0) + 1);

            // Check if the window is invalid (more than 2 distinct values or difference > 1)
            while (freqMap.size() > 2 || (freqMap.size() == 2 && Math.abs((int) freqMap.keySet().toArray()[0] - (int) freqMap.keySet().toArray()[1]) > 1)) {
                int startNum = arr.get(start);
                freqMap.put(startNum, freqMap.get(startNum) - 1);

                // Remove the element from the map if its frequency becomes 0
                if (freqMap.get(startNum) == 0) {
                    freqMap.remove(startNum);
                }
                start++;  // Move the start pointer to shrink the window
            }

            // Update the maximum length of a valid subarray
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        List<Integer> arr1 = List.of(1, 2, 2, 3, 3, 4, 2, 1); // Expected: 4
        List<Integer> arr2 = List.of(5, 1, 2, 3, 4, 5); // Expected: 2
        List<Integer> arr3 = List.of(3, 2, 2, 1); // Expected: 3
    
        System.out.println(LongestSubarray.longestSubarray(arr1)); // Output: 4
        System.out.println(LongestSubarray.longestSubarray(arr2)); // Output: 2
        System.out.println(LongestSubarray.longestSubarray(arr3)); // Output: 3
    }
}

    


