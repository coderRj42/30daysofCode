/*Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node.
If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.

Implement the MyLinkedList class:

MyLinkedList() Initializes the MyLinkedList object.
int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
void addAtHead(int val) Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
void addAtTail(int val) Append a node of value val as the last element of the linked list.
void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list. If index equals the length of the linked list, the node will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted.
void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.
 

Example 1:

Input
["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
[[], [1], [3], [1, 2], [1], [1], [1]]
Output
[null, null, null, null, 2, null, 3]

Explanation
MyLinkedList myLinkedList = new MyLinkedList();
myLinkedList.addAtHead(1);
myLinkedList.addAtTail(3);
myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
myLinkedList.get(1);              // return 2
myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
myLinkedList.get(1);              // return 3
 

Constraints:

0 <= index, val <= 1000
Please do not use the built-in LinkedList library.
At most 2000 calls will be made to get, addAtHead, addAtTail, addAtIndex and deleteAtIndex.
 */ class MyLinkedList {
    private Item head;
    private Item tail;
    private int length;

    public int get(int index) {
        Item result = getItemByIndex(index);
        if (result != null) return result.val;
        return -1;
    }

    public void addAtHead(int val) {
        if (length > 0) {
            Item temp = head;
            head = new Item(val);
            head.next = temp;
            temp.prev = head;
        } else {
            head = new Item(val);
            tail = head;
        }
        length++;
    }

    public void addAtTail(int val) {
        if (length > 0) {
            Item temp = tail;
            tail = new Item(val);
            tail.prev = temp;
            temp.next = tail;
        } else {
            tail = new Item(val);
            head = tail;
        }
        length++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > length) return; // index validation
        if (index == 0) addAtHead(val);
        else if (index == length) addAtTail(val);
        else {
            Item result = getItemByIndex(index);
            if (result != null) {
                Item temp = new Item(val);
                temp.prev = result.prev;
                result.prev.next = temp;
                temp.next = result;
                result.prev = temp;
                length++;
            }
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= length) return; // index validation
        if (index == 0) {
            if (length == 1) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                if (length > 2) head.next.prev = head;
            }
            length--;
        } else if (index == (length - 1)) {
            tail = tail.prev;
            if (length > 2) tail.prev.next = tail;
            length--;
        } else {
            Item result = getItemByIndex(index);
            if (result != null) {
                result.prev.next = result.next;
                result.next.prev = result.prev;
                length--;
            }
        }
    }

    private Item getItemByIndex(int index) {
        if (length > 0 && index < length) {
            if (index == 0) return head;
            if (index == length - 1) return tail;
            Item result;
            // we choose how to get to the desired element faster. Begin with head or tail
            if (index > (length / 2)) {
                result = tail;
                for (int i = length - 1; i > index; i--) {
                    result = result.prev;
                }
            } else {
                result = head;
                for (int i = 1; i <= index; i++) {
                    result = result.next;
                }

            }
            return result;
        }
        return null;
    }

    public int getLength() {
        return length;
    }
    // subclass element of linked-list
    private static class Item {
        public Item(int val) {
            this.val = val;
        }

        int val;
        Item next;
        Item prev;

    }
}
