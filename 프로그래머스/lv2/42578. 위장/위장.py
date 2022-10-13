def solution(clothes):
    answer = 1
    cloth_dic = dict()
    
    for cloth in clothes:
        name, kind = cloth
        if cloth_dic.get(kind) == None:
            cloth_dic[kind] = [name]
        else:
            cloth_dic[kind].append(name)
        
    for key in cloth_dic.keys():
        answer *= (len(cloth_dic[key]) + 1)
        
    
    return answer - 1