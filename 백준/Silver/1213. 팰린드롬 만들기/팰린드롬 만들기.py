import sys

alphabet = {}.fromkeys([chr(ord('A') + i) for i in range(26)], 0)
paragraph = sys.stdin.readline().rstrip('\n')
n = len(paragraph)
result = [''] * 51

for ch in paragraph:
    alphabet[ch] += 1

if n % 2:
    flag = True
    for key in alphabet.keys():
        if alphabet[key] % 2:
            result[n // 2] = key
            alphabet[key] -= 1
            break

    if alphabet[result[n // 2]] == 0:
        alphabet.pop(result[n // 2])

idx = 0
for key in alphabet.keys():
    if alphabet[key] % 2:
        print('I\'m Sorry Hansoo')
        exit(0)
    while idx < n // 2 and alphabet[key] > 0:
        result[idx] = result[-idx - 1] = key
        alphabet[key] -= 2
        idx += 1

print(''.join(result))
