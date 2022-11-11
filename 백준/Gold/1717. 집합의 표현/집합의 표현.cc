#include <iostream>
#include <vector>
 
using namespace std;

class Disjoint {
public:
	vector<int> rank, parent;
	Disjoint(int n) :rank(n + 1), parent(n + 1) {
		for (int i = 0; i < parent.size(); i++)parent[i] = i;
		for (int i = 0; i < rank.size(); i++)rank[i] = 1;
	}

	int find(int x) {
		if (x == parent[x])return x;
		else {
			return parent[x] = find(parent[x]);
		}
	}

	void Union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x == y)return;
		if (rank[x] > rank[y]) {
			parent[y] = x;
			rank[x] += rank[y];
		}
		else {
			parent[x] = y;
			rank[y] += rank[x];
		}
	}

};

void solution() {
	int n, m, a, b, order;
	cin >> n >> m;
	Disjoint dis = Disjoint(n);
	while (m--) {
		cin >> order >> a >> b;
		if (order) {
			if (dis.find(a) == dis.find(b))cout << "YES\n";
			else cout << "NO\n";
		}
		else {
			dis.Union(a, b);
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	solution();
}