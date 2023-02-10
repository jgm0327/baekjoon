from sys import stdin
import heapq

n = int(stdin.readline())
graph = [stdin.readline().rstrip().split() for _ in range(n)]

for i in range(2):
    for sour in range(n):
        for mid in range(n):
            for des in range(n):
                if graph[sour][mid] == '1' and graph[mid][des] == '1':
                    graph[sour][des] = '1'
    
for g in graph:
    print(' '.join(g))
