# Merge K Sorted Lists
+ Use a heap or a priority queue (pq) to reduce the time complexity to O(Nlogk).
+ In Java, to initialize a pq with a self defined Comparator, you must declare the length of the pq at first. Also, when overriding the `compare` method, remember to specity the access modifier `public`.
+ In Python, the elements in the pq must be a tuple, remember to add extra parentheses. Also, rememeber to add a `id()` between the value of the listnode and the listnode itself. So it would be `pq.put((l.val, id(l), l)`.