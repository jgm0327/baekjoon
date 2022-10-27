import sys
from collections import defaultdict

T = int(sys.stdin.readline())

for _ in range(T):
    n = int(sys.stdin.readline())
    phone_numbers = []
    for i in range(n):
        phone_numbers.append(sys.stdin.readline().rstrip())

    phone_number_dict = defaultdict(bool)
    phone_numbers.sort(key=lambda x: len(x))
    flag = False
    for phone_number in phone_numbers:
        temp = ''
        for i in range(len(phone_number)):
            temp += phone_number[i]
            if phone_number_dict[temp]:
                flag = True
                break
        if flag:
            break
        phone_number_dict[phone_number] = True

    if flag:
        print('NO')
    else:
        print('YES')
