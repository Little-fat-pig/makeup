package com.linkedlist;

/*
 *@author zhangxl
 *@Date 2021/12/6 22:35
 *@description   创建单链表的两种方式
 */
public class LinkedListDemo {

    private Node head=null;

    /**
     * 头插法创建
     */
    public Node singleListHeadInsertion(int data){
        Node node=new Node(data);
        node.next=head;
        head=node;
        return node;
    }

    /**
     * 尾插法创建
     */
    public Node singlyLinkedList(int data){
        Node node=new Node(data);
        if (head==null){
            head=node;
        }else {
            Node temp=head;
            while (temp.next!=null){
                temp= temp.next;
            }
            temp.next=node;
        }
        return head;
    }

    public static void main(String[] args) {
        LinkedListDemo linkedListDemo=new LinkedListDemo();
        Node node=null;
        //头插法
//        for (int i = 0; i < 10; i++) {
//            node = linkedListDemo.singleListHeadInsertion(i);
//        }
        //尾插法
        for (int i = 0; i < 10; i++) {
            node = linkedListDemo.singlyLinkedList(i);
        }

        //遍历单链表
        while (node!=null){
            System.out.print(node.data+"->");
            node=node.next;
        }
    }
}
