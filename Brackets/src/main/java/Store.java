import java.util.Stack;

public class Store {

    Stack<Character> stack = new Stack<Character>();
    String brackets;
    int lengthOfBrackets;

    public Store(String brackets) {
        this.brackets = brackets;
        lengthOfBrackets =  brackets.length();
    }

    public synchronized Character getHead(){
        char head = brackets.charAt(0);
        if (lengthOfBrackets > 1) {
            brackets = brackets.substring(1);
            lengthOfBrackets--;
        }
        return head;
    }

    public synchronized int lengthBrackets() {
        return lengthOfBrackets;
    }

    public synchronized void add(char bracket){
        stack.push(bracket);
    }

    public synchronized void delete(){
        stack.pop();
    }

    public synchronized Character lookHead(){
        return stack.peek();
    }

    public synchronized boolean empty(){
        return stack.isEmpty();
    }

    public Stack<Character> getStack() {
        return stack;
    }
}
