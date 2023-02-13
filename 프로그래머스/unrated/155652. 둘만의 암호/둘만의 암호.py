def solution(s, skip, index):
    answer = ''
    skip_ch = list(skip)
    for ch in s:
        cnt = idx = 1
        start = ch
        while cnt <= index:
            start = chr(ord(start) + 1) if start < 'z' else 'a'
            if start in skip_ch:
                continue
            cnt += 1
        answer += start
    return answer