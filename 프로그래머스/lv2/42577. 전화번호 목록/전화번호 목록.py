from collections import defaultdict

def solution(phone_book):
    phone_book.sort(key = lambda x: len(x))
    phone_dict = defaultdict(int)
    
    for i in range(len(phone_book)):
        temp = ''
        for j in range(len(phone_book[i])):
            temp += phone_book[i][j]
            if phone_dict[temp]:
                return False
        phone_dict[phone_book[i]] = 1
    return True