class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
class MyCircularQueue {
    ListNode front;
    ListNode rear;
    int idx = 0;
    int n;
    public MyCircularQueue(int k) {
        n = k;
        this.front = new ListNode(0);
        this.rear = this.front;
    }
    
    public boolean enQueue(int value) {
        if (idx == n) return false;
        rear.next = new ListNode(value);
        rear = rear.next;
        rear.next = front;
        idx++;
        return true;
    }
    
    public boolean deQueue() {
        if (idx == 0) return false;
        front.next = front.next.next;
        idx--;
        return true;
    }
    
    public int Front() {
        if (idx == 0) return -1;
        return front.next.val;
    }
    
    public int Rear() {
        if (idx == 0) return -1;
        return rear.val;
    }
    
    public boolean isEmpty() {
        return idx == 0;
    }
    
    public boolean isFull() {
        return idx == n;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */