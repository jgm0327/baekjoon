#include <iostream>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int T, data;
	long long* arr;
	cin >> T;
	arr = (long long*)malloc(sizeof(long long) * (T+1));
	arr[1] = 1; arr[2] = 1; arr[3] = 1; arr[4] = 2;
	for (int i = 0; i < T; i++) {
		cin >> data;
		for (int i = 5; i <= data; i++) {
			arr[i] = arr[i - 3] + arr[i - 2];
		}
		cout << arr[data] << endl;
	}
}