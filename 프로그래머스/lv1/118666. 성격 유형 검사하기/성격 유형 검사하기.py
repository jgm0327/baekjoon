def solution(survey, choices):
    answer = ''
    chart_cnt = {}.fromkeys(['R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'], 0)
    chart = [['R', 'T'], ['C', 'F'], ['J', 'M'], ['A', 'N']]
    
    for i in range(len(survey)):
        left, right = survey[i][0], survey[i][1]
        if 1 <= choices[i] <= 3:
            chart_cnt[left] += (4 - choices[i])
        elif 5 <= choices[i] <= 7:
            chart_cnt[right] += (choices[i] - 4)
    
    for elem in chart:
        left, right = elem[0], elem[1]
        if chart_cnt[left] > chart_cnt[right] or chart_cnt[left] == chart_cnt[right]:
            answer += left
        else:
            answer += right
    return answer