for _ in range(int(input())):
    n = int(input())
    clothes = {}

    for name, _type in [list(input().rstrip().split()) for i in range(n)]:
        if clothes.get(_type) is None:
            clothes[_type] = []

        clothes[_type].append(name)

    total = 1

    for _type in clothes.keys():
        total *= (len(clothes[_type]) + 1)

    print(total - 1)
