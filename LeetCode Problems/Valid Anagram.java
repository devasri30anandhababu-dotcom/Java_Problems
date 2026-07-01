class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
        return false;
        return Arrays.equals(
            s.chars().sorted().toArray(),
            t.chars().sorted().toArray()
        );
    }
    public static void main(String[]args){
        Solution obj=new Solution();
        System.out.println(obj.isAnagram("anagram","nagaram"));
    }
}
