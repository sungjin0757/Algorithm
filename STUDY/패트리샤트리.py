maxb=16
import random,time
class bitskey:
    def __init__(self,x):
        self.x = x

    def get(self):
        return self.x

    def bits(self,k,j):
        return (self.x>>k) & ~(~0<<j)

class node:
    def __init__(self,key):
        self.key=key
        self.b=None
        self.left=None
        self.right=None
class Dict():
    itemMin = bitskey(0)
    head = node(itemMin)
    head.b = maxb
    head.left = head.right = head
    def search(self,v):
        v=bitskey(v)
        p=self.head
        x=self.head.left
        while p.b>x.b:
            p=x
            if self.bits(v,x.b,1):
                x=x.right

            else:
                x=x.left
        if v.get() != x.key.get() : return self.itemMin
        return x.key.get()

    def insert(self,v):
        v=bitskey(v)
        i=maxb
        p=self.head
        t=self.head.left
        while p.b > t.b:
            p=t
            if self.bits(v,t.b,1):
                t=t.right
            else:
                t=t.left
        if v.get() == t.key.get():return
        while self.bits(t.key,i,1) == self.bits(v,i,1):
            i-=1
        p=self.head
        
        x=self.head.left
        while p.b > x.b and x.b >i:
            p = x
            if self.bits(v,x.b,1):
                x=x.right
            else:
                x=x.left
        t=node(self.itemMin)
        t.key=v
        t.b=i
        if self.bits(v,t.b,1):
            t.left = x
            t.right = t
        else:
            t.left = t
            t.right = x

        if self.bits(v,p.b,1):
            p.right = t
        else:
            p.left=t

    def bits(self, item, bit, cmp):
        if item.bits(bit,1) == cmp:
            return 1
        else:
            return 0
    def check(self,n):
        for i in range(1,n+1):
            x = self.head.left
            p = self.head
            tmp=bitskey(i)
            while p.b>x.b and x.key.get()!=tmp.get():
                p=x
                if self.bits(tmp,x.b,1):
                    x=x.right

                else:
                    x=x.left
            if tmp.get() != x.key.get():
                continue

            if p==self.head:
                print('key: ',x.key.get(),' parent: ',x.key.get())
            elif x!=self.head.left:
                print('key: ',x.key.get(),' parent: ',p.key.get())


N=10000
#maxb=16
key = list(range(1,N+1))
s_key = list(range(1,N+1))
random.shuffle(key)
d = Dict()
for i in range(0,N):
  d.insert(key[i])
start_time = time.time()
for i in range(N):
  result = d.search(s_key[i])
  if result == -1 or result != s_key[i]:
    print('탐색 오류')
    
end_time = time.time()-start_time


print("패트리샤 탐색의 실행시간 (N=%d): %0.3f"%(N,end_time))
print("탐색완료")
d.head.left = d.head.right = d.head
N= 20000
#maxb=16
key = list(range(1,N+1))
s_key = list(range(1,N+1))
random.shuffle(key)
d = Dict()
for i in range(0,N):
  d.insert(key[i])
start_time = time.time()
for i in range(N):
  result = d.search(s_key[i])
  if result == -1 or result != s_key[i]:
    print('탐색 오류')
    
end_time = time.time()-start_time


print("패트리샤 탐색의 실행시간 (N=%d): %0.3f"%(N,end_time))
print("탐색완료")
d.head.left = d.head.right = d.head
N= 30000
#maxb=16
key = list(range(1,N+1))
s_key = list(range(1,N+1))
random.shuffle(key)
d = Dict()
for i in range(0,N):
  d.insert(key[i])
start_time = time.time()
for i in range(N):
  result = d.search(s_key[i])
  if result == -1 or result != s_key[i]:
    print('탐색 오류')
    
end_time = time.time()-start_time


print("패트리샤 탐색의 실행시간 (N=%d): %0.3f"%(N,end_time))
print("탐색완료")
d.head.left = d.head.right = d.head
print()
N= 10000
#maxb=14
key = list(range(1,N+1))
s_key = list(range(1,N+1))
#random.shuffle(key)
d = Dict()
for i in range(0,N):
  d.insert(key[i])
start_time = time.time()
for i in range(N):
  result = d.search(s_key[i])
  if result == -1 or result != s_key[i]:
    print('탐색 오류')
end_time = time.time()-start_time


print("오름 차순 패트리샤 트리 탐색의 실행시간 (N=%d): %0.3f"%(N,end_time))
print("탐색완료")
d.head.left = d.head.right = d.head

N= 10000
#maxb=14
key = list(range(1,N+1))

s_key = list(range(1,N+1))
#random.shuffle(key)
d = Dict()
for i in range(N-1,-1,-1):
  d.insert(key[i])


start_time = time.time()
for i in range(N):
  if i==9999:
      break
  result = d.search(s_key[i])
  if result == -1 or result != s_key[i]:
    print(result,s_key[i])
    print('탐색 오류')
    print(i)
end_time = time.time()-start_time


print("내림 차순 패트리샤 트리 탐색의 실행시간 (N=%d): %0.3f"%(N,end_time))
print("탐색완료")
d.head.left = d.head.right = d.head
N=10000
#maxb=16
key = list(range(1,N+1))
s_key = list(range(1,N+1))
random.shuffle(key)
d = Dict()
for i in range(0,N):
  d.insert(key[i])
start_time = time.time()
for i in range(N):
  result = d.search(s_key[i])
  if result == -1 or result != s_key[i]:
    print('탐색 오류')
    
end_time = time.time()-start_time


print("랜덤 차순 패트리새 트리 탐색의 실행시간 (N=%d): %0.3f"%(N,end_time))
print("탐색완료")
d.head.left = d.head.right = d.head.head=0
