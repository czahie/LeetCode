# Search in Rotated Sorted Array
+ Two binary searches. First one find the rotated pivot, second one find the target (or -1)
+ If `nums[mid] > nums[mid + 1]`, `mid + 1` is the index of the pivot. To avoid index out of bound, the pivot at `0` should be considered first separately
+ After finding the pivot, if `pivot == 0`, the binary search range is from the very start of the array to the very end. Else, check the comparison between `nums[target]` and `nums[0]`

## A common template for binary search 
Written in Python

    # corner case
    if not nums:
        return -1
    # make sure the index is in the range
    start = 0
    end = len(nums) - 1
    # make sure the loop will definitely terminate
    while start + 1 < end:
        mid = (start + end) // 2
        if nums[mid] == target:
            return mid
        if nums[mid] < target:
            # no need to consider +1 or not
            start = mid
        else:
         	  # no need to consider + 1 or not
            end = mid
    # check the number at index end or start
    # the order depends on whether you want the first index or the last index
    if nums[end] == target:
        return end
    if nums[start]  == target:
        return start
    # not found
    return -1
       