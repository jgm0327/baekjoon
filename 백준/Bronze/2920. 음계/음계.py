data = list(map(int, input().split()))
prev = data[0]
answer = 0
for num in data[1:]:
    temp = answer
    if prev < num:
        answer = 1
    else:
        answer = -1
    if temp and temp != answer:
        answer = 0
        break
    prev = num

if answer:
    print('ascending' if answer == 1 else 'descending')
else:
    print('mixed')
