n= int(input())

left, right = 0, int(1e9)

answer = 0
while left <= right:
    mid = (left + right) // 2

    total = (mid * (mid + 1)) // 2

    if total > n:
        right = mid - 1
    else:
        answer = mid
        left = mid + 1

print(answer)
