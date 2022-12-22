#include <string>
#include <vector>
#include <unordered_map>
#include <iostream>

using namespace std;

int solution(vector<string> babbling) {
    int answer = 0, cnt = 1;
    unordered_map<string, bool> words = {{"aya", true},
                                         {"ye", true},
                                         {"woo", true},
                                         {"ma", true}};
    
    unordered_map<string, int> order = {{"aya", -1},
                                         {"ye", -1},
                                         {"woo", -1},
                                         {"ma", -1}};
    string str = "";
    bool flag = true;
    for(string paragraph : babbling){
        str = "";
        cnt = 0;
        order = {{"aya", -1},
                                         {"ye", -1},
                                         {"woo", -1},
                                         {"ma", -1}};
        for(int i=0 ; i<paragraph.size() ; i++){
            str += paragraph[i];
            flag = false;
            if(words.find(str) != words.end()){
                if(order[str] == cnt)break;
                order[str] = ++cnt;
                flag = true;
                str = "";
            }
        }
        if(flag)answer++;
    }
    
    return answer;
}