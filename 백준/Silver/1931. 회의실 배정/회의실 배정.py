import sys

input = sys.stdin

n = int(input.readline())
times = []
for _ in range(n):
    times.append(list(map(int, input.readline().split())))
times.sort(key=lambda x: [x[1], x[0]])

end_time = answer = 0
for time in times:
    if time[0] >= end_time:
        end_time = time[1]
        answer += 1

print(answer)