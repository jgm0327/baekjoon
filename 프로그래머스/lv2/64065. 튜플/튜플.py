def solution(s):
    answer = []
    s = s.split('}')
    s = ''.join(s).split('{')
    s.sort(key=lambda x: len(x))
    num_dic = dict()
    
    for numbers in s:
        idx = 0
        n = len(numbers)
        while idx < n:
            number = ''
            while idx < n and '0' <= numbers[idx] <= '9':
                number += numbers[idx]
                idx += 1
            if number != '' and num_dic.get(number) == None:
                answer.append(int(number))
                num_dic[number] = 1
            idx += 1
    
    return answer