# Add Two Numbers
+ Use of dummyHead in listNode problems.
    `return dummyHead.next`
+ Try to implement "in place" when encountering listNode problems.
+ Consider carriers in addition or multiplication problems
+ Initialize a new listNode can be easier:
`p.next = new listNode(num)`  v.s.
```
listNode n = new listNode(num);      
p.next = n;
```