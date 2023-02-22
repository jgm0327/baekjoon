map(int, input().split())
A = set(map(int, input().split()))
B = set(map(int, input().split()))
print(len(B.difference(A)) + len(A.difference(B)))

