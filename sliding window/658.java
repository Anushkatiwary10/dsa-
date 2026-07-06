class Solution { // priority queue/heap solution
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
            int distA=Math.abs(a-x);
            int distB=Math.abs(b-x);
            if(distA==distB) return b-a;
            else return Math.abs(b-x)-Math.abs(a-x);
        });
        for(int num:arr){
            pq.add(num);
            if(pq.size()>k){
                pq.poll();
            }
        }
        List<Integer> res=new ArrayList<>();
        while(!pq.isEmpty()){
            res.add(pq.poll());
        }
        Collections.sort(res);
        return res;
    }
}

//binary search on window 
//optimal solution
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int n = arr.length;

        int left = 0;
        int right = n - k;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}

// LC 658 - Find K Closest Elements
// Pattern

// Binary Search on Window (Starting Index) ⭐⭐⭐⭐⭐

// Keywords
// sorted array
// k closest elements
// closest to x
// return k elements

// ➡️ Think Binary Search on the starting index of the window.

// Observation

// Since the array is sorted, the answer is always a contiguous subarray of size k.

// Example:

// arr = [1,2,3,4,5]
// k = 3

// Possible windows:

// [1 2 3]

// [2 3 4]

// [3 4 5]

// We don't choose random elements—we choose one window.

// Binary Search Space

// Search on the starting index of the window.

// low = 0

// high = n - k

// Each possible start represents one window.

// Core Idea

// Compare two adjacent windows.

// Current window:

// [L A B C]

// Next window:

// [A B C R]

// The common elements are:

// A B C

// Only two elements differ:

// L leaves

// R enters

// So the decision is:

// Should we keep L or replace it with R?

// Decision Rule

// Compare the distances:

// Left Element  = arr[mid]

// Right Element = arr[mid + k]

// If

// x - arr[mid] > arr[mid + k] - x

// then the entering element (R) is closer.

// ➡️ Move the window right.

// Otherwise,

// ➡️ Keep the current (left) window.