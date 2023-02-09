from sys import stdin

n = int(stdin.readline())
distances = list(map(int, stdin.readline().split()))
gas_stations = list(map(int, stdin.readline().split()))
answer = distances[0] * gas_stations[0]
temp = gas_stations[0]
for distance, station in zip(distances[1:], gas_stations[1:n-1]):
    temp = temp if temp < station else station
    answer += temp * distance
print(answer)

