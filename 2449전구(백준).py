import sys
#sys.stdin=open("input.txt","rt")

n,k=map(int,input().split())
a=list(map(int,input().split()))
a.insert(0,0)
dy=[0]*(n+1)

dy=[[-1]*(n+1) for _ in range(n+1)]

def DFS(x,y):

    if x==y:
        return 0
    if dy[x][y]!=-1:
        return dy[x][y]

    dy[x][y]=1000000000

    for i in range(x,y):
        tmp=0
        if a[x]!=a[i+1]:
            tmp=1
        tmp_1=DFS(x,i)
        tmp_2=DFS(i+1,y)
        dy[x][y]=min(dy[x][y],tmp+tmp_1+tmp_2)
    return dy[x][y]


print(DFS(1,n))
