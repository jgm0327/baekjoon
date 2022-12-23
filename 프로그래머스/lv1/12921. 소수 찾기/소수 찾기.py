def find_prime() -> list:
    primes = []
    is_prime = [False, False] + [True] * 999999

    
    for i in range(2, 1000001):
        if not is_prime[i]:
            continue
        primes.append(i)
        for j in range(i, 1000001, i):
            is_prime[j] = False
    return primes
    
def solution(n):
    answer = 0
    primes = find_prime()
    for prime in primes:
        if prime > n:
            break
        answer += 1
    return answer