n = int(input())

wires = sorted([list(map(int, input().split())) for _ in range(n)], key=lambda x: x[0])

def binary_search(dp, number):
    left, right = 0, len(dp) - 1

    while left <= right:
        mid = (left + right) // 2

        if dp[mid] < number:
            left = mid + 1
        else:
            right = mid - 1

    return left


dp = [wires[0][1]]

for wire in wires[1:]:
    if dp[-1] < wire[1]:
        dp.append(wire[1])
        continue

    idx = binary_search(dp, wire[1])
    dp[idx] = wire[1]

print(n - len(dp))

