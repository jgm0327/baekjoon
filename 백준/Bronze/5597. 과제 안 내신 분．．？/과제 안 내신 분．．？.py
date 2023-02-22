stu = {}.fromkeys([str(data) for data in range(1, 31)], True)
for _ in range(28):
    stu.pop(input())
print('\n'.join(stu.keys()))
