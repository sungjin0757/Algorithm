import sys
sys.stdin=open("input.txt","rt")
from collections import deque

dx=[-1,0,1,0]
dy=[0,1,0,-1]

n,k=map(int,sys.stdin.readline().strip().split())

civil=[[0]*n for _ in range(n)]
q1=deque()
q2=deque()
for i in range(k):
    a,b=map(int,sys.stdin.readline().strip().split())
    civil[b-1][a-1]=i+1
    q1.append((b-1,a-1))

union=[]
for i in range(n*n):
    union.append(i)
union.append(i+1)

c_cnt=k
cnt=0
def find(x):
    if union[x]==x:
        return x
    union[x]=find(union[x])
    return union[x]
def merge(x,y):
    n1=find(x)
    n2=find(y)

    if n1==n2:
        return False
    union[n1]=n2
    return True

while True:

    size=len(q1)
    for i in range(size):
        a,b=q1.popleft()
        q2.append((a,b))
        for j in range(4):
            xx=a+dx[j]
            yy=a+dy[j]
            if 0<=xx<n and 0<=yy<n and civil[xx][yy]!=0:
                flag=merge(civil[a][b],civil[xx][yy])
                if flag==True:
                    c_cnt-=1
    if c_cnt<=1:
        break
    size=len(q2)
    for i in range(size):
        a,b=q2.popleft()
        for j in range(4):
            xx=a+dx[j]
            yy=b+dy[j]
            if 0<=xx<n and 0<=yy<n and civil[xx][yy]==0:
                civil[xx][yy]=civil[a][b]
                q1.append((xx,yy))
    cnt+=1        

print(cnt)