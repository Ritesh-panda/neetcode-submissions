class LRUCache {

   class Node{
    int key;
    int value;
    Node prev;
    Node next;
    Node(int key, int value){
        this.key=key;
        this.value=value;
    }
   }
   int capacity;
   HashMap<Integer,Node> map;
   Node head;
   Node tail;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        map=new HashMap<>();
        head=new Node(0,0);
        tail=new Node(0,0);
        tail.prev=head;
        head.next=tail;

        
    }
    private void remove(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    private void insert(Node node){
        Node prev=tail.prev;
        prev.next=node;
        node.prev=prev;
        node.next=tail;
        tail.prev=node;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
           return -1;
        Node node=map.get(key);
        remove(node);
        
        insert(node);
        return node.value;  
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            remove(node);
            node.value=value;
            insert(node);
            return;
        }
        Node node=new Node(key,value);
        map.put(key,node);
        insert(node);
        if(map.size()>capacity){
            Node lru=head.next;
            remove(lru);
            map.remove(lru.key);
        }
    }
}
