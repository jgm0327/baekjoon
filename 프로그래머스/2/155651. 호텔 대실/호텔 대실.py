def solution(book_time):
    rooms = []
    times = []
    for time in book_time:
        start_time = time[0].split(":")
        end_time = time[1].split(":")
        
        start = int(start_time[0]) * 60 + int(start_time[1])
        end = int(end_time[0]) * 60 + int(end_time[1])
        
        times.append([start, end])
    
    times.sort(key=lambda x:[x[0], x[1]]) 
    
    for time in times:
        cant_reservation = True
        
        for i in range(len(rooms)):
            if rooms[i] <= time[0]:
                cant_reservation = False
                rooms[i] = time[1] + 10
                break
            
        if cant_reservation:
            rooms.append(time[1] + 10)
            
    print(rooms)
    return len(rooms)