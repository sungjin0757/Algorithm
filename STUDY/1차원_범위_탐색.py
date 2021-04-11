#import geo as g

class Range:

    class node:
        key=0
        l=None
        r=None
        def __init__(self,kk,ll,rr):
            self.key=kk
            self.l=ll
            self.r=rr

    z=node(0,None,None)
    z.l=z
    z.r=z
    head=node(0,None,z)

    def insert(self,v):
        p=self.head
        x=self.head.r
        while x!=self.z:
            p=x
            if x.key==v:
                return
            if x.key>v:
                x=x.l
            else:
                x=x.r
        x=self.node(0,None,None)
        x.key=v
        x.l=self.z
        x.r=self.z
        if p.key>v:
            p.l=x
        else:
            p.r=x
    def search(self,v1,v2):
        return self.searchr(self.head.r,v1,v2)

    def searchr(self,t,v1,v2):
        count=0
        
        if v1<=t.key<=v2:
            print(t.key)
        if t==self.z:
            return 0
        if t.key>=v1:
            count+=self.searchr(t.l,v1,v2)   
            
        if t.key>=v1 and t.key<=v2:
            count+=1
        if t.key<=v2:
            count+=self.searchr(t.r,v1,v2)
        
        
        return count
N=8

r=Range()
key_list=[2,1,7,8,6,3,5,4]
for i in range(N):
    r.insert(key_list[i])
result=r.search(3,7)
print('방문 노드의 개수 : ',result)