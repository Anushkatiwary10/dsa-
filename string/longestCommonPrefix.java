class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix=strs[0];
        for(int i=0;i<prefix.length();i++){
            char c=prefix.charAt(i);
            for(int j=1;j<strs.length;j++){
                if(strs[j].length()==i){
                    return prefix.substring(0,i);
                }
                if(strs[j].charAt(i)!=c){
                    return prefix.substring(0,i);
                }
            }
        }
        return prefix;
    }
}
//Compare multiple strings character-by-character rather than comparing whole strings.