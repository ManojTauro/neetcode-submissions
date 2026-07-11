class LRUCache {
    Node head;
    Node tail;
    int capacity = 0;
    Map<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
        
        this.capacity = capacity;    
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node cur = map.get(key);

        deleteNode(cur);
        insertAfterHead(cur);

        return cur.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node cur = map.get(key);
            cur.val = value;

            deleteNode(cur);
            insertAfterHead(cur);
        } else {
            if (capacity == map.size()) {
                Node toBeEvicted = tail.prev;
                map.remove(toBeEvicted.key);
                deleteNode(toBeEvicted);
            }

            Node newNode = new Node(key, value);
            map.put(key, newNode);
            insertAfterHead(newNode);
        }
    }

    private void insertAfterHead(Node node) {
        Node curAfterHead = head.next;

        node.next = curAfterHead;
        curAfterHead.prev = node;

        head.next = node;
        node.prev = head;
    }

    private void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

class Node {
    int key;
    int val;
    Node next;
    Node prev;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}