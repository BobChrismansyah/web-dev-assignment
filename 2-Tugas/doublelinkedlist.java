public class DoubleLinkedList implements LinkedList {
    Node head;
    Node tail;

    @Override
    public void insertHead(int value) {

        Node newNode = new Node(value);

        if (head != null) {

            newNode.next = head;
            head.prev = newNode;
            head = newNode;

        } else {
            head = newNode;
            tail = newNode;
        }

    }

    @Override
    public void insertEndx(int value) {

        Node new_node = new Node(value);
        Node temp = head;
        new_node.next = null;

        if (head == null) {
            new_node.prev = null;
            head = new_node;
            return;
        }

        while (temp.next != null)
            temp = temp.next;
        temp.next = new_node;

        new_node.prev = temp;
        tail = new_node;

    }

    @Override
    public void insertEndy(int value) {

        Node newNode = new Node(value);

        if (head != null) {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        } else {
            insertHead(value);
        }
    }

    @Override
    public void deleteHead() {

        //
        if (head == null) {
            return;
        }
        head.prev = null;
        head = head.next;

    }

    @Override
    public void deleteEnd() {

        if (head == null) {
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        tail = tail.prev;
        tail.next = null;

    }

    @Override
    public void printNodes() {
        Node current = head;

        if (current != null) {
            System.out.print("null <--");
        }

        while (current != null) {
            System.out.print(current.value);

            if (current.next != null) {
                System.out.print(" <--> ");
            }
            current = current.next;
        }
        System.out.print("--> null");
    }

    @Override

    public void printNodesBackwards() {
        Node current = tail;

        while (current != null) {
            System.out.print(current.value + " --> ");
            current = current.prev;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        DoubleLinkedList dll = new DoubleLinkedList();
        dll.insertHead(69);
        dll.insertHead(70);
        dll.insertHead(12);
        // dll.printNodes();
        dll.insertEndx(50);
        dll.insertEndy(1);
        dll.deleteHead();
        dll.deleteEnd();
        // dll.printNodes();
        dll.printNodesBackwards();

    }
}

// tambahkan insert & delete di middle
// tambahkan search --> 50 (tampilkan node berada di node ke -x) atau "tidak ada
// dalam list"
