import sys
#sys.stdin=open("input.txt","rt")

n,m,k=map(int,input().split())


if m + k - 1 <= n <= m * k:
    a=list(range(1,n+1))
    b=[0,k]
    n-=k
    m-=1
    if m==0:
        size,remain=1,0
    else:
        size,remain=n//m,n%m

    for i in range(m):
        if remain>0:
            b.append(b[-1]+size+1)
            remain-=1
        else:
            b.append(b[-1]+size)
    for i in range(len(b)-1):
        a[b[i]:b[i+1]]=a[b[i]:b[i+1]][::-1]
    print(" ".join(map(str,a)))
else:
    print(-1)
