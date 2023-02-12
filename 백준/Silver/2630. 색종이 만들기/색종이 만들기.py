from sys import stdin, setrecursionlimit

n = int(stdin.readline())
color_paper = [list(map(int, stdin.readline().split())) for _ in range(n)]
answer = [0, 0]

def check_color(start_y: int, start_x: int, size: int) -> bool:
    global n, color_paper
    
    return True


def divide_conquer(start_y: int, start_x: int, size: int):
    global color_paper, n
    color = color_paper[start_y][start_x]
    for y in range(start_y, start_y + size):
        for x in range(start_x, start_x + size):
            if color_paper[y][x] != color:
                size //= 2
                divide_conquer(start_y, start_x, size)
                divide_conquer(start_y, start_x + size, size)
                divide_conquer(start_y + size, start_x, size)
                divide_conquer(start_y + size, start_x + size, size)
                return
    answer[color] += 1


divide_conquer(0, 0, n)
print(answer[0])
print(answer[1])
