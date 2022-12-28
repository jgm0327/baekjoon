import sys

input = sys.stdin

n = int(input.readline())
distances = list(map(int, input.readline().split()))
gas_stations = list(map(int, input.readline().split()))

cur = gas_stations[0]
answer = cur * distances[0]
for idx, distance in enumerate(distances[1:]):
    if cur * distance > gas_stations[idx + 1] * distance:
        cur = gas_stations[idx + 1]
    answer += cur * distance

print(answer)