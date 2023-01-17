import sys

input = sys.stdin

n = int(input.readline())
card_dict = {}.fromkeys(list(map(int, input.readline().split())), True)
m = int(input.readline())
for card in list(map(int, input.readline().split())):
    print(1 if card_dict.get(card) is not None else 0, end=' ')
