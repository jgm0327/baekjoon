#include <string>
#include <vector>
#include <unordered_map>

using namespace std;


vector<int> solution(vector<int> lottos, vector<int> win_nums) {
    vector<int> answer;
    int zero_cnt = 0, correct = 0, min = 7, max=0;
    int rank[7] = {6, 6, 5, 4, 3, 2, 1};
    unordered_map<int, bool> win;
    
    for(int i=0 ; i<6 ; i++){
        win.insert({win_nums[i], true});
    }
    
    for(int i=0 ; i<6 ; i++){
        if(win.find(lottos[i]) != win.end())correct++;
        if(lottos[i] == 0) zero_cnt++;
    }
    
    answer = {rank[correct+zero_cnt], rank[correct]};
    
    return answer;
}