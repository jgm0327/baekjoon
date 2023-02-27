from sys import stdin
import heapq

heap = []
for _ in range(int(stdin.readline())):
    n = int(stdin.readline())
    if n:
        heapq.heappush(heap, [abs(n), n])
    else:
        print(heapq.heappop(heap)[1] if heap else '0')
    
