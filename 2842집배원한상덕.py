import sys
#sys.stdin=open("input.txt","rt")
sys.setrecursionlimit(10**6)

n=int(input())

a=[list(map(str,sys.stdin.readline().strip())) for _ in range(n)]
a_high=[list(map(int,sys.stdin.readline().strip().split())) for _ in range(n)]

p_row=0
p_col=0
k=list()
for i in range(n):
    for j in range(n):
        if a[i][j]=='P':
            p_row=i
            p_col=j
        if a[i][j]=='K':
            k.append((i,j))

dx=[-1,-1,-1,0,0,1,1,1]
dy=[0,-1,1,1,-1,0,-1,1]
tmp=set()
for i in range(n):
    for j in range(n):
        tmp.add(a_high[i][j])
tmp=sorted(list(tmp))

def DFS(x,y):
    if visit[x][y]==0:
        visit[x][y]=1
    for i in range(8):
        xx=x+dx[i]
        yy=y+dy[i]
        if 0<=xx<n and 0<=yy<n and visit[xx][yy]==0:
            if tmp[left]<=a_high[xx][yy]<=tmp[right]:
                DFS(xx,yy)
left=0
right=0
res=1000001
while left<=right:
    if right==len(tmp):
        break
    else:
        visit=[[0]*n for _ in range(n)]
        if tmp[left]<=a_high[p_row][p_col]<=tmp[right]:
            DFS(p_row,p_col)
        flg=True

        for i in range(len(k)):
            if visit[k[i][0]][k[i][1]]==0:

                flg=False
                break
        if flg==True:
            res=min(res,tmp[right]-tmp[left])
            left+=1
        else:
            right+=1
print(res)
