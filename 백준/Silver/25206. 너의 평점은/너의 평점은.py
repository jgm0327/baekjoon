grades = {'A+':4.5, 'A0':4.0, 'B+':3.5, 'B0':3.0, 'C+':2.5, 'C0':2.0, 'D+':1.5, 'D0':1.0, 'F': 0.0}
result = total_score = 0 
for name, score, grade in list(input().split() for _ in range(20)):
    if grade == 'P':
        continue
    total_score += float(score)
    result += (float(score) * grades[grade])
print('%f' % (result / total_score))
