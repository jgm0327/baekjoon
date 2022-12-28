import sys

input = sys.stdin

T = int(input.readline())
for _ in range(T):
    n = int(input.readline())
    new_employees = []
    answer = 1
    for i in range(n):
        new_employees.append(list(map(int, input.readline().split())))
    new_employees.sort()
    temp = new_employees[0][1]
    for i in range(1, n):
        if temp > new_employees[i][1]:
            answer += 1
            temp = new_employees[i][1]
    print(answer)
