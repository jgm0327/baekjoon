#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = 1, fac = 1;
    while(fac * answer < n){
        answer++;
        fac *= answer;
    }
    return answer;
}