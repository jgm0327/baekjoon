def solution(number, k):
    stack = []
    K = k
    n = len(number)
    for num in number:
        while K > 0 and stack and stack[-1] < num:
            stack.pop()
            K -= 1
        stack.append(num)
    return ''.join(stack[:n-k])