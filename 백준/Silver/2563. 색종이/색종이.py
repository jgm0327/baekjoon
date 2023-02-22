n = int(input())

board = [[0] * 101 for _ in range(101)]
answer = 0
for y, x in list(map(int, input().split()) for _ in range(n)):
    for i in range(y, y+10):
        for j in range(x, x+10):
            if not board[i][j]:
                board[i][j] = 1
                answer += 1
print(answer)
                
