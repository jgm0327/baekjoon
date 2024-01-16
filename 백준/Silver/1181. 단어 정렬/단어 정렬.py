print('\n'.join(sorted(set(input() for _ in range(int(input()))), key=lambda x: [len(x), x])))
