def solution(s):
    answer = 1
    cnt = [1, 0] # x인 숫자, x가 아닌 숫자
    x = s[0]
    for idx in range(1, len(s)-1):
        if x == s[idx]:
            cnt[0] += 1
        else:
            cnt[1] += 1
        if cnt[0] == cnt[1]:
            answer += 1
            x = s[idx + 1]
            cnt = [0, 0]
    return answer