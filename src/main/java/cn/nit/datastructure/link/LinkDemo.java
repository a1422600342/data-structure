package cn.nit.datastructure.link;

/**
 * @ClassName LinkDemo
 * @Description TODO 链表demo
 * @Author dong <feng.db@uniteddata.com>
 * @Date 2019/8/16
 * @Version 1.0.0
 **/
public class LinkDemo {
    public static void main(String[] args) {
        SingleLinkNode head = new SingleLinkNode(10);
        SingleLinkNode node1 = new SingleLinkNode(11);
        SingleLinkNode node2 = new SingleLinkNode(12);
        SingleLinkNode node3 = new SingleLinkNode(13);
        SingleLinkNode node4 = new SingleLinkNode(14);
        /*
        SingleLinkNodeUtil.addLinkNodeByTail(head,node1);
        SingleLinkNodeUtil.showLinkNodeByTail(head);

        SingleLinkNodeUtil.addLinkNodeByTail(head,node2);
        SingleLinkNodeUtil.addLinkNodeByTail(head,node3);
        SingleLinkNodeUtil.addLinkNodeByTail(head,node4);
        SingleLinkNodeUtil.showLinkNodeByTail(head);

        SingleLinkNodeUtil.deleteLinkNode(head,node3);
        SingleLinkNodeUtil.showLinkNodeByTail(head);

        SingleLinkNode node5 = new SingleLinkNode(15);
        SingleLinkNodeUtil.updateLinkNode(head,node4,node5);
        SingleLinkNodeUtil.showLinkNodeByTail(head);
        */

        head = SingleLinkNodeUtil.addLinkNodeByHead(head,node1);
        head = SingleLinkNodeUtil.addLinkNodeByHead(head,node2);
        head = SingleLinkNodeUtil.addLinkNodeByHead(head,node3);
        head = SingleLinkNodeUtil.addLinkNodeByHead(head,node4);

        SingleLinkNodeUtil.showLinkNodeByTail(head);
        SingleLinkNodeUtil.showLinkNodeByHead(head);
    }
}

/**
 * 单链表节点
 */
class SingleLinkNode {
    private int data; // 节点数据
    private SingleLinkNode next; //节点指针
    public SingleLinkNode(int data) {
        this.data = data;
        this.next = null;
    }
    public void setNext(SingleLinkNode next) {
        this.next = next;
    }
    public SingleLinkNode getNext(){
        return this.next;
    }
    public int getData(){
        return this.data;
    }
}

/**
 * 单链表的操作
 */
class SingleLinkNodeUtil {

    /**
     * 尾插法实现添加（即往链表尾部添加节点:head->node，左侧第一个头节点是不变的）
     * @param head
     * @param node
     */
    public static void addLinkNodeByTail(SingleLinkNode head,SingleLinkNode node){
        SingleLinkNode p = head;
        while (p.getNext() != null) {
            p = p.getNext();
        }
        System.out.println("添加节点成功！ " + node.getData());
        p.setNext(node);
    }

    /**
     * 头插法实现添加（即往链表头部插入节点:node->head->n,插入后，需要把左侧第一个变成新的头节点:head->n->n）
     * @param head
     * @param node
     * @return 头节点
     */
    public static SingleLinkNode addLinkNodeByHead(SingleLinkNode head,SingleLinkNode node){
        SingleLinkNode p = node;
        SingleLinkNode q = head;
        while (p.getNext() != null){
            p = p.getNext();
        }
        System.out.println("添加节点成功！ " + node.getData());
        p.setNext(q);
        return node;
    }

    /**
     * 删除指定单链表节点
     * @param head
     * @param node
     */
    public static void deleteLinkNode(SingleLinkNode head,SingleLinkNode node){
        SingleLinkNode p = head;
        while (p.getNext() != null && p.getNext() != node) {
            p = p.getNext();
        }
        if (p.getNext() == null) {
            System.out.println("没有找到该节点！删除失败");
            return;
        }
        p.setNext(p.getNext().getNext());
        System.out.println("成功删除该节点！" + node.getData());
    }

    /**
     * 修改指定单链表节点
     * @param head
     * @param oldNode
     * @param newNode
     */
    public static void updateLinkNode(SingleLinkNode head,SingleLinkNode oldNode,SingleLinkNode newNode) {
        SingleLinkNode p = head;
        while (p.getNext() != null && p.getNext() != oldNode){
            p = p.getNext();
        }
        if (p.getNext() == null) {
            System.out.println("没有找到该节点！更新失败");
            return;
        }
        p.setNext(newNode);
        System.out.println("成功更新节点！" + "old：" + oldNode.getData() + "修改为：" + newNode.getData());
    }

    /**
     * 遍历单链表（根据尾插法生成的单链表直接顺序遍历即可）
     * @param head
     */
    public static void showLinkNodeByTail(SingleLinkNode head){
        SingleLinkNode p = head;
        System.out.print("当前链表为：");
        do {
            System.out.printf("%d->",p.getData());
            p = p.getNext();
        }while (p != null);
        System.out.println();
    }

    /**
     * 遍历单链表（根据头插法生成的单链表，需要逆序遍历，遍历结果才能跟插入顺序保持一致）
     * @param head
     */
    public static void showLinkNodeByHead(SingleLinkNode head) {

        // 链表逆置

        // 遍历单链表

    }
}