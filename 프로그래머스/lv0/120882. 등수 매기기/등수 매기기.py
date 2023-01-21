def solution(score):
    answer = []
    sum_list = sorted([sum(data) for data in score], reverse=True)
    rank = {}
    for idx, s in enumerate(sum_list):
        if rank.get(s) is not None:
            continue
        rank[s] = idx + 1
    for data in score:
        answer.append(rank[sum(data)])
    return answer