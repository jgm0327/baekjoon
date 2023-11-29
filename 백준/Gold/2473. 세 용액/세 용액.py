n = int(input())

liquid = sorted(list(map(int, input().split())))

answer = []
min_value = 5 * int(1e9)
for i in range(n):
    left_liquid = liquid[i]
    mid, right = i + 1, n - 1

    while mid < right:
        total = left_liquid + liquid[mid] + liquid[right]

        if min_value > abs(total):
            min_value = abs(total)
            answer = [str(left_liquid), str(liquid[mid]), str(liquid[right])]
        
        if total < 0:
            mid += 1
        else:
            right -= 1
            
print(' '.join(answer))
