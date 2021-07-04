import sys
sys.stdin=open("input.txt","rt")

r,c=map(int,input().split())
a=[list(input()) for _ in range(r)]

dx=[-1,0,1]
dy=[1,1,1]
cnt=0
def DFS(x,y):

    if y==c-1:
        return True
    else:
        for i in range(3):
            xx=x+dx[i]
            yy=y+dy[i]
            if 0<=xx<r and 0<=yy<c and a[xx][yy]!='x':
                a[xx][yy]='x'
                if DFS(xx,yy):
                    return True
        return False

for i in range(r):
    if a[i][0]=='.':
        if DFS(i,0):
            cnt+=1

print(cnt)

