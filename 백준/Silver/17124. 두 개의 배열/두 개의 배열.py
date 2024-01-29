import sys

input = sys.stdin.readline


def binary_search(target, b):
    left, right = 0, len(b) - 1

    while left <= right:
        mid = (left + right) // 2
        
        if target == b[mid]:
            return b[mid]
                    
        if b[mid] > target:
            right = mid - 1
            
        elif b[mid] < target:
            left = mid + 1

    left = left if left < len(b) else left - 1
    right = right if right >= 0 else right + 1

    if abs(b[left] - target) == abs(b[right] - target):
        return b[left] if left < right else b[right]

    return b[left] if abs(b[left] - target) <= abs(b[right] - target) else b[right]


for _ in range(int(input())):
    n, m = map(int, input().split())

    a = list(map(int, input().split()))
    b = sorted(list(map(int, input().split())))

    answer = 0
    for target in a:
        answer += binary_search(target, b)
    print(answer)
