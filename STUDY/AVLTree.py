import random,time
class node:
    def __init__(self,key):
        
        self.key=key
        self.left=None
        self.right=None
        
class Dict:
    def __init__(self):
        self.node=None
        self.height=0
        self.balance=0
    
    def search(self,search_key):
        x=self.node
        
        while x!=None:
          
            if x.key==search_key:
                return x.key

            if x.key>search_key:
                x=x.left.node

            else:
                x=x.right.node

        return -1

    def insert(self,v):
        x=self.node
        
        if x==None:
            self.node=node(v)
            self.node.left=Dict()
            self.node.right=Dict()
        elif x.key>v:
            self.node.left.insert(v)
       
        else:
            self.node.right.insert(v)

        self.check_balance()
       
    def check_balance(self):
        self.update_heights(False)
        self.update_balances(False)
        
        while self.balance<-1 or self.balance>1:
            if self.balance>1:
                if self.node.left.balance<0:
                    self.node.left.rotate_left()
                self.rotate_right()
            else:
                if self.node.right.balance>0:
                    self.node.right.rotate_right()
                self.rotate_left()
            self.update_heights()
            self.update_balances()

    def rotate_right(self):
        g=self.node
        p=g.left.node
        x=p.right.node

        self.node=p
        p.right.node=g
        g.left.node=x
    def rotate_left(self):
        g=self.node
        p=g.right.node
        x=p.left.node

        self.node=p
        p.left.node=g
        g.right.node=x
    def update_heights(self,recurse=True):
        if self.node!=None:
            if recurse:
                if self.node.left!=None:
                    self.node.left.update_heights()
                if self.node.right!=None:
                    self.node.right.update_heights()
            self.height=max(self.node.left.height,self.node.right.height)+1
        else:
            self.height=0
    def update_balances(self,recurse=True):
        if self.node!=None:
            if recurse:
                if self.node.left!=None:
                    self.node.left.update_balances()
                if self.node.right!=None:
                    self.node.right.update_balances()
            self.balance=self.node.left.height-self.node.right.height
        else:
            self.balance=0
    def check(self):
        maxtmp=0
        x=self.node

        while x!=None:
            maxtmp=x.key
            x=x.right.node
        for i in range(1,maxtmp+1):
            x=self.node
            p=None
            while x.key!=i:
                p=x
                if x==None:
                    break
                if x.key>i:
                    x=x.left.node
                else:
                    x=x.right.node
            if p==None:
                print("key: ",x.key," parent: ",x.key)
            elif x!=None:
                print("key: ",x.key," parent: ",p.key)
       
        

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


print("AVL 트리 탐색의 실행시간 (N=%d): %0.3f"%(N,end_time))
print("탐색완료")

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


print("AVL 트리 탐색의 실행시간 (N=%d): %0.3f"%(N,end_time))
print("탐색완료")

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


print("AVL 트리 탐색의 실행시간 (N=%d): %0.3f"%(N,end_time))
print("탐색완료")

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


print("오름차순 AVL 트리 탐색의 실행시간 (N=%d): %0.3f"%(N,end_time))
print("탐색완료")

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


print("내림 차순 AVL 트리 탐색의 실행시간 (N=%d): %0.3f"%(N,end_time))
print("탐색완료")


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


print("랜덤 차순 AVL 트리 탐색의 실행시간 (N=%d): %0.3f"%(N,end_time))
print("탐색완료")
