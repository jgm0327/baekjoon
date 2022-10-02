def solution(n, words):
    answer = [0, 0]
    word_dic = {}
    person_dic = dict.fromkeys(range(1, n+1), 0)
    person_idx = 2
    
    # 첫 번째 사람이 말한 거
    compare_word = words[0]
    word_dic[words[0]] = 1
    person_dic[1] = 1
    
    # 그 다음부터
    for word in words[1:]:
        person_dic[person_idx] += 1
        if compare_word[-1] != word[0] or word_dic.get(word) or len(word) == 1:
            answer = [person_idx, person_dic[person_idx]]
            break
        person_idx += 1
        if person_idx == (n+1):
            person_idx = 1
        compare_word = word
        word_dic[word] = 1

    return answer