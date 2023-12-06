n, m, k = map(int, input().split())

slots = [int(input()) for _  in range(m)]

left, right = 1, n
answer = -1

while left <= right:
    mid = (left + right) // 2

    for i in range(m):
        prev = slots[i]
        total = 0
        
        for j in range(i + 1, m + i + 1):
            length = slots[j % m] - prev if slots[j % m] - prev > 0 else slots[j % m] - prev + n
            if length < mid:
                continue
            total += 1
            prev = slots[j % m]
            
        if total >= k:
            break

    if total >= k:
        left = mid + 1
        answer = mid
    else:
        right = mid - 1

print(answer)
