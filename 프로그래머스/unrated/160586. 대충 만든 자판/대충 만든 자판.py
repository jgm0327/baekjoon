def solution(keymap, targets):
    answer = []
    n = len(keymap)
    key = dict()
    for i in range(n):
        for j in range(len(keymap[i])):
            if key.get(keymap[i][j]) is not None and j < key[keymap[i][j]]:
                key[keymap[i][j]] = j + 1
            elif key.get(keymap[i][j]) is None:
                key[keymap[i][j]] = (j + 1)
    print(key)
    for target in targets:
        total = 0
        for ch in target:
            if key.get(ch) is None:
                total = -1
                break
            else:
                total += key[ch]
        answer.append(total)
    return answer