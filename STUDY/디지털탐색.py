import random,time

class bitskey:
    def __init__(self, x):
        self.x = x
    
    def get(self):
        return self.x
    
    def bits(self, k, j):
        return (self.x >> k) & ~(~0 << j)

class node:
    def __init__(self, key):
        self.key = bitskey(key)
        self.left = None
        self.right = None

class Dict:
    itemMin = bitskey(0)
    
    z = node(itemMin)
    head = node(itemMin)
    head.left = z
    head.right = z
    
    def search(self, v):
        v = bitskey(v)
        x = self.head.left
        b = maxb
        self.z.key = v
        while v.get() != x.key.get():
            b = b-1
            if v.bits(b, 1):
                x = x.right
            else:
                x = x.left
        
        if x == self.z:
            return -1
        else:
            return x.key.get()
        
    def insert(self, v):
        v = bitskey(v)
        b = maxb-1
        x = self.head.left
        p = self.head
        
        while x.key.get() != self.z.key.get():
            p = x
            if v.bits(b, 1):
                x = x.right
            else:
                x = x.left
            b -=1
        
        x = node(self.itemMin)
        x.key = v
        x.left = self.z
        x.right = self.z
        if v.bits(b+1, 1):
            p.right = x
        else:
            p.left = x
    def check(self,n):
        for i in range(1,n+1):
            x = self.head.left
            p = self.head
            b=maxb
            tmp=bitskey(i)
            while x.key.get()!=tmp.get() and x.key.get()!=self.z.key.get():
                p=x
                b-=1
                if tmp.bits(b, 1):
                    x = x.right
                else:
                    x = x.left
         
            if x == self.z:
                continue
            if p==self.head:
                print('key: ',x.key.get(),' parent: ',x.key.get())
            elif x!=self.head.left:
                print('key: ',x.key.get(),' parent: ',p.key.get())

print("maxb는 16으로 설정")
N=10000
maxb=16
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


print("디지털 트리 탐색의 실행시간 (N=%d): %0.3f"%(N,end_time))
print("탐색완료")
d.head.left=d.z
d.head.right=d.z
N= 20000
maxb=16
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


print("디지털 트리 탐색의 실행시간 (N=%d): %0.3f"%(N,end_time))
print("탐색완료")
d.head.left=d.z
d.head.right=d.z
N= 30000
maxb=16
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


print("디지털 트리 탐색의 실행시간 (N=%d): %0.3f"%(N,end_time))
print("탐색완료")
d.head.left=d.z
d.head.right=d.z
print()
N= 10000
maxb=14
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


print("오름 차순 디지털 트리 탐색의 실행시간 (N=%d): %0.3f"%(N,end_time))
print("탐색완료")
d.head.left=d.z
d.head.right=d.z
N= 10000
maxb=14
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


print("내림 차순 디지털 트리 탐색의 실행시간 (N=%d): %0.3f"%(N,end_time))
print("탐색완료")
d.head.left=d.z
d.head.right=d.z
N=10000
maxb=16
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


print("랜덤 차순 디지털 트리 탐색의 실행시간 (N=%d): %0.3f"%(N,end_time))
print("탐색완료")