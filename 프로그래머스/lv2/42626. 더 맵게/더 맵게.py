import heapq

def solution(scoville, k):
    answer = 0
    heapq.heapify(scoville)
    mix = 0
    
    while scoville:
        first = heapq.heappop(scoville)
        if first >= k:
            return answer
        if not scoville:
            break
        second = heapq.heappop(scoville)
        mix = first + second * 2
        heapq.heappush(scoville, mix)
        answer += 1
    
    return -1