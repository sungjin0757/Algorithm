import sys
sys.stdin=open("input.txt","rt")
from collections import deque

t=int(input())


for _ in range(t):
    case=int(input())
    dq=deque()
    dq.append(1)
 
    res=0
    flag=False
    visit=[0]*22000
    while dq:
        if res!=0:
            break    
        if flag==True:
            break
        size=len(dq)
        for i in range(size):
            tmp=dq.popleft()
            if visit[tmp%case]==1:
                continue
            if len(str(tmp))==1:
                if tmp%case==0:
                    res=tmp
            else:
                if tmp%case==0:
                    res=tmp
                
            if len(str(tmp))>100:
                flag=True
                break
            if case%2==0 or case%5==0:
                if len(str(tmp))<=1:
                    dq.append(tmp*10)
                else:
                    
                    dq.append(tmp*10)
                    dq.append(tmp*10+10)
            else:
                if len(str(tmp))<=1:
                    dq.append(tmp*10+1)
                else:
                    dq.append(tmp*10+1)
                    dq.append(tmp*10+1-10)
            visit[tmp%case]=1




    if res==0:
        print('BRAK')
    else:
        print(res)
    
    
        