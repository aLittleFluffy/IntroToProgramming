package eTestPractice;

import java.util.*;


public class Stack {
    private ArrayList<Object> stack;
    public Stack(){
        stack = new ArrayList<Object>();
    }
    public void push(Object input){
        // Pushes item to stack
        stack.add(input);
    }
    public Object pop(){
        if(stack!=null){
            int returnVal = (int)stack.get(stack.size()-1);
            stack.remove(stack.get(stack.size()-1));
            return returnVal;
        } else {
            System.out.println("Your stack is empty m8");
            return -1;
        }
    }
    public Object peek(){
        if(stack!=null){
            return (int)stack.get(stack.size()-1);
        } else {
            return -1;
        }
    }
    public int search(Object element){
        for(int i = stack.size()-1; i>=0; i--){
            Object currentValue = stack.get(i);
            if(currentValue == element){
                return i;
            }
        }
        return -1;
    }
    public void move(Object element){
        int location = search(element);
        if(location>-1){
            stack.remove(location);
            push(element);
        }
    }
}
