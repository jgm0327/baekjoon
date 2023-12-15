from collections import deque

n = int(input())

SCV = list(map(int, input().split()))
substract = [9, 3, 1]

def make_key(_list):
    return ' '.join([str(hp) for hp in _list])


def remain_hp(scv):
    global n
    
    ret = 0

    for hp in scv[:n]:
        if hp <= 0:
            ret += 1

    return ret == n


def permutation(depth, que, _visit, scv):
    global n, answer, substract, visit
    
    if depth == n:
        if remain_hp(scv):
            answer = min(answer, scv[-1] + 1)
            return

        key = make_key(scv[:n])
        
        if visit.get(key) is not None:
            return

        visit[key] = True
        que.append(scv[:n] + [scv[-1] + 1])


    for i in range(n):
        if _visit[i]:
            continue
        
        _visit[i] = True
        scv[i] -= substract[depth]
        permutation(depth + 1, que, _visit, scv)
        scv[i] += substract[depth]
        _visit[i] = False


def bfs():
    global SCV, n, visit

    que = deque()
    que.append(SCV + [0])

    visit[make_key(SCV)] = True

    while que:
        scv = que.popleft()
        
        permutation(0, que, [False] * n, scv)


visit = {}
answer = 100
bfs()

print(answer)
