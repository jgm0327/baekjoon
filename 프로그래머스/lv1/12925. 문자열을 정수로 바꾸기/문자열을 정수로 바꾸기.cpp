#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(string s) {
    int answer = 0, digit = 1, start = 0;
    string str = "";
    bool minus = false;
    if(s[0] == '-'){
        start = 1;
        minus = true;
    }
    for(int i=start ; i<s.size() ; i++)str += s[i];
    answer = stoi(str);
    return minus ? -1 * answer : answer;
}