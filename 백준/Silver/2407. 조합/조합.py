n, m = map(int, input().split())
tmp = n - m
m = m if tmp > m else tmp
total1 = total2 = 1
for num in range(n, n - m, -1):
    total1 *= num
for num in range(m, 0, -1):
    total2 *= num
print(total1 // total2)
