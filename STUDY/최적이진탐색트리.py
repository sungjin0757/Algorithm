import sys
def optimalBST(p,a,r,n):
    for i in range(n+1):
        a[i][i]=p[i]
        r[i][i]=i

    for h in range(1,n):
        for i in range(1,n-h+1):
            j=i+h
            a[i][j]=sys.maxsize
            p_sum=0
            for m in range(i,j+1):
                p_sum+=p[m]
            for k in range(i,j+1):
                q=a[i][k-1]+a[k+1][j]+p_sum
                if q<a[i][j]:
                    a[i][j]=q
                    r[i][j]=k

    return a[1][n]

N=4
P=[0.0,0.3,0.2,0.4,0.1]
A=[]
R=[]
for i in range(N+2):
    a=[]
    r=[]
    for i in range(N+1):
        a.append(0)
        r.append(0)
    A.append(a)
    R.append(r)

result=optimalBST(P,A,R,N)
print('최적 이진 탐색 트리의 최솟값: %.1f'%result)
print('A')
for i in range(1,len(A)-1):
    print(A[i][2:len(A[0])])
print('K')
for i in range(1,len(R)-1):
    print(R[i][2:len(R[0])])