def bfs(begin, target, words):
    que = [[begin, 0, 0]] # 시작단어, 바꿀 위치, 바꾼 횟수
    n = len(begin)
    
    while que:
        cur_word, start_idx, cur_cnt = que.pop(0)
        for i in range(26):
            next_alpha = chr(ord('a') + i)
            for next_idx in range(0, n):
                temp = [data for data in cur_word]
                temp[next_idx] = next_alpha
                next_word = ''.join(temp)
                if words.get(next_word):
                    words.pop(next_word)
                    if target == next_word:
                        return cur_cnt + 1
                    que.append([temp, next_idx, cur_cnt + 1])
                
                
    return 0

def solution(begin, target, words):
    begin = list(begin)
    word_dict = dict.fromkeys(words, 1)
    answer = bfs(begin, target, word_dict)
    return answer