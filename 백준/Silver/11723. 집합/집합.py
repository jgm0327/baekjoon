from sys import stdin

numbers = {}
for _ in range(int(input())):
    data = stdin.readline().rstrip().split()
    if len(data) == 2:
        command, num = data[0], int(data[1])
        if command == 'add':
            numbers[num] = True
        elif command == 'remove' and numbers.get(num) is not None:
            numbers.pop(num)
        elif command == 'check':
            print(1 if numbers.get(num) is not None else 0)
        elif command == 'toggle':
            if numbers.get(num) is not None:
                numbers.pop(num)
            else:
                numbers[num] = True
    else:
        if data[0] == 'all':
            numbers = {}.fromkeys([data for data in range(1, 21)], True)
        else:
            numbers = {}
            

