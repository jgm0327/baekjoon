n, k = map(int, input().split())
num_list = list(input().rstrip().split())
answer = 0
digit = len(str(n))

def recur(depth: int, number: list):
    global digit, num_list, k, answer
    value = int(''.join(number)) if number else 0
    if answer < value <= n:
        answer = value
    if depth == digit:
        return
    
    for num in num_list:
        number.append(num)
        recur(depth + 1, number)
        number.pop()

recur(0, [])
print(answer)
