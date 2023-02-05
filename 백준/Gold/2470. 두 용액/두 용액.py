import sys

input = sys.stdin

n = int(input.readline())
liquids = sorted(list(map(int, input.readline().split())))
start, end = 0, n - 1
answer = [liquids[0], liquids[1]]
comp = 2 * int(1e9) + 1

while start < end:
    value = liquids[start] + liquids[end]
    if abs(value) < comp:
        comp = abs(value)
        answer = [liquids[start], liquids[end]]
    if value < 0:
        start += 1
    else:
        end -= 1
print(answer[0], answer[1])
