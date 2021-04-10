
import random
import time
class node:
    def __init__(self,key=None,left=None,right=None):
        self.key=key
        self.left=left
        self.right=right
class Dict:
    x=p=node()
    z=node(key=0,left=0,right=0)
    z.left=z
    z.right=z
    head=node(key=0,left=0,right=z) 
    #def __init__(self):
      
    def search(self,search_key):
        x=self.head.right
        while x!=self.z:
           # print(x.key,"를 거쳤습니다!")
            if x.key==search_key:
                return x.key
            if x.key>search_key:
                x=x.left
            else:
                x=x.right
        return -1
    def insert(self,v):
        x = p = self.head
        while (x != self.z):
          p = x
          if x.key == v:
            return
          if x.key > v:
            x = x.left
          else:
            x = x.right
        x = node(key=v, left = self.z, right = self.z)
        if p.key > v:
          p.left = x
        else:
          p.right = x

N= 10000

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


print("이진 탐색 트리 탐색의 실행시간 (N=%d): %0.3f"%(N,end_time))
print("탐색완료")
d.head.right=d.z
N= 20000

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


print("이진 탐색 트리 탐색의 실행시간 (N=%d): %0.3f"%(N,end_time))
print("탐색완료")
d.head.right=d.z
N= 30000

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


print("이진 탐색 트리 탐색의 실행시간 (N=%d): %0.3f"%(N,end_time))
print("탐색완료")
d.head.right=d.z
print()
N= 10000

key = list(range(1,N+1))
s_key = list(range(1,N+1))
#random.shuffle(key)
d = Dict()
for i in range(0,N):
  d.insert(i+1)
start_time = time.time()
for i in range(N):
  result = d.search(s_key[i])
  if result == -1 or result != s_key[i]:
    print('탐색 오류')
end_time = time.time()-start_time


print("오름 차순 이진 탐색 트리 탐색의 실행시간 (N=%d): %0.3f"%(N,end_time))
print("탐색완료")
d.head.right=d.z
N= 10000

key = list(range(1,N+1))
s_key = list(range(1,N+1))
#random.shuffle(key)
d = Dict()
for i in range(N,0,-1):
  d.insert(i)
start_time = time.time()
for i in range(N):
  result = d.search(s_key[i])
  if result == -1 or result != s_key[i]:
    print('탐색 오류')
end_time = time.time()-start_time


print("내림 차순 이진 탐색 트리 탐색의 실행시간 (N=%d): %0.3f"%(N,end_time))
print("탐색완료")
d.head.right=d.z

N= 10000

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


print("랜덤 차순 이진 탐색 트리 탐색의 실행시간 (N=%d): %0.3f"%(N,end_time))
print("탐색완료")
d.head.right=d.z

