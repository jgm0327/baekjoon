s = input()
answer = {}

for i in range(1, len(s) + 1):
    for j in range(len(s)):
        answer[s[j:j+i]] = True
print(len(answer))
