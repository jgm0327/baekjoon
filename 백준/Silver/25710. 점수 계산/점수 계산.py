n = int(input())
energy = list(map(int, input().split()))

numbers = {}.fromkeys([i for i in range(1, 1000)], 0)

for e in energy:
    numbers[e] += 1


def sum_digit(number):
    total = 0
    
    while number:
        total += number % 10
        number //= 10

    return total


answer = 0

for i in range(1, 1000):
    if numbers[i] == 0:
        continue
    
    for j in range(1, 1000):
        if (i == j and numbers[j] <= 1) or numbers[j] == 0:
            continue
        
        answer = max(answer, sum_digit(i * j))

print(answer)
