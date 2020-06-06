class practise {
    public static void main(String[] args) {
        System.out.println("Alessio Simoya");
        LinkedList list = new LinkedList();

        //insertion 
         list   = list.insert(list,1);
         list   = list.insert(list,3);
         list   = list.insert(list,4);
         list   = list.insert(list,5);
         list   = list.insert(list,10);
         list   = list.insert(list,19);
         list.printList(list);

    }

}
class LinkedList {
    //head of the list 
    Node head;
    static class Node {
        int data;
        Node next;

        // constructor to create new node 
        //next is by default initialized
        Node(int d){
            data = d;
            next = null;
        }
    }
    // method to insert a new node
    public  LinkedList insert(LinkedList list, int data){
        // create a new node with the given data 
        Node new_node  = new Node(data);
        new_node.next = null;

        // if the linked list is empty
        //then make the new node the head
        if(list.head == null){
            list.head = new_node;
        } else {
            // else transverse till last node and insert the new_node there
            Node last = list.head;
            while(last.next != null){
                last  = last.next;

            }
            //insert the new node at the last
            last.next  = new_node;
        }
        // return the list by head 
        return list;
    }
    public void  printList(LinkedList list){

        Node currNode = list.head;
        System.out.println("LinkedList: ");
        // traverse through the linkedlist
        while(currNode != null) {
            //print out the data at current node 
            System.out.println(currNode.data + " ");
            // go to next node 
            currNode = currNode.next;
        }
    }
    // deleting an element by the key
    public static LinkedList deleteByKey(LinkedList list, int key){
        // store the head node
        Node currNode = list.head, prev  = null;

        // case 1 
        // if the head node itself has the key to be deleted
        if(currNode != null && currNode.data == key){
            list.head = currNode.next; // changed head 
            // display the message
            System.out.println(key +  " found and deleted");
            return list;
        }

        // case 2 key is somewhere other than the head 
        // Search for key to be deleted keep track of previous node 
        //as it is need to change the currNode.next 
        while(currNode != null && currNode.data != key){
            // if currNode does not hold the key 
            //continue to next node 
            prev = currNode;
            currNode = currNode.next;

        }
        // if key was present, it should be at currNode  and therefore currNode shall not be null
        if(currNode != null){
             // Since the key is at curr Node 
             // unlink the currNode from the linkedlist 
             prev.next = currNode.next;
             System.out.println(key + " found and deleted");

             
        }
        // case three 
        // key is not present 
        if(currNode == null){
            //Display the message
            System.out.println(key + " Key not found ");


        }
        return list; 

    }

}