from heapq import heappush, heappop


def dijkstra(graph, n, start, end):
    heap = []
    
    INF = 2 * int(1e7) + 1
    costs = [INF] * (n + 1)
    costs[start] = 0
    
    heappush(heap, (0, start))
    
    while heap:
        cur_cost, sour = heappop(heap)
        
        if cur_cost > costs[sour]:
            continue
        
        for des, cost in graph[sour]:
            next_cost = cost + cur_cost
            
            if next_cost > costs[des]:
                continue
                
            costs[des] = next_cost
            heappush(heap, (next_cost, des))
    
    return costs[end]

def solution(n, s, a, b, fares):
    answer = 2 * int(1e7)
    graph = [[] for _ in range(n + 1)]
    
    for sour, des, cost in fares:
        graph[sour].append((des, cost))
        graph[des].append((sour, cost))
           
    for mid in range(1, n + 1):
        cost1 = dijkstra(graph, n, s, mid)
        cost2 = dijkstra(graph, n, mid, a)
        cost3 = dijkstra(graph, n, mid, b)
    
        answer = min(answer, cost1 + cost2 + cost3)
    
    return answer