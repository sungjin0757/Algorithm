import time
import random as r

def bubbleSort(a,n):
    for i in range(n,0,-1):
        for j in range(1,i):
            
            if a[j]>a[j+1]:
                a[j],a[j+1]=a[j+1],a[j]



x=list()
N=5000
for i in range(N):
    x.append(r.randint(1,N))
x.insert(0,None)
start_time=time.time()
bubbleSort(x,len(x)-1)
end_time=time.time()-start_time
print('버블 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))        
x=list()
N=10000
for i in range(N):
    x.append(r.randint(1,N))
x.insert(0,None)
start_time=time.time()
bubbleSort(x,len(x)-1)
end_time=time.time()-start_time
print('버블 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))
x=list()
N=15000
for i in range(N):
    x.append(r.randint(1,N))
x.insert(0,None)
start_time=time.time()
bubbleSort(x,len(x)-1)
end_time=time.time()-start_time
print('버블 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))
x=list()
N=5000
for i in range(N):
    x.append(r.randint(1,N))
x.sort()
x.insert(0,None)
start_time=time.time()
bubbleSort(x,len(x)-1)
end_time=time.time()-start_time

print('오름 차순 버블 정렬의 시간 (N=%d) : %0.3f'%(N,end_time)) 

x=list()
N=5000
for i in range(N):
    x.append(r.randint(1,N))
x.sort(reverse=True)
x.insert(0,None)
start_time=time.time()
bubbleSort(x,len(x)-1)
end_time=time.time()-start_time

print('내림 차순 버블 정렬의 시간 (N=%d) : %0.3f'%(N,end_time)) 

x=list()
N=5000
for i in range(N):
    x.append(r.randint(1,N))
x.insert(0,None)

start_time=time.time()
bubbleSort(x,len(x)-1)
end_time=time.time()-start_time

print('랜덤 차순 버블 정렬의 시간 (N=%d) : %0.3f'%(N,end_time)) 
