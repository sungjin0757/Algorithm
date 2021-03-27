import random as r
import time
import sys
sys.setrecursionlimit(3002)
def partition(a, l, r):
    v = a[r]
    i = l-1
    j=r

    while True:
        while True:
            i+=1
            if not a[i]<v: break
        while True:
            j-=1
            if not a[j]>v: break
        if i>=j: break
        a[i], a[j] = a[j], a[i]
    a[i], a[r] = a[r], a[i]

    return i

def quicksort(a,l,r):
    if r>l:
        
        i=partition(a,l,r)
       
        quicksort(a,l,i-1)
        quicksort(a,i+1,r)
        
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
quicksort(x,1,len(x)-1)
end_time=time.time()-start_time
print('퀵 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))

x=list()
N=200000
for i in range(N):
    x.append(r.randint(1,N))
x.insert(0,-1)

start_time=time.time()
quicksort(x,1,len(x)-1)
end_time=time.time()-start_time
print('퀵 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))

x=list()
N=300000
for i in range(N):
    x.append(r.randint(1,N))
x.insert(0,-1)

start_time=time.time()
quicksort(x,1,len(x)-1)
end_time=time.time()-start_time
print('퀵 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))



print()
x=list()
N=1000
for i in range(N):
    x.append(r.randint(1,N))
x.sort()
x.insert(0,-1)
start_time=time.time()
quicksort(x,1,len(x)-1)
end_time=time.time()-start_time
print('오름차순 퀵 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))        


x=list()
N=1000
for i in range(N):
    x.append(r.randint(1,N))
x.sort(reverse=True)
x.insert(0,-1)
start_time=time.time()
quicksort(x,1,len(x)-1)
end_time=time.time()-start_time
print('내림차순 퀵 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))        


x=list()
N=1000
for i in range(N):
    x.append(r.randint(1,N))
x.insert(0,-1)
start_time=time.time()
quicksort(x,1,len(x)-1)
end_time=time.time()-start_time
print('랜덤 차순 퀵 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))        
print()
x=list()
N=2000
for i in range(N):
    x.append(r.randint(1,N))
x.sort()
x.insert(0,-1)
start_time=time.time()
quicksort(x,1,len(x)-1)
end_time=time.time()-start_time
print('오름차순 퀵 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))        


x=list()
N=2000
for i in range(N):
    x.append(r.randint(1,N))
x.sort(reverse=True)
x.insert(0,-1)
start_time=time.time()
quicksort(x,1,len(x)-1)
end_time=time.time()-start_time
print('내림차순 퀵 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))        


x=list()
N=2000
for i in range(N):
    x.append(r.randint(1,N))
x.insert(0,-1)
start_time=time.time()
quicksort(x,1,len(x)-1)
end_time=time.time()-start_time
print('랜덤 차순 퀵 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))        
print()
x=list()
N=3000
for i in range(N):
    x.append(r.randint(1,N))
x.sort()
x.insert(0,-1)
start_time=time.time()
quicksort(x,1,len(x)-1)
end_time=time.time()-start_time
print('오름차순 퀵 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))        


x=list()
N=3000
for i in range(N):
    x.append(r.randint(1,N))
x.sort(reverse=True)
x.insert(0,-1)
start_time=time.time()
quicksort(x,1,len(x)-1)
end_time=time.time()-start_time
print('내림차순 퀵 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))        


x=list()
N=3000
for i in range(N):
    x.append(r.randint(1,N))
x.insert(0,-1)
start_time=time.time()
quicksort(x,1,len(x)-1)
end_time=time.time()-start_time
print('랜덤 차순 퀵 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))        
