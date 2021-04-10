scan=-1
ch=[' ',' ','A','B',' ','C',' ']
next1=[4,2,4,4,5,6,0]
next2=[4,3,4,4,1,6,0]
class Deque:
    def __init__(self, size):
        self.deque=[]
        self.first=int(size/2)
        self.last=int(size/2)
        for i in range(size):
            self.deque.append(0)

    def insertFirst(self,v):
        self.deque[self.first]=v
        self.first-=1
    def insertLast(self,v):
        self.last+=1
        self.deque[self.last]=v
    def deleteFirst(self):
        self.deque[self.first]=0
        self.first+=1
        return self.deque[self.first]
    def isEpty(self):
        if self.first==self.last:
            return True
        else:
            return False
    def checkDq(self):
        if self.deque[self.first]==0:
            if self.last-self.first<2 and self.deque[self.last]==scan:
                return False
            elif not self.isEpty():
                return True
            else:
                return False
        else:
            return False
    def prDq(self,size):
        for i in range(size):
            if self.deque[i]!=0:
                print(self.deque[i],end=' ')
        print()
def match(t):
    dq=Deque(100)
    j=0
    N=len(t)-1
    state=next1[0]
    dq.insertLast(scan)

    while state:
        dq.prDq(100)
        if state==scan:
            j+=1
            if dq.isEpty():
                dq.insertFirst(next1[0])
            dq.insertLast(scan)
        elif ch[state]==t[j]:
            dq.insertLast(next1[state])
        elif ch[state]==' ':
            n1=next1[state]
            n2=next2[state]
            dq.insertFirst(n1)
            if n1!=n2:
                dq.insertFirst(n2)
        if dq.isEpty():
            return j
        if j>N:
            return 0
        state=dq.deleteFirst()
        if dq.checkDq():
            state=dq.deleteFirst()

    return j-1

text='ABBC'
match(text)
