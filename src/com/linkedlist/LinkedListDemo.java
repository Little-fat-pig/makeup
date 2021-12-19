package com.linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 *@author zhangxl
 *@Date 2021/12/6 22:35
 *@description   创建单链表的两种方式
 */
public class LinkedListDemo {

    public Node head = null;

    /**
     * 头插法
     */

    public Node createHeadLinkedList(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
        return node;
    }

    /**
     * 尾插法实现单链表
     *
     * @param data
     * @return
     */
    public Node createLinkedList(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
        return head;
    }


    //删除指定元素
    public Node delIndexNode(Node node, int number) {
        //删除链表结点出现断链的情况，证明删除链表数据没有后，没有保存删除链表的
        //一定要保存链表
        Node delPre = node;
        int step = 0;
        //遍历链表找到指定元素
        while (step < number) {
            node = node.next;
            step++;
        }
        //删除链表结点的核心操作
        node.next = node.next.next;
        return delPre;
    }

    //修改指定位置的参数
    public Node updateIndexNode(Node node, int number) {
        //一定要保存链表
        Node updatePre = node;
        int step = 0;
        while (step < number) {
            node = node.next;
            step++;
        }
        node.data = 16;
        return updatePre;
    }

    //指定位置新增元素
    public Node insertIndexNode(Node node, int number, Node newNode) {
        Node insertNode = node;
        int step = 0;
        while (step < number) {
            node = node.next;
            step++;
        }
        newNode.next = node.next;
        node.next = newNode;
        return insertNode;
    }

    //删除链表重复的元素    1.找到链表的
    public Node delRepeatElement(Node node) {
        Node head = node;
        Node node1 = head;
        List<Integer> list = new ArrayList<>(10);
        while (node1 != null) {
            if (!list.contains(node1.data)) {
                list.add(node1.data);
            }
            node1 = node1.next;
        }
        LinkedListDemo linkedListDemo = new LinkedListDemo();
        Node headLinkedList = null;
        for (Integer list1 : list) {
            //头插法重新构链表
//            headLinkedList = linkedListDemo.createHeadLinkedList(list1);
            headLinkedList = linkedListDemo.createLinkedList(list1);
        }
        return headLinkedList;
    }

    //如何找出单链表中的倒数第k个元素
    public Node queryKElement(Node head, int number) {
        Node temp = head;
        int sum = 0;
        while (head != null) {
            sum++;
            head = head.next;
        }
        System.out.println("获取链表的长度：" + sum);

        Node item = temp;
        int flout = 0;
        while (temp != null) {
            if ((sum - number) == flout) {
                System.out.print("倒数第k个元素：");
                System.out.println(temp.data);
            }
            flout++;
            temp = temp.next;
        }
        return item;
    }

    //查找第k个元素，第二种方案  使用双指针做
    public Node doublePointerKElement(Node head, int number) {
        if (number < 0) {
            return null;
        }
        Node p1 = head;//先走k-1个位置，当p1到达末尾的时候，p2的位置正好是倒数第k的位置
        Node p2 = head;
        if (p1 == null) {//不注释掉这一部分在输出顺数第一个数据时会报数组越界
            System.out.print("p1 is null!");
            return null;
        }
        for (int i = 0; i < number && p1 != null; ++i) {
            p1 = p1.next;
        }
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        System.out.print("倒数第k个元素：");
        System.out.println(p2.data);
        return p2;
    }


    //如何实现链表的反转   链表反转有4中方式
    public Node linkedListReverse(Node head) {
        Node temp=head;
        List<Integer> list=new ArrayList<>(10);
        while (temp!=null){
            list.add(temp.data);
            temp=temp.next;
        }
        LinkedListDemo linkedListDemo = new LinkedListDemo();
        Node headLinkedList=null;
        for (Integer integer:list) {
            System.out.print(integer);
            if (integer!=null){
                System.out.print("->");
            }
            headLinkedList = linkedListDemo.createHeadLinkedList(integer);
        };
        return headLinkedList;
    }

    //如何从尾到头输出单链表  第一种方案：可以使用链表反转做，但是太麻烦；第二种方案，可以使用栈来做   第三种方案，可以使用递归（也是栈）来做（缺陷  如果链表太长，栈太深，容易出现栈溢出）
    public void linkedListStack(Node head){
        //这里采用第二种方案做
        Node temp=head;
        //使用栈保存数据   栈的常用操作  isEmpty   push   peek   pop
        Stack<Integer> stack=new Stack<>();
        while (head!=null){
            //对象入栈
            stack.push(head.data);
            head=head.next;
        }
        //判断是不是空栈
        while (!stack.isEmpty()){
//            //查看栈顶对象，不删除
//            System.out.println("查看栈顶对象，不删除");
//            System.out.println(stack.peek());
            //删除栈顶对象，并返回该对象
            System.out.print(stack.pop());
            if (!stack.isEmpty()){
                System.out.print("->");
            }
        }
    }

