#include <vector>
#include <iostream>
#include <unordered_map>

using namespace std;

unordered_map<int, bool> primes;
bool is_prime[3001], visit[3001];
int len, answer;

void find_primes(){
    for(int i=2 ; i<3001 ; i++){
        if(!is_prime[i])continue;
        primes.insert(make_pair(i, true));
        for(int j=i ; j<3001 ; j += i){
            is_prime[j] = false;
        }
    }
}

void recur(int depth, int sum ,vector<int> nums, int start){
    if(depth == 3){
        if(primes.find(sum) != primes.end())answer++;
        return;
    }
    for(int i=start ; i<len ; i++){
        if(visit[nums[i]])continue;
        sum += nums[i];
        visit[nums[i]] = true;
        recur(depth+1, sum, nums, i + 1);
        sum -= nums[i];
        visit[nums[i]] = false;
    }
}

int solution(vector<int> nums) {
    len = nums.size();
    fill_n(is_prime, 3001, true);
    find_primes();
    recur(0, 0, nums, 0);
    
    return answer;
}