def solution(s, n):
    answer = ''
    for ch in s:
        if ch == ' ':
            answer += ch
            continue
        answer += chr(((ord(ch) - ord('a') + n) % 26) + ord('a')) if 'a' <= ch <= 'z' else chr(((ord(ch) - ord('A') + n) % 26) + ord('A'))
    return answer