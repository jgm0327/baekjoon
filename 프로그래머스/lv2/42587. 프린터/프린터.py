from collections import deque
import heapq

def solution(priorities, location):
    answer = 0
    priorities_heap = []
    printers = deque()
    n = len(priorities)
    for idx in range(n):
        heapq.heappush(priorities_heap, -priorities[idx])
        printers.append([priorities[idx], idx])
    find_value = priorities[location]
    while printers:
        printer = printers[0]
        printers.popleft()
        if -priorities_heap[0] > printer[0]:
            printers.append(printer)
        elif -priorities_heap[0] == printer[0]:
            answer += 1
            heapq.heappop(priorities_heap)
            if location == printer[1]:
                break
        
    return answer