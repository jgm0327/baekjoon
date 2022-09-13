import sys
import heapq


def solution():
    read = sys.stdin

    n = int(read.readline())
    result = 0
    costs = []

    for _ in range(n):
        heapq.heappush(costs, -int(read.readline()))

    while costs:
        for i in range(2):
            result += -costs[0]
            if costs:
                heapq.heappop(costs)
            if len(costs) == 0:
                print(result)
                return
        heapq.heappop(costs)
    print(result)


solution()
