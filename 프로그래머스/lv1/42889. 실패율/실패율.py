from collections import defaultdict
import heapq

def solution(N, stages):
    stages_dict = defaultdict(int)
    total_dict = defaultdict(int)
    answer = []
    heapq.heapify(stages)
    
    while stages:
        stage = heapq.heappop(stages)
        stages_dict[stage] += 1
        total_dict[stage] += 1
        for key in total_dict.keys():
            if key < stage:
                total_dict[key] += 1
    
    
    rank = []
    for idx in range(1, N+1):
        data = 0 if total_dict[idx] == 0 else (stages_dict[idx] / total_dict[idx])
        heapq.heappush(rank, [-data, idx])
        
    while rank:
        data = heapq.heappop(rank)
        answer.append(data[1])
    return answer