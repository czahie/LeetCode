class LRUCache:
    
    class DLinkedNode:   
        def __init__(self):
            self.key = 0
            self.value = 0
            self.prev = None
            self.next = None
    
    def add_node(self, node):
        node.next = self.head.next
        self.head.next.prev = node
        
        node.prev = self.head
        self.head.next = node
    
    def remove_node(self, node):
        prev = node.prev
        next_ = node.next
        
        next_.prev = prev
        prev.next = next_
    
    def move_to_head(self, node):
        self.remove_node(node)
        self.add_node(node)
        
    def pop_tail(self):
        res = self.tail.prev
        self.remove_node(res)
        return res

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.size = 0
        self.cache = {}
        self.head = self.DLinkedNode()
        self.tail = self.DLinkedNode()
        self.head.next = self.tail
        self.tail.prev = self.head
        

    def get(self, key: int) -> int:
        if key in self.cache:
            node = self.cache[key]
            self.move_to_head(node)
            return node.value
        return -1
        # node = self.cache.get(key, None)
        # if not node:
        #     return -1
        # self.move_to_head(node)
        # return node.value

    def put(self, key: int, value: int) -> None:
        if key in self.cache:
            node = self.cache[key]
            node.value = value
            self.move_to_head(node)
        else:
            new_node = self.DLinkedNode();
            new_node.key = key
            new_node.value = value
            self.cache[key] = new_node
            self.add_node(new_node)
            self.size += 1
            if self.size > self.capacity:
                poped_node = self.pop_tail()
                del self.cache[poped_node.key]
                self.size -= 1 

# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)