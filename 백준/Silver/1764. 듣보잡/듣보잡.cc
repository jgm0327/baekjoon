#include <iostream>
#include <set>

using namespace std;

void solution() {
	set<string> name, exist;
	string person;
	int n, m;

	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		cin >> person;
		name.insert(person);
	}

	for (int i = 0; i < m; i++) {
		cin >> person;
		if (name.count(person) != 0)exist.insert(person);
	}
	cout << exist.size() << '\n';
	for (auto it = exist.begin(); it != exist.end(); it++)cout << *it << '\n';
}

int main(void) {
	solution();
	return 0;
}