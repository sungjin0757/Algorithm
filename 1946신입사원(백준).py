import sys
#sys.stdin=open("input.txt","rt")
t=int(input())

for i in range(t):
    tmp=int(input())
    a=sorted([list(map(int,sys.stdin.readline().strip().split())) for _ in range(tmp)],key=lambda x:x[0])
    winner=a[0][1]
    cnt=1
    
    for j in range(1,tmp):
        if a[j][1]<winner:
            winner=a[j][1]
            cnt+=1

        
    
    print(cnt)

