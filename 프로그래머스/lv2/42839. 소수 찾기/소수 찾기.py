def find_primes() -> dict:
    primes = {}
    is_primes = [False, False] + [True] * 9999999
    
    for i in range(2, 10000000):
        if is_primes[i]:
            primes[i] = 1
            for i in range(i+i, 10000000, i):
                is_primes[i] = False
    return primes

primes = find_primes()
answer = 0
visit = []

def recur(numbers, depth, path, n):
    global primes, answer, visit
    if depth == n:
        temp = int(''.join(path))
        if primes.get(temp) == 1:
            answer += 1
            primes.pop(temp)
        return
    
    for i in range(n):
        if visit[i]:
            continue
        path.append(numbers[i])
        visit[i] = True
        temp = int(''.join(path))
        if primes.get(temp) == 1:
            primes.pop(temp)
            answer += 1
        recur(numbers, depth+1, path, n)
        path.pop()
        visit[i] = False
        
def solution(numbers):
    global visit, answer
    numbers = list(numbers)
    n = len(numbers)
    visit = [False]*n
    recur(numbers, 0, [], n)
    return answer