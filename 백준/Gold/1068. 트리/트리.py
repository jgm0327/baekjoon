n = int(input())

child = [[] for _ in range(n)]
tree = list(map(int, input().split(' ')))
root = 0

for des, sour in enumerate(tree):
    if sour == -1:
        root = des
        continue
    child[sour].append(des)

remove_node_num = int(input())
answer = 0
visit = [False] * n


def dfs(_parent):
    global child, remove_node_num, answer, visit

    visit[_parent] = True
    if _parent == remove_node_num:
        return

    if (len(child[_parent]) == 1 and remove_node_num == child[_parent][0])\
    or len(child[_parent]) == 0:
        answer += 1
        return
    
    for _child in child[_parent]:
        if visit[_child]:
            continue
        dfs(_child)


dfs(root)
print(answer)
