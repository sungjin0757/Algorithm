import sys
sys.stdin=open("input.txt","rt")

n=int(input())
a=[list(map(int,sys.stdin.readline().strip().split())) for _ in range(n-1)]
b=[[0]*(n+1) for _ in range(n+1)]
dy=[[0]*(n+1) for _ in range(n+1)]

for i in range(n-1):
    b[a[i][0]][a[i][1]]=a[i][2]
    b[a[i][1]][a[i][0]]=a[i][2]
    dy[a[i][0]][a[i][1]]=a[i][2]
    dy[a[i][1]][a[i][0]]=a[i][2]

def DFS(x):
    res=0
    
    for i in range(0,n+1):
        if ch[x][i]==0 and ch[i][x]==0:
            if b[x][i]!=0:
                break
    else:
        return b[x][i]
    for i in range(0,n+1):
        if b[x][i]!=0 and ch[x][i]==0 and ch[i][x]==0:
            ch[x][i]=1
            ch[i][x]=1
            tmp=b[x][i]
            tmp+=DFS(i)
            ch[x][i]=1
            ch[i][x]=1
            res=max(res,tmp)
        if i==n:
            dy[x][i]=res
            dy[i][x]=res
            return res

for i in range(1,n+1):

    tmp_i=i
    ch=[[0]*(n+1) for _ in range(n+1)]
    print(DFS(i))
    