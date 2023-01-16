def solution(skill, skill_trees):
    answer = 0
    skill_ord = {}
    for i in range(len(skill)):
        skill_ord[skill[i]] = i
    
    for skill_tree in skill_trees:
        order = -1
        flag = True
        for ch in skill_tree:
            if skill_ord.get(ch) is not None:
                if order + 1 != skill_ord[ch]:
                    flag=False
                    break
                order += 1
        if flag:
            answer += 1
            
                    
    
    return answer