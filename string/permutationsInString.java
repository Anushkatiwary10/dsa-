class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //need a sliding window of s1.length()
        int left=0;
        int[] target=new int[26];
        int[] window=new int[26];
        for(int i=0;i<s1.length();i++){
            char c=s1.charAt(i);
            target[c-'a']++;
        }
        for(int right=0;right<s2.length();right++){
            window[s2.charAt(right)-'a']++;
            if((right-left+1)>s1.length()){
                window[s2.charAt(left)-'a']--;
                left++;
            }
            if (right - left + 1 == s1.length()) {
                if (Arrays.equals(target, window)) {
                    return true;
                }
            }
        }
        return false;
    }
}
//Whenever you see:

// Find a substring of length k
// Check if it contains the same characters/frequencies

// think:

// Fixed-size Sliding Window + Frequency Array

// That's one of the most common medium-level string patterns.