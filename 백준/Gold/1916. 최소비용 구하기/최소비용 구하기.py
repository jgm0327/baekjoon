import sys
from queue import PriorityQueue

n = 0


def Dijkstra(graph, cost, start, end):
    global n
    pq = PriorityQueue()
    pq.put([0, start])
    cost[start] = 0

    while not pq.empty():
        cur = pq.get()
        if cost[cur[1]] < cur[0]:
            continue
        for data in graph[cur[1]]:
            des, weight = data[1], data[0]
            if cost[des] > weight + cur[0]:
                pq.put([weight+cur[0], des])
                cost[des] = cur[0] + weight
    print(cost[end])


def solution():
    global n
    n = int(sys.stdin.readline())
    m = int(sys.stdin.readline())
    INF = int(1e9)
    cost = [INF for i in range(n + 1)]
    graph = [[] for j in range(n + 1)]
    for i in range(m):
        sour, des, weight = map(int, sys.stdin.readline().split())
        graph[sour].append([weight, des])
    start, end = map(int, sys.stdin.readline().split())

    Dijkstra(graph, cost, start, end)


solution()
