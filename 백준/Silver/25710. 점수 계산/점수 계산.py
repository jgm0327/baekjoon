from sys import stdin

input = stdin.readline

n = int(input())

numbers = list(map(int, input().split()))

number_map = {}

for number in numbers:
    if number_map.get(number) is None:
        number_map[number] = 1
        continue
    number_map[number] += 1


def sum_digit_number(number):
    total = 0

    while number > 0:
        total += number % 10
        number //= 10

    return total


answer = 0
for i in range(1, 1000):
    if number_map.get(i) is None:
        continue
    
    for j in range(1, 1000):
        if number_map.get(j) is None or (i == j and number_map[i] < 2):
            continue
        
        answer = max(answer, sum_digit_number(i * j))
        
print(answer)
