import heapq

def solution(k, score):
    answer = []
    heap = []
    for point in score:
        if len(heap) == k and heap[0] < point:
            heapq.heappop(heap)
            heapq.heappush(heap, point)
        if len(heap) < k:
            heapq.heappush(heap, point)
        answer.append(heap[0])
    return answer