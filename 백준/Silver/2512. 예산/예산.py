from sys import stdin

n = int(stdin.readline())
budgets = list(map(int, stdin.readline().split()))
m = int(stdin.readline())

start, end = 0, max(budgets)
answer = 0
while start <= end:
    mid = (start + end) // 2
    total = 0
    for budget in budgets:
        if mid < budget:
            total += mid
        else:
            total += budget
    if total > m:
        end = mid - 1
    else:
        answer = mid
        start = mid + 1
print(answer)
