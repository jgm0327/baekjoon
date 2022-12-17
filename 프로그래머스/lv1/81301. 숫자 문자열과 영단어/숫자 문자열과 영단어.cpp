#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

int solution(string s) {
    string answer = "";
    unordered_map<string, char> numbers = {{"zero", '0'},
                                          {"one", '1'},
                                          {"two", '2'},
                                          {"three", '3'},
                                          {"four", '4'},
                                          {"five", '5'}, 
                                          {"six", '6'},
                                          {"seven", '7'},
                                          {"eight", '8'},
                                          {"nine", '9'}};
    string tmp = "";
    for(int i=0 ; i<s.size() ; i++){
        if('a' <= s[i] && s[i] <= 'z')tmp += s[i];
        if(numbers.find(tmp) != numbers.end()){
            answer += numbers[tmp];
            tmp = "";
        }
        if('0' <= s[i] && s[i] <= '9')answer += s[i];
        
    }
    return stoi(answer);
}