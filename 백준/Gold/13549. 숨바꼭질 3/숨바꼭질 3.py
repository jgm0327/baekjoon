from sys import stdin
import heapq

n, k = map(int, stdin.readline().split())
answer = abs(n - k)
if n >= k:
    print(answer)
    exit(0)

def bfs() -> int:
    global n, k
    heap = [[0, n]]
    inf = int(1e9)
    costs = [inf] * (2 * k)
    costs[0] = 0
    while heap:
        cnt, cur = heapq.heappop(heap)
        if costs[cur] < cnt:
            continue
        next_cnt = cnt + 1
        if cur - 1 >= 0 and costs[cur - 1] > next_cnt:
            heapq.heappush(heap, [next_cnt, cur - 1])
            costs[cur - 1] = next_cnt
        if cur + 1 < 2 * k and costs[cur + 1] > next_cnt:
            heapq.heappush(heap, [next_cnt, cur + 1])
            costs[cur + 1] = next_cnt
        if cur * 2 < 2 * k and costs[cur*2] > cnt:
            heapq.heappush(heap, [cnt, cur * 2])
            costs[cur * 2] = cnt
    return costs[k]

print(bfs())
