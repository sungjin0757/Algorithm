import sys
sys.stdin=open("input.txt","rt")

n=int(input())
a=list(range(0,n+1))

dy=[[[0]*(n+1) for _ in range(n+1)]for _ in range(n+1)]
def DFS(k,x,y):
    
    if k==n+1:
        return 1

    if dy[k][x][y]!=0:
        return dy[k][x][y]


    for i in range(1,n+1):
        if k==1:
            ch[i]=1
            dy[k][x][y]+=DFS(k+1,i,y)%1000000
            ch[i]=0
        if k==2 :
            if ch[i]==0:
                ch[i]=1
                dy[k][x][y]+=DFS(k+1,x,i)%1000000
                ch[i]=0
       
        if k>2:
            if a[x]>a[y]:
                if a[y]>a[i]:
                    continue
            elif a[y]>a[x]:
                if a[y]<a[i]:
                    continue
            if ch[i]==0:
                ch[i]=1
                dy[k][x][y]+=DFS(k+1,y,i)%1000000
                ch[i]=0
    return dy[k][x][y]
ch=[0]*(n+1)
print((DFS(1,0,0)-1)%1000000)
print(dy)
