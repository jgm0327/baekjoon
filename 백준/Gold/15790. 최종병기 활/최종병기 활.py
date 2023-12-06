n, m, k = map(int, input().split())

slots = [int(input()) for _  in range(m)]

left, right = 1, n
answer = -1


def count(min_value):
    for i in range(m):
        # 시작점 저
        prev = slots[i]
        total = 0

        #원형이기 때문에 한 바퀴 돌림
        for j in range(i + 1, m + i + 1):
            # 양수이면 그대로 0 이거나 음수이면 +n
            length = slots[j % m] - prev

            if length <= 0:
                length += n

            if length >= mid:
                # 구간 나누기
                total += 1
                # 시작점 변
                prev = slots[j % m]
            
        if total >= k:
            return True
    return False


while left <= right:
    mid = (left + right) // 2 # 활의 최소 길이

    if count(mid):
        left = mid + 1
        answer = mid
    else:
        right = mid - 1

print(answer)
