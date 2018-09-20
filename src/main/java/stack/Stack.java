package stack;

public class Stack<T> {

    Object[] stack;
    int point;

    public Stack() {
        this.stack = new Object[10];
        point = -1;
    }

    public void push(T o) {

        stack[++point] = o;
    }
    public T pop() {
        if (point <= -1)
            return null;
        return (T) stack[point--];

    }

    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack<Integer>();

        myStack.push(12);
        myStack.push(1);
        myStack.push(1);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }

}
