def correct_order(s: list) -> bool:
    stack = []

    for pat in s:
        if pat in ['(', '[', '{']:
            stack.append(pat)
        elif pat in [')', ']', '}']:
            if not stack:
                return False
            if pat == ')' and stack[-1] == '(':
                stack.pop()
            if pat == ']' and stack[-1] == '[':
                stack.pop()
            if pat == '}' and stack[-1] == '{':
                stack.pop()
                
    if len(stack):
        return False
    return True

def solution(s):
    answer = 0
    s = list(s)
    n = len(s)
    for i in range(n):
        if correct_order(s):
            answer += 1
        s = s[1:] + s[0:1]
    
    return answer