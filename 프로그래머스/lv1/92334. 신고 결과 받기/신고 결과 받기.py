def solution(id_list, report, k):
    answer = []
    histories = {}
    report_cnt = {}.fromkeys(id_list, 0)
    for name in id_list:
        histories[name] = dict()
        
    for data in report:
        sour, des = data.split()
        if histories[sour].get(des) is not None:
            continue
        report_cnt[des] += 1
        histories[sour][des] = True
        
    for re in id_list:
        cnt = 0
        for key in histories[re].keys():
            if report_cnt[key] >= k:
                cnt += 1
        answer.append(cnt)
        
    return answer