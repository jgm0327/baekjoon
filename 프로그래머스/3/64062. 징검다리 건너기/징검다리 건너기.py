def solution(stones, k):
    answer = 0
    
    left, right = 0, 2 * int(1e8)
    
    while left <= right:
        mid = (left + right) // 2
        cnt = 0
        can = True
        
        for stone in stones:
            if stone < mid:
                cnt += 1
            else:
                cnt = 0
                
            if cnt == k:
                can = False
                break
                
        if can:
            left = mid + 1
            answer = max(answer, mid)
        else:
            right = mid - 1
    return answer