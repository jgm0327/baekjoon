#include <iostream>
#include <queue>

using namespace std;

int vertex_num, edge_num, start_vertex, edge[1001][1001];

void DFS(int start_vertex, int visit[1001]) {
	cout << start_vertex << ' ';
	visit[start_vertex] = 1;
	for (int i = 1; i <= vertex_num; i++) {
		if (!visit[i] && edge[start_vertex][i]) {
			DFS(i, visit);
		}
	}
}

void BFS(int start_vertex) {
	int visit[1001] = { 0, }, v;
	queue<int> vertex;

	vertex.push(start_vertex);
	visit[start_vertex] = 1;
	while (!vertex.empty()) {
		v = vertex.front();
		vertex.pop();
		cout << v << ' ';
		for (int i = 1; i <= vertex_num; i++) {
			if (!visit[i] && edge[v][i]) {
				vertex.push(i);
				visit[i] = 1;
			}
		}
	}
}

void solution() {
	int sour, des, visit[1001] = { 0, };
	
	cin >> vertex_num >> edge_num >> start_vertex;

	for (int i = 0; i < edge_num; i++) {
		cin >> sour >> des;
		edge[sour][des] = edge[des][sour] = 1;
	}
	DFS(start_vertex, visit);
	cout << '\n';
	BFS(start_vertex);
}

int main(void) {
	ios_base::sync_with_stdio(false); cin.tie(NULL);
	solution();
}