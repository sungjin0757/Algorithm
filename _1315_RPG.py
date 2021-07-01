import sys
sys.stdin=open("input.txt","rt")

n=int(input())

a=[]

for i in range(n):
    tmp1,tmp2,tmp3=map(int,sys.stdin.readline().strip().split())
    a.append([tmp1,tmp2,tmp3])
    
visit=[0]*(n+1)
def DFS(x,y):
    
    cnt=0
    pnt=0
    q=[]
    for i in range(n):
        if a[i][0]<=x or a[i][1]<=y:
            cnt+=1
            if visit[i+1]!=1:
                pnt+=a[i][2]
                visit[i+1]=1
                q.append(i+1)
    for i in range(pnt+1):
        if pnt==0:
            break
        sr=min(1000,x+pnt-i)
        it=min(1000,y+i)
        cnt=max(cnt,DFS(sr,it))
    for i in q:
        visit[i]=0

    return cnt
print(DFS(1,1))