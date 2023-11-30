from sys import stdin

input = stdin.readline

T = int(input())

MBTI_type = ('ISTJ', 'ISFJ', 'INFJ', 'INTJ', 'ISTP', 'ISFP', 'INFP', 'INTP', 'ESTP', 'ESFP', 'ENFP', 'ENTP', 'ESTJ', 'ESFJ', 'ENFJ', 'ENTJ')


def diff_MBTI(mbti1, mbti2):
    ret = 0
    
    for i in range(4):
        if mbti1[i] == mbti2[i]:
            continue
        ret += 1
        
    return ret


for _ in range(T):
    n = int(input())
    MBTI = list(input().split())

    MBTI_map = {}

    for data in MBTI:
        if MBTI_map.get(data) is None:
            MBTI_map[data] = 1
            continue
        
        MBTI_map[data] += 1


    total = 100
    mbti_count = dict.fromkeys(MBTI_type, 0)
    
    for mbti1 in MBTI_type:
        if MBTI_map.get(mbti1) is None:
            continue
        
        mbti_count[mbti1] += 1
        
        for mbti2 in MBTI_type:
            if MBTI_map.get(mbti2) is None or MBTI_map.get(mbti2) < (mbti_count[mbti2] + 1):
                continue

            mbti_count[mbti2] += 1
            
            for mbti3 in MBTI_type:
                if MBTI_map.get(mbti3) is None or MBTI_map.get(mbti3) < (mbti_count[mbti3] + 1):
                    continue

                total = min(total, diff_MBTI(mbti1, mbti2) + diff_MBTI(mbti2, mbti3) + diff_MBTI(mbti1, mbti3))
                
            mbti_count[mbti2] -= 1
            
        mbti_count[mbti1] -= 1

    print(total)
