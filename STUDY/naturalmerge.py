import random as r
import time
def merge(a,l,m,r):
    
    i=l
    j=m+1
    k=l
    while i<=m and j<=r:
        if a[i]<a[j]:
            b[k]=a[i]
            k+=1
            i+=1
        else:
            b[k]=a[j]
            k+=1
            j+=1

    if i>m:
        while j<=r:
            b[k]=a[j]
            k+=1
            j+=1
    else:
        while i<=m:
            b[k]=a[i]
            k+=1
            i+=1
    a[l:r+1]=b[l:r+1]

def mergesort(a,l,r):
    if r>l:
        m=(l+r)//2
        mergesort(a,l,m)
        mergesort(a,m+1,r)
        merge(a,l,m,r)
def makeRun(a,n):
    run=[]
    tmp=[]
    for i in range(n):
        if a[i]<=a[i+1]:
            tmp.append(a[i])
        else:
            tmp.append(a[i])
            run.append(tmp)
            tmp=[]
        if i==n-1:
            tmp.append(a[i+1])
            run.append(tmp)
   
    return run
    


def nmerge(a,b):
    i=0
    j=0
    c=[]
    while i<len(a) and j<len(b):
        if a[i]<b[j]:
            c.append(a[i])
            i+=1
        else:
            c.append(b[j])
            j+=1
    if i>=len(a):
        while j<len(b):
            c.append(b[j])
            j+=1
    else:
        while i<len(a):
            c.append(a[i])
            i+=1
    return c

def checkSort(a, n):
    isSorted=True
    for i in range(0,n):
        if (a[i] > a[i+1]) :
            isSorted = False
        if (not isSorted) :
            break
    if isSorted:
        print("정렬완료")
    else:
        print("오류발생")
def naturalMerge(a):
    while len(a)>1:
        for i in range(0,len(a)-1,2):
            tmp1,tmp2=a[i],a[i+1]
            a[i//2]=nmerge(tmp1,tmp2)
            if len(a)%2==1 and i+2==len(a)-1:
                a[(len(a)-1)//2]=a[len(a)-1]
                for j in range(len(a)-((len(a)-1)//2+1)):
                    a.pop()
            elif i==len(a)-2:
                for j in range(len(a)-(len(a)//2)):
                    a.pop()

    return a[0]


x=[]
N=100000
for i in range(N):
    x.append(r.randint(1,N))

start_time=time.time()
naturalMerge(makeRun(x,len(x)-1))
end_time=time.time()-start_time
print('자연 합병 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))

x=[]
N=100000
for i in range(N):
    x.append(r.randint(1,N))
b=[0]*len(x)
start_time=time.time()
mergesort(x,0,len(x)-1)
end_time=time.time()-start_time
print('합병 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))
print()


x=[]
N=200000
for i in range(N):
    x.append(r.randint(1,N))

start_time=time.time()
naturalMerge(makeRun(x,len(x)-1))
end_time=time.time()-start_time
print('자연 합병 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))
x=[]
N=200000
for i in range(N):
    x.append(r.randint(1,N))
b=[0]*len(x)
start_time=time.time()
mergesort(x,0,len(x)-1)
end_time=time.time()-start_time
print('합병 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))
print()


x=[]
N=300000
for i in range(N):
    x.append(r.randint(1,N))

start_time=time.time()
naturalMerge(makeRun(x,len(x)-1))
end_time=time.time()-start_time

print('자연 합병 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))
x=[]
N=300000
for i in range(N):
    x.append(r.randint(1,N))
b=[0]*len(x)
start_time=time.time()
mergesort(x,0,len(x)-1)
end_time=time.time()-start_time
print('합병 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))
print()

x=list()
N=10000
for i in range(N):
    x.append(r.randint(1,N))
x.sort()

start_time=time.time()
naturalMerge(makeRun(x,len(x)-1))
end_time=time.time()-start_time
print('오름차순 자연 합병 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))        
x=list()
N=10000
for i in range(N):
    x.append(r.randint(1,N))
x.sort()
b=[0]*len(x)
start_time=time.time()
mergesort(x,0,len(x)-1)
end_time=time.time()-start_time
print('오름차순 합병 정렬의 시간 (N=%d) : %0.3f'%(N,end_time)) 
print()


x=list()
N=10000
for i in range(N):
    x.append(r.randint(1,N))
x.sort(reverse=True)

start_time=time.time()
naturalMerge(makeRun(x,len(x)-1))
end_time=time.time()-start_time
print('내림차순 자연 합병 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))        
x=list()
N=10000
for i in range(N):
    x.append(r.randint(1,N))
x.sort(reverse=True)
b=[0]*len(x)
start_time=time.time()
mergesort(x,0,len(x)-1)
end_time=time.time()-start_time
print('내림차순 합병 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))   
print()


x=list()
N=10000
for i in range(N):
    x.append(r.randint(1,N))

start_time=time.time()
naturalMerge(makeRun(x,len(x)-1))
end_time=time.time()-start_time
print('랜덤 차순 자연 합병 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))        
x=list()
N=10000
for i in range(N):
    x.append(r.randint(1,N))
b=[0]*len(x)
start_time=time.time()
mergesort(x,0,len(x)-1)
end_time=time.time()-start_time
print('랜덤 차순 합병 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))  