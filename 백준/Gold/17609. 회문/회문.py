from sys import stdin

n = int(stdin.readline())
words = [stdin.readline().rstrip() for _ in range(n)]

for word in words:
    if word == word[::-1]:
        print(0)
        continue

    m = len(word)
    start, end = 0, m - 1
    flag = False
    while start < end:
        if word[start] != word[end]:
            if end - start == 1:
                flag = True
            if start + 1 < end:
                tmp = word[:start] + word[start + 1:]
                if tmp[::-1] == tmp[:]:
                    flag = True
            if end - 1 > start:
                tmp = word[:end] + word[end + 1:]
                if tmp[::-1] == tmp[:]:
                    flag = True
            break
        else:
            start += 1
            end -= 1

    if flag:
        print(1)
        continue
    print(2)
