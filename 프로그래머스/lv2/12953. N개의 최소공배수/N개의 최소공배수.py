from collections import defaultdict

def primes_():
    primes = defaultdict(bool)
    is_prime = [False, False] + [True] * 100
    
    for i in range(2, 101):
        if is_prime[i]:
            primes[i]=True
        for j in range(i, 101, i):
            is_prime[j] = False
    return primes

def prime_factorization(number, primes, number_dict):
    for prime in primes.keys():
        if prime > number:
            break
        cnt = 0
        while number % prime == 0:
            number //= prime
            cnt += 1
        if cnt:
            number_dict[prime] = number_dict[prime] \
            if number_dict[prime] > cnt else cnt

def solution(arr):
    answer = 1
    primes = primes_()
    number_dict = defaultdict(int)
    
    for number in arr:
        prime_factorization(number, primes, number_dict)
    
    for key in number_dict.keys():
        answer *= (key ** number_dict[key])
    
    return answer
