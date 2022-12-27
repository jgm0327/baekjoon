from collections import defaultdict

def solution(want, number, discount):
    answer = 0
    want_count = defaultdict(int)
    n = len(discount)
    m = len(want)
    for idx, product in enumerate(want):
        want_count[product] = number[idx]
        
    for i in range(n - 9):
        cnt = 0
        dis_count = defaultdict(int)
        for product in discount[i:i+10]:
            dis_count[product] += 1
            if want_count[product] == dis_count[product]:
                cnt += 1
            if cnt == m:
                break
        if cnt == m:
            answer += 1
            
    return answer