def solution(prices):
    answer = []
    n = len(prices)
    for i in range(n):
        cnt = 0
        for j in range(i+1, n):
            cnt += 1
            if prices[i] > prices[j]:
                break
        answer.append(cnt)
    return answer