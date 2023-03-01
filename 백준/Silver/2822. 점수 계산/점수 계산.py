scores = []
for i in range(1, 9):
    scores.append([int(input()), str(i)])
scores.sort(reverse=True)
print(sum([data[0] for data in scores[:5]]))
print(' '.join(sorted([data[1] for data in scores[:5]])))
