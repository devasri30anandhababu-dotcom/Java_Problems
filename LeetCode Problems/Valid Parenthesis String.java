import java.util.*;
class Solution {
        public boolean checkValidString(String expression){
            int opened=0,closed=0;
            char[] brackets = expression.toCharArray();
            for(char each: brackets){
                if(each=='('){
                    opened++; 
                    closed++;
                }
                else if(each==')'){
                    if(opened>0) opened--;
                    closed++;
                }
                else{
                    if(opened>0) opened--;
                    closed++;
                }
                if (closed<0) return false;
            }
            return opened==0;
        }
        
    }
