package src.lesson2503;

import src.Stack;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack(100);
        String str = "()()((";
        System.out.println(stack.isWork(str));
    }
}
