from collections import deque, defaultdict
from math import floor

def generate_list(string: str) -> defaultdict:
    ret = defaultdict(int)
    elem = deque()
    
    for ch in string:
        if 'a' <= ch <= 'z' or 'A' <= ch <= 'Z':
            elem.append(ch if 'a' <= ch <= 'z' else chr(ord(ch) + 32))
        elif elem:
            elem.popleft()
        if len(elem) == 2:
            key = ''.join(elem)
            ret[key] += 1
            elem.popleft()
    return ret

def count_set(list_: list, type_: str) -> int:
    ret = 0
    if type_ == 'u':
        for i in range(2):
            for key in list_[i].keys():
                cnt = list_[i][key]
                idx = (i + 1) % 2
                if list_[idx].get(key) != None:
                    if i == 1:
                        continue
                    cnt = max(list_[idx][key], cnt)
                ret += cnt
    
    else:
        for key in list_[0].keys():
            if list_[1].get(key) != None:
                ret += min(list_[1][key], list_[0][key])
    return ret
    
def solution(str1, str2):
    answer = 0
    set_list = [generate_list(str1), generate_list(str2)]
    union = count_set(set_list, 'u')
    intersection = count_set(set_list, 't')
    if union == 0:
        return 65536
    answer = intersection / union
    return floor(answer * 65536)