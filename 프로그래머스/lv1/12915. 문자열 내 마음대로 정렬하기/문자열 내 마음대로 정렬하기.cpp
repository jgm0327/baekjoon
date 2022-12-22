#include <string>
#include <vector>
#include <algorithm>

using namespace std;
int N;
bool compare(const string &a, const string &b){
    if(a[N] == b[N]){
        return a < b;
    }
    return a[N] < b[N];
}

vector<string> solution(vector<string> strings, int n) {
    N = n;
    vector<string> answer;
    sort(strings.begin(), strings.end(), compare);
    return strings;
}