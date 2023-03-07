n = input().rstrip()
digit = 1
answer = 0
for ch in n[::-1]:
    num = int(ch) if '0' <= ch <= '9' else ord(ch) - ord('A') + 10
    answer += digit * num
    digit *= 16
print(answer)
