from collections import defaultdict


def solution(cacheSize, cities):
    answer = 0
    cache = defaultdict(int) # 도시가 들어온 순서 저장
    if cacheSize == 0:
        return 5 * len(cities)
    for idx, city in enumerate(cities):
        city = city.lower()
        if len(cache) < cacheSize:
            if cache.get(city) != None:
                answer += 1
            else:
                answer += 5
            cache[city] = idx
        else:
            if cache.get(city) != None:
                answer += 1
                cache[city] = idx
            else:
                answer += 5
                keys = cache.keys()
                min_value = 100001
                delete_key = ''
                for key in keys:
                    if min_value > cache[key]:
                        delete_key = key
                        min_value = cache[key]
                cache.pop(delete_key)
                cache[city] = idx
                
    return answer