def solution(participant, completion):
    players = dict()
    for player in participant:
        if players.get(player) == None:
            players[player] = 1
        else:
            players[player] += 1
            
    for player in completion:
        players[player] -= 1
        if players[player] == 0:
            players.pop(player)
    
    return ''.join(list(players.keys()))