import sys

input = sys.stdin

n, m = map(int, input.readline().split())
lan_wires = []
for _ in range(n):
    lan_wires.append(int(input.readline()))

start, end = 0, (2**31)
answer = 0
while start <= end:
    mid = (start + end) // 2
    count = 0
    for lan_wire in lan_wires:
        if mid == 0:
            break
        count += lan_wire // mid
    if m > count:
        end = mid - 1
    else:
        answer = answer if answer > mid else mid
        start = mid + 1
print(answer)
