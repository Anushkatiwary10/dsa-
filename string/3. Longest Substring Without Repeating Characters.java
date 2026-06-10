class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int low=0,max=0;
        for(int high=0;high<s.length();high++){
            char ch=s.charAt(high);
            map.put(ch,map.getOrDefault(ch,0)+1);
            int k=high-low+1;
            while(map.size()<k){
                char lowchar=s.charAt(low);
                map.put(lowchar,map.get(lowchar)-1);
                if(map.get(lowchar)==0){
                    map.remove(lowchar);
                }
                low++;
                k=high-low+1;
            }
            max=Math.max(max,high-low+1);
        }
        return max;
        
    }
}
//