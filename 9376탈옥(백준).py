import sys
#sys.stdin=open("input.txt","rt")
from collections import deque

n=int(input())


def BFS(x,y):
    ch=[[-1]*(b+2) for _ in range(a+2)]

    dq=deque()
    dq.append((x,y))
    ch[x][y]=0
    while dq:
        xx,yy=dq.popleft()
        for i in range(4):
            xxx=xx+dx[i]
            yyy=yy+dy[i]
            if 0<=xxx<a+2 and 0<=yyy<b+2 and ch[xxx][yyy]==-1:
                if prison[xxx][yyy]=='*':
                    continue
                elif prison[xxx][yyy]=='.' or prison[xxx][yyy]=='$':
                    ch[xxx][yyy]=ch[xx][yy]
                    dq.appendleft((xxx,yyy))
                elif prison[xxx][yyy]=='#':
                    ch[xxx][yyy]=ch[xx][yy]+1
                    dq.append((xxx,yyy))
    return ch
for i in range(n):
    a,b=map(int,input().split())

    prison=['.'*(b+2)]
    for j in range(a):
        prison.append(list('.'+input().strip()+'.'))
    prison.append(list('.'*(b+2)))
    tmp=[]
    for j in range(a+2):
        for k in range(b+2):
            if prison[j][k]=='$':
                tmp.append((j,k))
    dx=[-1,0,0,1]
    dy=[0,-1,1,0]

    tmp_1,tmp_2=tmp.pop()
    prisoner1=BFS(tmp_1,tmp_2)
    tmp_1,tmp_2=tmp.pop()
    prisoner2=BFS(tmp_1,tmp_2)
    sangkeun=BFS(0,0)
    
    res=1e9
    
    for j in range(a+2):
        for k in range(b+2):
            if prisoner1[j][k]!=-1 and prisoner2[j][k]!=-1 and sangkeun[j][k]!=-1:
                tmp=prisoner1[j][k]+prisoner2[j][k]+sangkeun[j][k]
                if prison[j][k]=='#':
                    tmp-=2
              
                res=min(res,tmp)
    
    print(res)

   
