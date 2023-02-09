from sys import stdin

number = stdin.readline().rstrip()
min_value = ''
max_value = ''
cnt1 = cnt2 = 0

for n in number:
    if n == 'K':
        max_value += '5' + '0' * cnt1
        min_value += ('1' + '0' * (cnt2 - 1) + '5' if cnt2 >= 1 else '5')
        cnt1 = cnt2 = 0
    else:
        cnt1 += 1
        cnt2 += 1
if cnt1:
    max_value += '1' * cnt1
if cnt2:
    min_value += '1' + '0' * (cnt2 - 1)
print(max_value)
print(min_value)
