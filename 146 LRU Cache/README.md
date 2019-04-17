# LRU Cache
## Idea
+ HashMap + DoubleLinkedList.
+ Ads of DoubleLinkedList: A node can remove itself without other references; It takes constant time to add and remove nodes from the head or tail.
+ 2 dummy nodes: `head` and `tail`. 
+ 4 methods for DoubleLinkedList, `addNode` (always add after head), `removeNode`. `moveToHead`, `popTail`.
+ Every node maintains 4 attributes: `prev`, `next`, `key`, `value`.
+ For robust, consider key not exists in `get` and key already exists `put`.

## Running time
Average: O(1) 