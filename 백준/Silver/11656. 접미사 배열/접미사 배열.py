s = input().rstrip()
str_list = []
for i in range(len(s)):
    str_list.append(s[i:])
print('\n'.join(sorted(str_list)))

