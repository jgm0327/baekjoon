from sys import stdin

wrong = stdin.readline()
right = stdin.readline()
comp = ''.join(ch if not('0' <= ch <= '9') else '' for ch in wrong)
print(1 if comp.count(right) >= 1 else 0)