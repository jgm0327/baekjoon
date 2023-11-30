n, m = map(int, input().split())

edges = []

for _ in range(m):
    s, e, t = map(int, input().split())
    edges.append((s, e, t))


def bellmanford():
    global edges, n, m

    INF = int(1e9)
    times = [INF] * (n + 1)
    times[1] = 0

    for i in range(1, n + 1):
        for j in range(m):
            sour, des, time = edges[j]
            next_time = times[sour] + time

            if times[sour] == INF or times[des] <= next_time:
                continue

            times[des] = next_time

            if i == n:
                return []

    return times[2:]
    


result = bellmanford()

if not result:
    print(-1)
    
else:
    for cost in result:
        print(cost if cost != int(1e9) else -1)
