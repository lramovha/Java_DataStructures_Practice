public class Stacks {
    private int[] arr;
    private int top;
    private int capacity;

    Stacks(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    public void push(int x) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            System.exit(1);
        }
        arr[++top] = x;
    }   

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            System.exit(1);
        }
        return arr[top--];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            System.exit(1);
        }
        return arr[top];
    }       

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }   

    public boolean isFull() {
        return top == capacity - 1;
    }

    public void printStack() {
        for (int i = 0; i <= top; i++) {
            System.out.println(arr[i]);
        }
    }

    public void reverseStack() {
        for (int i = top; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }

    public void sortStack() {
        for (int i = 0; i <= top; i++) {
            for (int j = i + 1; j <= top; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }   
        }
    }

    public static void main(String[] args) {
        Stacks stack = new Stacks(10);

        stack.push(3);
        stack.push(1);
        stack.push(2);
        stack.push(5);
        stack.push(4);
        stack.push(6);
        stack.push(10);
        stack.push(8);
        stack.push(9);
        stack.push(7);

        System.out.println("Stack");
        stack.printStack();

        System.out.println("Reversed Stack");
        stack.reverseStack();

        System.out.println("Sorted Stack");
        stack.sortStack();
        stack.printStack();

    }
}
