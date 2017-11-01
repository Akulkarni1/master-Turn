/*
Application to give the index and the number of unmatched character in the palingdrome.
 */

import java.util.ArrayList;
import java.util.Stack;

class PalingdromeImpl{
    Stack<Character> stack;
    String string;
    PalingdromeImpl( String string){
        stack = new <Character>Stack();
        this.string = string;
    }
    public boolean isPanlingdrom(){
        boolean result =false;
        int length =string.length();
        int halfsize= string.length()/2;
        ArrayList<Integer> index = new ArrayList<Integer>();
        int count=0;
        if(string.length()%2==0){
            for(int i =0;i<halfsize ;i++){
                stack.push(string.charAt(i));
            }
            while(!stack.empty()){
                if(stack.pop()==string.charAt(halfsize)){
                    result=true;
                }
                else
                {
                    count++;
                    index.add(i);
                    result = false;
                }
                halfsize++;
            }
        }
        else{

            for(int i=0;i< halfsize;i++){
                stack.push(string.charAt(i));
            }
            while(!stack.empty()){
                if(stack.pop()==string.charAt(halfsize+1)){
                    result = true;
                }
                else{
                    count++;
                    index.add(i);
                    result = false;
                }
                halfsize++;
            }
        }
        return result;
    }
}
public class PalingdromeIndexApp {
    public static void main(String[] args){
        
    }
}
