from collections import defaultdict
import heapq


def solution(genres, plays):
    answer = []
    n = len(genres)
    album = defaultdict(list)
    album_cnt = defaultdict(int)
    heap = []
    
    for i in range(n):
        album[genres[i]].append([-plays[i], i])
        album_cnt[genres[i]] += plays[i]
    for key in album_cnt.keys():
        heapq.heappush(heap, [-album_cnt[key], key])
    
    while heap:
        genre = heap[0][1]
        heapq.heappop(heap)
        music = album[genre]
        heapq.heapify(music)
        
        cnt = 0
        while cnt < 2 and music:
            answer.append(music[0][1])
            heapq.heappop(music)
            cnt += 1
    
    return answer