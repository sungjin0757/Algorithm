import random as r
import time

def countingSort(a,n,m):
    count=[0]*(m+1)
    b=[0]*(n+1)
    
    for i in range(1,n+1):
        count[a[i]]+=1
    for j in range(2,m+1):
        count[j]=count[j-1]+count[j]
    for i in range(n,0,-1):
        b[count[a[i]]]=a[i]
        count[a[i]]=count[a[i]]-1
        #print("b:",b[1:10],"count:",count[1:10])
    for i in range(1,n+1):
        a[i]=b[i]


x=list()
N=100000
M=1000
for i in range(N):
    x.append(r.randint(1,M))
x.insert(0,-1)

start_time=time.time()
countingSort(x,N,M)
end_time=time.time()-start_time
print('계수 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))

x=list()
N=200000
M=1000
for i in range(N):
    x.append(r.randint(1,M))
x.insert(0,-1)

start_time=time.time()
countingSort(x,N,M)
end_time=time.time()-start_time
print('계수 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))

x=list()
N=300000
M=1000
for i in range(N):
    x.append(r.randint(1,M))
x.insert(0,-1)

start_time=time.time()
countingSort(x,N,M)
end_time=time.time()-start_time
print('계수 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))