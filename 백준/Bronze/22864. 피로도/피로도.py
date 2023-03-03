a, b, c, m = map(int, input().split())
stamina = 0
answer = 0
for _ in range(24):
    if stamina + a <= m:
        stamina += a
        answer += b
    else:
        stamina -= c
        stamina = 0 if stamina < 0 else stamina
print(answer)
