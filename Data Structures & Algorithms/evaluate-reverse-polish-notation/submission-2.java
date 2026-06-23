class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer>stack=new Stack<>();
        
        for(int i=0;i<tokens.length;i++){
            String ch=tokens[i];
            
            if(ch.matches("-?\\d+")){
                stack.push(Integer.parseInt(ch));
            }
            else if(ch.equals("+")||ch.equals("-")||ch.equals("*")||ch.equals("/")){
             int num1=stack.pop();
             int num2=stack.pop();
             int result=0;
             switch(ch){
                case "+":
                 result=num2+num1;
                 break;
                case "-":
                 result=num2-num1;
                 break;
                case "/":
                 result=num2/num1;
                 break;
                case "*" :
                result=num2*num1;
                break;

             }
             stack.push(result);

            }
        }
        return stack.peek();
    }
}
