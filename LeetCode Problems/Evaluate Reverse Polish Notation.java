class Solution{
    public int evalRPN(String[] tokens){
        Stack<Integer> stk=new Stack<>();
        for(String tok:tokens){
            if(tok.equals("+")||
            tok.equals("-")||
            tok.equals("*")||
            tok.equals("/")){
                int data2=stk.pop(), data1=stk.pop();
                switch(tok){
                    case "+": stk.push(data1+data2);break;
                    case "-": stk.push(data1-data2);break;
                    case "*": stk.push(data1*data2);break;
                    case "/": stk.push(data1/data2);break;
                }
            }
            else stk.push(Integer.parseInt(tok));
        }
        return stk.pop();
    }
 
}
