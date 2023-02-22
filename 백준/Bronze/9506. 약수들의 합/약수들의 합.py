while True:
    n = int(input())
    if n == -1:
        break
    arr = []
    total = 0
    for i in range(1, n):
        if n % i == 0:
            arr.append(str(i))
            total += i
    print('%d' % n, end=' ')
    if total == n:
        print('= %s' % ' + '.join(arr))
    else:
        print('is NOT perfect.')
