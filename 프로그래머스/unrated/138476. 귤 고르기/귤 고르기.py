import heapq

def solution(k, tangerine):
    answer = 0
    tangerines = {}
    
    for t in tangerine:
        if tangerines.get(t) != None:
            tangerines[t] += 1
        else:
            tangerines[t] = 1
    heap = []
    for data in tangerines.values():
        heapq.heappush(heap, -data)
    while heap:
        cnt = heapq.heappop(heap)
        answer += 1
        if k <= -cnt:
            break
        k += cnt
    return answer