    //如何寻找单链表的中间结点
    public void queryCenterNode(Node head){
        Node temp=head;
        int length=0;
        while (head!=null){
            length++;
            head=head.next;
        }
        int mind=(length/2)-1;
        int sum=1;
        while (temp!=null){
            if (mind==sum){
                System.out.println();
                System.out.println(temp.next.data);
                return;
            }
            sum++;
            temp=temp.next;
        }
    }

    //如何寻找单链表的中间结点  双指针做(双指针的核心思想是步长)
    public void queryCenterNode2(Node head){
        Node p=head;//每次走一步
        Node q=head;//因为找中间位置，所以每次走两步
        while (q!= null&&q.next!=null&&q.next.next!=null){
            p=p.next;
            q=q.next.next;
        }
        System.out.println(p.data);
    }

    //如何检测一个链表是否有环   判断链表的最后节点next为null
    public boolean isNodeNextNull(Node node){
        while (node!=null){
            if (node.next==null){
                System.out.println("单链表无环！");
                return true;
            }
            node=node.next;
        }
        return false;
    }

    //如何在不知道头结点的情况下删除指定结点


    //如何判断两个链表是否相交




    public static void main(String[] args) {
        LinkedListDemo linkedListDemo = new LinkedListDemo();
        Node node = null;

        //头插法的构建与遍历
//        for (int i = 0; i < 10; i++) {
//            node = linkedListDemo.createHeadLinkedList(i);
//        }

        //尾插法的构建与遍历
        for (int i = 0; i < 10; i++) {
            node = linkedListDemo.createLinkedList(i);
        }

        //删除链表中指定位置的元素
        Node delNode = linkedListDemo.delIndexNode(node, 6);
        System.out.println("===============删除链表中指定位置的元素================");
        while (delNode != null) {
            System.out.print(delNode.data);
            if (delNode.next != null) {
                System.out.print("->");
            }
            delNode = delNode.next;
        }
        System.out.println();

        //修改指定位置的元素
        Node updateNode = linkedListDemo.updateIndexNode(node, 3);
        System.out.println("==============修改指定位置的元素=================");
        while (updateNode != null) {
            System.out.print(updateNode.data);
            if (updateNode.next != null) {
                System.out.print("->");
            }
            updateNode = updateNode.next;
        }
        System.out.println();

        //指定位置新增元素
        Node insertNode = linkedListDemo.insertIndexNode(node, 3, new Node(6));
        System.out.println("==============指定位置的添加元素=================");
        while (insertNode != null) {
            System.out.print(insertNode.data);
            if (insertNode.next != null) {
                System.out.print("->");
            }
            insertNode = insertNode.next;
        }
        System.out.println();

        //判断链表是否有环
        boolean nodeNextNull = linkedListDemo.isNodeNextNull(node);
        System.out.println("======判断链表是否有环========");
        System.out.println(nodeNextNull);

        //删除链表中重复的元素
        System.out.println("==============删除链表中重复的元素，使用尾插法重新构建链表=================");
        Node delRepeatElement = linkedListDemo.delRepeatElement(node);
        while (delRepeatElement != null) {
            System.out.print(delRepeatElement.data);
            if (delRepeatElement.next != null) {
                System.out.print("->");
            }
            delRepeatElement = delRepeatElement.next;
        }
        System.out.println();

        //如何找出单链表中的倒数第k个元素  数学计算
        Node kElement = linkedListDemo.queryKElement(node, 3);
        System.out.println("==============如何找出单链表中的倒数第k个元素=================");
        while (kElement != null) {
            System.out.print(kElement.data);
            if (kElement.next != null) {
                System.out.print("->");
            }
            kElement = kElement.next;
        }
        System.out.println();

        //如何找出单链表中的倒数第k个元素  双指针实现
        Node kElement1 = linkedListDemo.doublePointerKElement(node, 3);
        System.out.println("==============如何找出单链表中的倒数第k个元素,双指针做=================");
        while (kElement1 != null) {
            System.out.print(kElement1.data);
            if (kElement1.next != null) {
                System.out.print("->");
            }
            kElement1 = kElement1.next;
        }
        System.out.println();


        //如何实现链表的反转  头插法反转反转链表
        Node linkedListReverse = linkedListDemo.linkedListReverse(node);
        System.out.println("==============如何实现链表的反转  头插法反转反转链表=================");
        while (linkedListReverse != null) {
            System.out.print(linkedListReverse.data);
            if (linkedListReverse.next != null) {
                System.out.print("->");
            }
            linkedListReverse = linkedListReverse.next;
        }
        System.out.println();

        //如何从尾到头输出单链表
        linkedListDemo.linkedListStack(node);

        //如何寻找单链表的中间结点
        linkedListDemo.queryCenterNode(node);
        //如何寻找单链表的中间结点  双指针做(双指针的核心思想是步长)
        linkedListDemo.queryCenterNode2(node);

        System.out.println(linkedListDemo.isNodeNextNull(node));

    }
}
