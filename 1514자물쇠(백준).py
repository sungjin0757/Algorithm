import sys
sys.setrecursionlimit(10**6)
#sys.stdin=open("input.txt","rt")

n=int(input())
present=list(input())
sejun=list(input())

for i in range(n):
    present[i]=int(present[i])
    sejun[i]=int(sejun[i])


def sol(x):
    while x<0:
        x+=10
    return x%10
dy=[[[[[-1]*(2) for _ in range(11)] for _ in range(11)]for _ in range(11)] for _ in range(n+1)]

def DFS(k,x,y,z,s):
    if k==n:
        return 0
    if dy[k][x][y][z][s]!=-1:
        return dy[k][x][y][z][s]
    if sol(x+sejun[k])==present[k]:
        dy[k][x][y][z][s]=min(DFS(k+1,y,z,0,1),DFS(k+1,y,z,0,0))
        return dy[k][x][y][z][s]
   

    dy[k][x][y][z][s]=100000000

    for i in range(1,4):
        if s==1:
            dy[k][x][y][z][s]=min(DFS(k,sol(x+i),y,z,s)+1,dy[k][x][y][z][s])
            dy[k][x][y][z][s]=min(DFS(k,sol(x+i),sol(y+i),z,s)+1,dy[k][x][y][z][s])
            dy[k][x][y][z][s]=min(DFS(k,sol(x+i),sol(y+i),sol(z+i),s)+1,dy[k][x][y][z][s])
        else:
            dy[k][x][y][z][s]=min(DFS(k,sol(x-i),y,z,s)+1,dy[k][x][y][z][s])
            dy[k][x][y][z][s]=min(DFS(k,sol(x-i),sol(y-i),z,s)+1,dy[k][x][y][z][s])
            dy[k][x][y][z][s]=min(DFS(k,sol(x-i),sol(y-i),sol(z-i),s)+1,dy[k][x][y][z][s])
    return dy[k][x][y][z][s]


print(min(DFS(0,0,0,0,0),DFS(0,0,0,0,1)))