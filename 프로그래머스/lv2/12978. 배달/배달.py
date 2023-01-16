import heapq

def dikjstra(n, graph, k) -> list:
    count = [int(1e9)] * (n + 1)
    heap = [[0, 1]] # 최단 거리, 현재 위치
    count[1] = 0
    while heap:
        cnt, pos = heapq.heappop(heap)
        if cnt > count[pos] or cnt > k:
            continue
        for node in graph[pos]:
            next_pos, next_cnt = node[0], node[1] + cnt
            if count[next_pos] > next_cnt and next_cnt <= k:
                count[next_pos] = next_cnt
                heapq.heappush(heap, [next_cnt, next_pos])
    return count
    

def solution(N, road, K):
    graph = [[] for _ in range(N + 1)]
    for info in road:
        sour, des, cnt = info
        graph[sour].append([des, cnt])
        graph[des].append([sour, cnt])
    
    count = dikjstra(N, graph, K)
    answer = 0
    for data in count:
        if int(1e9) != data:
            answer += 1
    return answer