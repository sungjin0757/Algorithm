import random as r
import time
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
def tournamentSort(a,n):
    level=0
    leveltmp=1
    while leveltmp<n:
        leveltmp=leveltmp*2
        level+=1
    nodecnt=0
    letmp=0
    cnttmp=1
    while letmp<=level:
        if letmp==0:
            nodecnt+=1
        else:
            nodecnt+=cnttmp
        cnttmp=cnttmp*2
        letmp+=1
    b=[0]*nodecnt
   # print(b)
    b.insert(0,0)
    for i in range(n):
        b[i+leveltmp]=a[i]
    idx=leveltmp
    lentmp=len(b)-1

    while idx>1:
        for j in range(idx,lentmp,2):
            if b[j]>b[j+1]:
                b[j//2]=b[j]
            else:
                b[j//2]=b[j+1]
        idx=idx//2 
        lentmp=lentmp//2
   # print(b)
    a[n-1]=b[1]
    #print(a)
    for j in range(1,len(b)):
        if a[n-1]==b[j]:
            b[j]=0
            idx=j
    #print(b)
    for i in range(n-2,-1,-1):
        while idx>1:
            if idx//2==(idx-1)//2:
                if b[idx]>b[idx-1]:
                    b[idx//2]=b[idx]
                else:
                    b[idx//2]=b[idx-1]
            elif idx//2==(idx+1)//2:
                if b[idx]>b[idx+1]:
                    b[idx//2]=b[idx]
                else:
                    b[idx//2]=b[idx+1]
            idx=idx//2
     #   print(b)
        a[i]=b[1]
        for j in range(1,len(b)):
            if a[i]==b[j]:
                b[j]=0
                idx=j
    return a

x=list()
N=5000
for i in range(N):
    x.append(i+1)
r.shuffle(x)
start_time=time.time()
k=tournamentSort(x,len(x))
end_time=time.time()-start_time
print('토너먼트 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))

#checkSort(k,len(k)-1)
x=list()
N=10000
for i in range(N):
    x.append(i+1)
r.shuffle(x)
start_time=time.time()
k=tournamentSort(x,len(x))
end_time=time.time()-start_time
print('토너먼트 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))

x=list()
N=15000
for i in range(N):
    x.append(i+1)
r.shuffle(x)
start_time=time.time()
k=tournamentSort(x,len(x))
end_time=time.time()-start_time
print('토너먼트 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))

print()
print()
x=set()
N=5000
for i in range(N):
    x.add(r.randint(1,N))
x=list(x)
x.sort()

start_time=time.time()
tournamentSort(x,len(x))
end_time=time.time()-start_time
print('오름차순 토너먼트 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))        


x=set()
N=5000
for i in range(N):
    x.add(r.randint(1,N))
x=list(x)
x.sort(reverse=True)

start_time=time.time()
tournamentSort(x,len(x))
end_time=time.time()-start_time
print('내림차순 토너먼트 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))        


x=set()
N=5000
for i in range(N):
    x.add(r.randint(1,N))
x=list(x)
r.shuffle(x)
start_time=time.time()
tournamentSort(x,len(x))
end_time=time.time()-start_time
print('랜덤 차순 토너먼트 정렬의 시간 (N=%d) : %0.3f'%(N,end_time))        


