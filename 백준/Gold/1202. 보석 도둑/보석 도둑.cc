#include <iostream>
#include <utility>
#include <algorithm>
#include <queue>
#include <vector>

using namespace std;

int n, k, m;
pair<int, int> jewelry;
vector<pair<int, int>> jew;
vector<int> pack;

void input() {
    cin >> n >> k;
    for (int i = 0; i < n; i++) {
        cin >> jewelry.first >> jewelry.second;
        jew.push_back(jewelry);
    }
    for (int i = 0; i < k; i++) {
        cin >> m;
        pack.push_back(m);
    }
}

void answer() {
    priority_queue<int> pque;
    int idx = 0;
    long long sum = 0;
    sort(jew.begin(), jew.end());
    sort(pack.begin(), pack.end());
    for (int i = 0; i < k; i++) {
        while (idx < n && jew[idx].first <= pack[i]) pque.push(jew[idx++].second);
        if (!pque.empty()) {
            sum += pque.top(); pque.pop();
        }
    }
    cout << sum;
}

int main() {
    ios_base::sync_with_stdio(false); cin.tie(NULL);
    input();
    answer();
}