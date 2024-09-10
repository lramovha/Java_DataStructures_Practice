public class Queue {
    private int[] arr;
    private int front;
    private int rear;
    private int capacity;

    Queue(int size) {
        arr = new int[size];
        capacity = size;
        front = 0;
        rear = -1;
    }

    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full");
            System.exit(1);
        }
        arr[++rear] = item;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            System.exit(1);
        }
        return arr[front++];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            System.exit(1);
        }
        return arr[front];
    }

    public int size() {
        return rear - front + 1;
    }

    public boolean isEmpty() {
        return rear < front;
    }  

    public boolean isFull() {
        return rear == capacity - 1;
    }   

    public void printQueue() {
        for (int i = front; i <= rear; i++) {
            System.out.println(arr[i]);
        }
    }

    public void reverseQueue() {
        int[] temp = new int[capacity];
        for (int i = rear; i >= front; i--) {
            temp[rear - i] = arr[i];
        }
        arr = temp;
    }

    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.printQueue();

        System.out.println("Dequeue: " + queue.dequeue());
        queue.printQueue();
    }
    
}