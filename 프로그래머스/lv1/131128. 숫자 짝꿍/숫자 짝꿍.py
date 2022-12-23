def solution(X, Y):
    answer = ''
    X_dict = {}
    for num in X:
        if X_dict.get(num) != None:
            X_dict[num] += 1
        else:
            X_dict[num] = 1
            
    numbers_cnt = [0] * 3000001
    max_value = -1
    for num in Y:
        if X_dict.get(num) != None:
            X_dict[num] -= 1
            if X_dict[num] == 0:
                X_dict.pop(num)
            numbers_cnt[int(num)] += 1
            max_value = int(num) if int(num) > max_value else max_value
    if max_value == 0:
        return '0'
    for idx in range(max_value, -1, -1):
        answer += (str(idx)) * numbers_cnt[idx]
        
    return answer if answer != '' else '-1'