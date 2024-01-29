n, r, c = map(int, input().split())

answer = 0

size = 2 ** n

while size > 0:

    size //= 2

    if r < size and c >= size:
        answer += size * size
        c -= size

    elif r >= size and c < size:
        answer += size * size * 2
        r -= size

    elif r >= size and c >= size:
        answer += size * size * 3
        r -= size
        c -= size

print(answer)

