n, m = map(int, input().split())

lan_wires = [int(input()) for _ in range(n)]

left, right = 1, 2 ** 31 - 1
answer = 0

while left <= right:
    mid = (left + right) // 2

    total = 0

    for wire in lan_wires:
        if wire < mid:
            continue

        total += (wire // mid)

    if total < m:
        right = mid - 1
        
    else:
        answer = max(answer, mid)
        left = mid + 1

print(answer)
