package cn.nit.datastructure.queue;

/**
 * @ClassName QueueDemo
 * @Description TODO 队列demo
 * @Author dong <feng.db@uniteddata.com>
 * @Date 2019/8/15
 * @Version 1.0.0
 **/
public class QueueDemo {
    public static void main(String[] args) {
        // ArrayQueue arrayQueue = new ArrayQueue(5);
        CircleArrayQueue arrayQueue = new CircleArrayQueue(5);
        arrayQueue.addQueue(11);
        arrayQueue.addQueue(22);
        arrayQueue.addQueue(33);

        arrayQueue.peakQueue();
        System.out.println("当前队列：");
        arrayQueue.showQueue();

        arrayQueue.getQueue();
        arrayQueue.peakQueue();
        System.out.println("当前队列：");
        arrayQueue.showQueue();

        arrayQueue.addQueue(78);
        arrayQueue.peakQueue();
        System.out.println("当前队列：");
        arrayQueue.showQueue();

        arrayQueue.addQueue(44);
        arrayQueue.peakQueue();
        System.out.println("当前队列：");
        arrayQueue.showQueue();

        arrayQueue.addQueue(15);
    }
}

/**
 * 初始版的数组队列
 */
class ArrayQueue{
    private int rear; // 队列尾部指针
    private int front; // 队列头部指针
    private int maxSize; // 队列最大容量
    private int[] arr; // 队列存储

    /**
     * 构造器初始化队列
     * @param maxSize 队列最大容量
     */
    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = rear = -1;
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty(){
        return front == rear;
    }

    /**
     * 判断队列是否已满
     * @return
     */
    public boolean isFull(){
        return rear >= maxSize -1;
    }

    /**
     * 入队
     * @param data
     */
    public void addQueue(int data){
        // 判断队列是否已满
        if (isFull()) {
            System.out.println("队列已满，无法加入数据！");
            return;
        }
        System.out.println("入队，" + data);
        arr[++rear] = data;
    }

    /**
     * 出队
     * @return
     */
    public int getQueue() {
        // 判断队列是否为空
        if (isEmpty()) throw new RuntimeException("队列为空！");
        int data = arr[++front];
        System.out.println("出队，" + data);
        return data;
    }

    /**
     * 显示队列
     */
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列为空，无数据！");
            return;
        }
        for (int i = 0; i < arr.length; ++i) {
            System.out.printf("%d:%d\n",i,arr[i]);
        }
    }

    /**
     * 返回队列头部第一个数据
     * @return
     */
    public int peakQueue() {
        if (isEmpty()) throw new RuntimeException("队列为空，无数据！");
        int data = arr[front+1];
        System.out.printf("当前队列头部为：%d，%d\n",front+1,data);
        return data;
    }
}

/**
 * 环形数组队列
 */
class CircleArrayQueue{
    private int front;
    private int rear;
    private int maxSize;
    private int[] arr;

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = rear = 0;
    }

    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty(){
        return rear == front;
    }

    public void addQueue(int data){
        if (isFull()) {
            System.out.println("队列已满，无法添加！");
            return;
        }
        System.out.println("入队：" + data);
        arr[rear] = data;
        rear = (rear + 1) % maxSize;
    }

    public int getQueue() {
        if (isEmpty()) throw new RuntimeException("队列为空，无数据！");
        int data = arr[front];
        System.out.println("出队：" + data);
        front = (front + 1) % maxSize;
        return data;
    }

    public void showQueue(){
        if (isEmpty()) {
            System.out.println("队列为空，无数据！");
            return;
        }
        // 获取当前环形队列有效元素个数
        int length = (rear + maxSize - front) % maxSize;
        // 从front开始遍历
        for (int i = front; i < front + length; ++i) {
            System.out.printf("%d,%d \n", i % maxSize, arr[i % maxSize]);
        }
    }

    public int peakQueue() {
        if (isEmpty()) throw new RuntimeException("队列为空，无数据！");
        int head = arr[front % maxSize];
        System.out.printf("队列头部为：%d,%d\n",front%maxSize,head);
        return head;
    }
}