from collections import defaultdict

def solution(clothes):
    answer = 1
    cloth_list = defaultdict(list)
    
    for cloth in clothes:
        name, kind = cloth
        cloth_list[kind].append(name)
    
    for value in cloth_list.values():
        answer *= (len(value) + 1)
    
    return answer - 1