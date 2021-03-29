import random as r
import time
def heapify(a,h,m):
    v=a[h]
    j=2*h
    while j<=m:
        if j<m and a[j]<a[j+1]:
            j=j+1
        if v>=a[j]:
            break
        else:
            a[j//2]=a[j]
        j*=2
    a[j//2]=v
    

def heapsort(a,n):
    for i in range(n//2,0,-1):
        heapify(a,i,n)

    for i in range(n-1,0,-1):
        a[1],a[i+1]=a[i+1],a[1]
        heapify(a,1,i)
def checkSort(a, n):
    isSorted=True
    for i in range(1,n):
        if (a[i] > a[i+1]) :
            isSorted = False
        if (not isSorted) :
            break
    if isSorted:
        print("정렬완료")
    else:
        print("오류발생")


x=list()
N=100000
for i in range(N):
    x.append(r.randint(1,N))
x.insert(0,-1)

start_time=time.time()
heapsort(x,len(x)-1)
end_time=time.time()-start_time
print('힙 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))

x=list()
N=200000
for i in range(N):
    x.append(r.randint(1,N))
x.insert(0,-1)

start_time=time.time()
heapsort(x,len(x)-1)
end_time=time.time()-start_time
print('힙 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))

x=list()
N=300000
for i in range(N):
    x.append(r.randint(1,N))
x.insert(0,-1)

start_time=time.time()
heapsort(x,len(x)-1)
end_time=time.time()-start_time
print('힙 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))

print()
x=list()
N=1000
for i in range(N):
    x.append(r.randint(1,N))
x.sort()
x.insert(0,-1)
start_time=time.time()
heapsort(x,len(x)-1)
end_time=time.time()-start_time
print('오름차순 힙 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))        


x=list()
N=1000
for i in range(N):
    x.append(r.randint(1,N))
x.sort(reverse=True)
x.insert(0,-1)
start_time=time.time()
heapsort(x,len(x)-1)
end_time=time.time()-start_time
print('내림차순 힙 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))        


x=list()
N=1000
for i in range(N):
    x.append(r.randint(1,N))
x.insert(0,-1)
start_time=time.time()
heapsort(x,len(x)-1)
end_time=time.time()-start_time
print('랜덤 차순 힙 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))        

print()
x=list()
N=2000
for i in range(N):
    x.append(r.randint(1,N))
x.sort()
x.insert(0,-1)
start_time=time.time()
heapsort(x,len(x)-1)
end_time=time.time()-start_time
print('오름차순 힙 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))        


x=list()
N=2000
for i in range(N):
    x.append(r.randint(1,N))
x.sort(reverse=True)
x.insert(0,-1)
start_time=time.time()
heapsort(x,len(x)-1)
end_time=time.time()-start_time
print('내림차순 힙 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))        


x=list()
N=2000
for i in range(N):
    x.append(r.randint(1,N))
x.insert(0,-1)
start_time=time.time()
heapsort(x,len(x)-1)
end_time=time.time()-start_time
print('랜덤 차순 힙 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))        

print()
x=list()
N=3000
for i in range(N):
    x.append(r.randint(1,N))
x.sort()
x.insert(0,-1)
start_time=time.time()
heapsort(x,len(x)-1)
end_time=time.time()-start_time
print('오름차순 힙 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))        


x=list()
N=3000
for i in range(N):
    x.append(r.randint(1,N))
x.sort(reverse=True)
x.insert(0,-1)
start_time=time.time()
heapsort(x,len(x)-1)
end_time=time.time()-start_time
print('내림차순 힙 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))        


x=list()
N=3000
for i in range(N):
    x.append(r.randint(1,N))
x.insert(0,-1)
start_time=time.time()
heapsort(x,len(x)-1)
end_time=time.time()-start_time
print('랜덤 차순 힙 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))        

