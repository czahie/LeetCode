 class Solution:
    def hIndex(self, citations: List[int]) -> int:
        citations.sort(reverse=True)
        for idx, num in enumerate(citations):
            if idx >= num:
                return idx;
        return len(citations)