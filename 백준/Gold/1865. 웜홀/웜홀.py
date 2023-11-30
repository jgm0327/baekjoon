def bellmanford(start):
    global edges, n, m, w
    
    INF = int(1e9)
    
    times = [INF] * (n + 1)
    times[start] = 0
    
    for i in range(n):
        for sour, des, time in edges:
            next_time = times[sour] + time

            if times[des] <= next_time:
                continue

            if i == n - 1:
                return 'YES'

            times[des] = next_time

    return 'NO'


TC = int(input())
answer = []

for _ in range(TC):
    n, m, w = map(int, input().split())

    edges = []
    
    for i in range(m):
        s, e, t = map(int, input().split())

        edges.append((s, e, t))
        edges.append((e, s, t))

    for i in range(w):
        s, e, t = map(int, input().split())

        edges.append((s, e, -t))

    answer.append(bellmanford(1))

print('\n'.join(answer))

