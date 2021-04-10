
import random, time

class bitskey:
    def __init__(self,x):
        self.x=x
    def get(self):
        return  self.x
    def bits(self,k,j):
        return (self.x>>k) & ~(~0 << j)

class node:
    def __init__(self,key):
        if key.get() == 0:
            self.key = bitskey(0)
            self.external = False
        else :
            self.key=key
            self.external= True
        self.left=0
        self.right=0
class Dict:
    itemMin = bitskey(0)
    head=0
    head_check = False

    def search(self,v):
        v = bitskey(v)
        return self.searchR(self.head,v,maxb-1)

    def insert(self,v):
        v=bitskey(v)
        self.insertR(self.head,v,maxb-1)

    def insertR(self,h,v,d):
        if h==0:
            h=node(v)
            if self.head_check==False:
                self.head=h
            return h
        if h.external:
            leaf=node(v)
            h=self.split(leaf,h,d)
            if self.head_check == False:
                self.head= h
                self.head_check = True
            return h

        if v.bits(d,1) ==0:
            h.left=self.insertR(h.left,v,d-1)
        else:
            h.right = self.insertR(h.right,v,d-1)
        return h
    def split(self,p,q,d):
        t=node(self.itemMin)
        if ((p.key.bits(d,1)))*2+(q.key.bits(d,1))==0:
            t.left=self.split(p,q,d-1)
        elif ((p.key.bits(d,1)))*2 + (q.key.bits(d,1)) == 1:
            t.left=p
            t.right=q
        elif ((p.key.bits(d, 1))) * 2 + (q.key.bits(d, 1)) == 2:
            t.right=p
            t.left=q
        elif ((p.key.bits(d, 1))) * 2 + (q.key.bits(d, 1)) == 3:
            t.right=self.split(p,q,d-1)
        return t

    def searchR(self,h,v,d):
        if h==0:
            return self.itemMin

        if v.get() == h.key.get():
            return v.get()
        if v.bits(d,1) == 0:
            return self.searchR(h.left,v,d-1)
        else:
            return self.searchR(h.right,v,d-1)
    def check(self,n):
        for i in range(1,n+1):
            v=bitskey(i)
            tmp=''
            h=self.head
            d=maxb-1

            
            if v.bits(d,1) == 0:
                tmp+='left '
                h=h.left
                d-=1
            else:
                tmp+='right '
                h=h.right
                d-=1
            while h!=0:
                if v.get() == h.key.get():
                    break
                if v.bits(d,1) == 0:
                    tmp+='left '
                    h=h.left
                    d-=1
                else:
                    tmp+='right '
                    h=h.right
                    d-=1
            if h==0:
                continue
            print(i,tmp)


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


print("기수 트라이 탐색의 실행시간 (N=%d): %0.3f"%(N,end_time))
print("탐색완료")
d.head=0
d.itemMin=bitskey(0)
d.head_check=False
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


print("기수 트라이 탐색의 실행시간 (N=%d): %0.3f"%(N,end_time))
print("탐색완료")
d.head=0
d.itemMin=bitskey(0)
d.head_check=False
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


print("기수 트라이 탐색의 실행시간 (N=%d): %0.3f"%(N,end_time))
print("탐색완료")
d.head=0
d.itemMin=bitskey(0)
d.head_check=False
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


print("오름 차순 기수 트라이 트리 탐색의 실행시간 (N=%d): %0.3f"%(N,end_time))
print("탐색완료")
d.head=0
d.itemMin=bitskey(0)
d.head_check=False
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


print("내림 차순 기수 트라이 트리 탐색의 실행시간 (N=%d): %0.3f"%(N,end_time))
print("탐색완료")
d.head=0
d.itemMin=bitskey(0)
d.head_check=False
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


print("랜덤 차순 기수 트라이 트리 탐색의 실행시간 (N=%d): %0.3f"%(N,end_time))
print("탐색완료")
d.head=0
d.itemMin=bitskey(0)
d.head_check=False