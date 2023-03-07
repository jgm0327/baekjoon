n = int(input())
for i in range(n):
    print(' '*(n-i-1), end='*'*(i+1)+'\n')
for i in range(n-1,0,-1):
    print(' '*(n-i), end='*'*i+'\n')
    
