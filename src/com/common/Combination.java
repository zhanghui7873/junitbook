package com.common;

import java.util.Stack;

public class Combination 
{

public static void combiantion(char chs[]){  
    if(chs.length == 0) return ;  
      
    Stack<Character> stack = new Stack<Character>();  
    for(int i = 1; i <= chs.length; i++){  
        combine(chs, 0, i, stack);  
    }  
}  
//从字符数组中第begin个字符开始挑选number个字符加入list中  
public static void combine(char []chs, int begin, int number, Stack<Character> stack)
{  
       if(number == 0){  
        System.out.println(stack.toString());  
        return ;  
       }  
       if(begin == chs.length){  
        return;  
       }  
       stack.push(chs[begin]); 
       System.out.println("before:"+stack.toString());  
       System.out.println(" before: begin="+begin+",number="+number);
       combine(chs, begin + 1, number - 1, stack);  
       stack.pop();  
       System.out.println("after:"+stack.toString());  
      // System.out.println(stack.toString());  
       combine(chs, begin + 1, number, stack);  
       System.out.println(" after: begin="+begin+",number="+number);
}  

public static void main(String args[])
{
	char[] ch={'A','B','C','D'};
	Combination.combiantion(ch);
}

}