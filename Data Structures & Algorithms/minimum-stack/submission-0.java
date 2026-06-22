class MinStack {
    Stack<Integer>stack;
    public MinStack() {
        stack =new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        int top=stack.peek();
        return top;
    }
    
    public int getMin() {
        int min=Integer.MAX_VALUE;
        for(int i=0;i<stack.size();i++){
            min=Math.min(min,stack.get(i));
        }
        return min;
    }
}
