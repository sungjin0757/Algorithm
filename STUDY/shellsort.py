import time
import random as r
def shellSort(a,n):
    h=1
    tmp=1
    
    while tmp<n:
        h=tmp
        tmp=tmp*3+1
    
    while h>0:
        for i in range(h+1,n+1,1):
            v=a[i]
            j=i            
            while j>h and a[j-h]>v:
                a[j]=a[j-h]
                j=j-h
            a[j]=v
        h=h//3
    

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


x=[]
N=5000
for i in range(N):
    x.append(r.randint(1,N))
x.insert(0,-1)
start_time=time.time()
shellSort(x,N)
end_time=time.time()-start_time
print('쉘 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))

x=list()
N=10000
for i in range(N):
    x.append(r.randint(1,N))
x.insert(0,-1)
start_time=time.time()
shellSort(x,len(x)-1)
end_time=time.time()-start_time
print('쉘 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))

x=list()
N=15000
for i in range(N):
    x.append(r.randint(1,N))
x.insert(0,-1)
start_time=time.time()
shellSort(x,len(x)-1)
end_time=time.time()-start_time
print('쉘 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))


x=list()
N=5000
for i in range(N):
    x.append(r.randint(1,N))
x.sort()
x.insert(0,-1)
start_time=time.time()
shellSort(x,len(x)-1)
end_time=time.time()-start_time
print('오름차순 쉘 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))        


x=list()
N=5000
for i in range(N):
    x.append(r.randint(1,N))
x.sort(reverse=True)
x.insert(0,-1)
start_time=time.time()
shellSort(x,len(x)-1)
end_time=time.time()-start_time
print('내림차순 쉘 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))        


x=list()
N=5000
for i in range(N):
    x.append(r.randint(1,N))
x.insert(0,-1)
start_time=time.time()
shellSort(x,len(x)-1)
end_time=time.time()-start_time
print('랜덤 차순 쉘 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))        

