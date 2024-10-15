import java.util.HashMap;
import java.util.List;

public class SubarrayZeroSumCount {
    public static int countZeroSumSubarrays(List<Integer> arr) {
        HashMap<Integer, Integer> sumFrequencyMap = new HashMap<>();
        int count = 0;
        int sum = 0;

        // Initialize the map with sum 0 to handle cases where subarrays start from index 0
        sumFrequencyMap.put(0, 1); 

        for (int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);

            // If the sum has been seen before, increment the count by the number of times the sum was seen
            if (sumFrequencyMap.containsKey(sum)) {
                count += sumFrequencyMap.get(sum);
            }

            // Increment the frequency of the sum in the map
            sumFrequencyMap.put(sum, sumFrequencyMap.getOrDefault(sum, 0) + 1);
        }

        return count; // Return the count of subarrays with zero sum
    }

    public static void main(String[] args) {
        // Test case with no zero-sum subarray
        List<Integer> arr1 = List.of(3, 2, 2, 1);
        System.out.println("Count of subarrays with sum zero in arr1: " + countZeroSumSubarrays(arr1)); // Expected: 0

        // Test case with multiple zero-sum subarrays
        List<Integer> arr2 = List.of(1, -1, 3, 2, -2, -3);
        System.out.println("Count of subarrays with sum zero in arr2: " + countZeroSumSubarrays(arr2)); // Expected: 3

        // Another valid test case with multiple zero-sum subarrays
        List<Integer> arr3 = List.of(1, 2, -3, 3, -2);
        System.out.println("Count of subarrays with sum zero in arr3: " + countZeroSumSubarrays(arr3)); // Expected: 2

        // Test case with zero-sum subarray in the middle
        List<Integer> arr4 = List.of(5, 1, 2, 3, 4, 5);
        System.out.println("Count of subarrays with sum zero in arr4: " + countZeroSumSubarrays(arr4)); // Expected: 2
    }
}
