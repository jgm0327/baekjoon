import sys

input = sys.stdin.readline
sys.setrecursionlimit(int(1e6))

n, r, q = map(int, input().split())

tree = [[] for _ in range(n + 1)]

for parent, child in [map(int, input().split()) for _ in range(n - 1)]:
    tree[parent].append(child)
    tree[child].append(parent)

visit = [0] * (n + 1)
dp = [0] * (n + 1)

def dfs(parent):
    global tree, visit, dp

    if visit[parent]:
        return

    dp[parent] += 1
    visit[parent] = True
    
    for child in tree[parent]:
        if visit[child]:
            continue
        
        dfs(child)
        dp[parent] += dp[child]


dfs(r)

for q in [int(input()) for _ in range(q)]:
    print(dp[q])
