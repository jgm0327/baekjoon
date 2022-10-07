def solution(s):
    answer = True
    stack = []
    for parenthesis in s:
        if not stack and parenthesis == ')':
            return False
        elif parenthesis == ')':
            stack.pop()
        else:
            stack.append(parenthesis)
    if stack:
        return False
    return True