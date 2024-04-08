import sys
from heapq import heappop, heappush

input = sys.stdin.readline

n, m = map(int, input().split())
s = int(input())

graph = [[] for _ in range(n + 1)]

for _ in range(m):
    sour, des, cost = map(int, input().split())
    graph[sour].append((des, cost))
    

def dijkstra(start):
    global graph, n
    INF = int(1e9)
    costs = [INF] * (n + 1)
    costs[start] = 0
    
    heap = []
    heappush(heap, (0, start))
    
    while heap:
        cur_cost, sour = heappop(heap)
        
        if costs[sour] < cur_cost:
            continue
        
        for des, cost in graph[sour]:
            nextCost = cost + cur_cost
            
            if costs[des] <= nextCost:
                continue
               
            costs[des] = nextCost
            heappush(heap, (nextCost, des))
            
    for i in range(1, n + 1):
        if INF == costs[i]:
            print('INF')
        else:
            print(costs[i])
            
            
dijkstra(s)
