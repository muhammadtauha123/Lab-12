package recursion_lab12;
import java.util.ArrayList;
import java.util.List;

/**
 * A utility class for performing recursive binary search on arrays.
 * Supports searching in both integer and string arrays with multiple search variants.
 */
public class RecursiveBinarySearch {
    
    /**
     * Performs a recursive binary search on an integer array to find a target value.
     * 
     * @param arr    The sorted input array of integers
     * @param target The value to search for
     * @return The index of the target if found, -1 otherwise
     * @throws IllegalArgumentException if the input array is null
     */
    public static int binarySearchRecursive(int[] arr, int target) {
        // Error handling for null or empty array
        if (arr == null) {
            throw new IllegalArgumentException("Input array cannot be null");
        }
        
        return binarySearchRecursive(arr, target, 0, arr.length - 1);
    }
    
    /**
     * Internal recursive helper method for integer array binary search.
     * 
     * @param arr    The sorted input array of integers
     * @param target The value to search for
     * @param left   The left boundary of the current search range
     * @param right  The right boundary of the current search range
     * @return The index of the target if found, -1 otherwise
     */
    private static int binarySearchRecursive(int[] arr, int target, int left, int right) {
        // Base case: search range is invalid
        if (left > right) {
            return -1;
        }
        
        // Calculate middle index
        int mid = left + (right - left) / 2;
        
        // Base case: target found
        if (arr[mid] == target) {
            return mid;
        }
        
        // Recursive cases: search left or right half
        if (target < arr[mid]) {
            return binarySearchRecursive(arr, target, left, mid - 1);
        } else {
            return binarySearchRecursive(arr, target, mid + 1, right);
        }
    }
    
    /**
     * Performs a recursive binary search on a string array to find a target value.
     * 
     * @param arr    The sorted input array of strings
     * @param target The value to search for
     * @return The index of the target if found, -1 otherwise
     * @throws IllegalArgumentException if the input array is null
     */
    public static int binarySearchRecursive(String[] arr, String target) {
        // Error handling for null or empty array
        if (arr == null) {
            throw new IllegalArgumentException("Input array cannot be null");
        }
        
        return binarySearchRecursive(arr, target, 0, arr.length - 1);
    }
    
    /**
     * Internal recursive helper method for string array binary search.
     * 
     * @param arr    The sorted input array of strings
     * @param target The value to search for
     * @param left   The left boundary of the current search range
     * @param right  The right boundary of the current search range
     * @return The index of the target if found, -1 otherwise
     */
    private static int binarySearchRecursive(String[] arr, String target, int left, int right) {
        // Base case: search range is invalid
        if (left > right) {
            return -1;
        }
        
        // Calculate middle index
        int mid = left + (right - left) / 2;
        
        // Base case: target found
        if (arr[mid].equals(target)) {
            return mid;
        }
        
        // Recursive cases: search left or right half
        if (target.compareTo(arr[mid]) < 0) {
            return binarySearchRecursive(arr, target, left, mid - 1);
        } else {
            return binarySearchRecursive(arr, target, mid + 1, right);
        }
    }
    
    /**
     * Finds all indices of a target value in a sorted integer array.
     * 
     * @param arr    The sorted input array of integers
     * @param target The value to search for
     * @return A list of all indices where the target is found
     * @throws IllegalArgumentException if the input array is null
     */
    public static List<Integer> binarySearchMultipleIndices(int[] arr, int target) {
        // Error handling for null array
        if (arr == null) {
            throw new IllegalArgumentException("Input array cannot be null");
        }
        
        List<Integer> indices = new ArrayList<>();
        findAllIndices(arr, target, 0, arr.length - 1, indices);
        return indices;
    }
    
    /**
     * Internal recursive helper method to find all indices of a target.
     * 
     * @param arr     The sorted input array of integers
     * @param target  The value to search for
     * @param left    The left boundary of the current search range
     * @param right   The right boundary of the current search range
     * @param indices List to store found indices
     */
    private static void findAllIndices(int[] arr, int target, int left, int right, List<Integer> indices) {
        // Base case: search range is invalid
        if (left > right) {
            return;
        }
        
        // Calculate middle index
        int mid = left + (right - left) / 2;
        
        // If target found, add to indices and search both sides
        if (arr[mid] == target) {
            indices.add(mid);
            
            // Search left side for additional occurrences
            findAllIndices(arr, target, left, mid - 1, indices);
            
            // Search right side for additional occurrences
            findAllIndices(arr, target, mid + 1, right, indices);
        }
        // Recursive cases: search left or right half
        else if (target < arr[mid]) {
            findAllIndices(arr, target, left, mid - 1, indices);
        } else {
            findAllIndices(arr, target, mid + 1, right, indices);
        }
    }
}