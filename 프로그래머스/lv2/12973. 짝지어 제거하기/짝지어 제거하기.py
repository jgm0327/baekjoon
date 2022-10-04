def solution(s):
    answer = 0
    stack = [s[0]]
    
    for i in range(1, len(s)):
        if len(stack) > 0 and stack[-1] == s[i]:
            stack.pop()
        else:
            stack.append(s[i])
            
    answer = 0 if len(stack) else 1
        
    return answer