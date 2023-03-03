n, k = map(int, input().split())
answer = 0
for h in range(n+1):
    h = str(h) if h // 10 else '0'+str(h)
    for m in range(60):
        m = str(m) if m // 10 else '0'+str(m)
        for s in range(60):
            s = str(s) if s // 10 else '0'+str(s)
            if str(k) in h + m + s:
                answer += 1
print(answer)
