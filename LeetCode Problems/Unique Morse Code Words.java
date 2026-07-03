import java.util.*;

class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        
        String[] codes = {
            ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."
        };
        String temp="";
        Set<String> set=new HashSet<>();
        for(String each:words){
            temp="";
            for(char ch:each.toCharArray())
            temp+=codes[ch-'a'];
            set.add(temp);
        }
        return set.size();
    }
}
