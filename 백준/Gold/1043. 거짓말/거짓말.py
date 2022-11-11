import sys
from collections import defaultdict

input = sys.stdin
n, m = map(int, input.readline().split())
num_list = list(map(int, input.readline().split()))
know_people = defaultdict(bool)
for num in num_list[1:]:
    know_people[num] = True
parents = [i for i in range(51)]
answer = m


def find(x):
    global parents
    if x == parents[x]:
        return x
    parents[x] = find(parents[x])
    return parents[x]


def union(y, x):
    global parents, know_people
    y = find(y)
    x = find(x)

    if y == x:
        return
    if know_people[x]:
        y, x = x, y
        know_people[x] = True
    parents[x] = y


party_people = []
for i in range(m):
    party_people.append(list(map(int, input.readline().split())))
    for j in range(1, party_people[i][0]):
        union(party_people[i][j], party_people[i][j+1])

for party in party_people:
    for person in party[1:]:
        parent = find(person)
        if know_people[parents[parent]]:
            answer -= 1
            break
print(answer)
