n = int(input())
num, oper = [], []
number = {}
data = input().rstrip()
for i in range(n):
    number[chr(ord('A') + i)] = int(input())

for ch in data:
    if 'A' <= ch <= 'Z':
        num.append(number[ch])
    else:
        b, a = num.pop(), num.pop()
        value = 0
        if ch == '*':
            value = a * b
        elif ch == '/':
            value = a / b
        elif ch == '-':
            value = a - b
        else:
            value = a + b
        num.append(value)
print('{:.2f}'.format(num[0]))
