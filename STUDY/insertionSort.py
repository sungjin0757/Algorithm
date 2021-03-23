import random as r
import time

def insertionSort(a,n):
    for i in range(2,n+1):
        v=a[i]
        j=i
        while(a[j-1]>v):
            a[j]=a[j-1]
            j=j-1
        a[j]=v

x=list()
N=5000
for i in range(N):
    x.append(r.randint(1,N))
x.insert(0,-1)
start_time=time.time()
insertionSort(x,len(x)-1)
end_time=time.time()-start_time
print('삽입 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))        
x=list()
N=10000
for i in range(N):
    x.append(r.randint(1,N))
x.insert(0,-1)
start_time=time.time()
insertionSort(x,len(x)-1)
end_time=time.time()-start_time
print('삽입 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))
x=list()
N=15000
for i in range(N):
    x.append(r.randint(1,N))
x.insert(0,-1)
start_time=time.time()
insertionSort(x,len(x)-1)
end_time=time.time()-start_time
print('삽입 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))

x=list()
N=5000
for i in range(N):
    x.append(r.randint(1,N))
x.sort()
x.insert(0,-1)
start_time=time.time()
insertionSort(x,len(x)-1)
end_time=time.time()-start_time
print('오름차순 삽입 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))        


x=list()
N=5000
for i in range(N):
    x.append(r.randint(1,N))
x.sort(reverse=True)
x.insert(0,-1)
start_time=time.time()
insertionSort(x,len(x)-1)
end_time=time.time()-start_time
print('내림차순 삽입 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))        


x=list()
N=5000
for i in range(N):
    x.append(r.randint(1,N))
x.insert(0,-1)
start_time=time.time()
insertionSort(x,len(x)-1)
end_time=time.time()-start_time
print('랜덤 차순 삽입 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))        

