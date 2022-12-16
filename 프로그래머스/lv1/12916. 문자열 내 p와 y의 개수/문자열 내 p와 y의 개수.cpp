#include <string>
#include <iostream>
using namespace std;

bool solution(string s)
{
    int y_cnt = 0, p_cnt = 0;
    for(int i=0 ; i<s.size() ; i++){
        if(s[i] == 'p' || s[i] == 'P')p_cnt++;
        else if(s[i] == 'y' || s[i] == 'Y')y_cnt++;
    }
    if(y_cnt == p_cnt)return true;
    return false;
}