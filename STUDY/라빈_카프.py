def index(c):
    if ord(c)==32:
        return 0
    else:
        return ord(c)-64
def RK(p,t,k):
    dM=1
    h1=0
    h2=0
    M=len(p)
    N=len(t)
   
    for i in range(1,M):
        dM=(d*dM)%q

    for i in range(M):
        h1=(h1*d+index(p[i]))%q
        

    i=k
    j=0
    while i<N and j<M:
        h2=(h2*d+index(t[i]))%q
        i+=1
        j+=1

    i=k
    while h1!=h2:
        if i+M>=N:
            return N
        h2=(h2+d*q-index(t[i])*dM)%q
        h2=(h2*d+index(t[i+M]))%q
        
        if i>N-M:
            return N
        i+=1
    return i

d=10
q=23

text='STRING STARTING CONSISTING'
pattern='STING'
k=0
M=len(pattern)
N=len(text)

while True:
    pos=RK(pattern,text,k)
    k=pos+M
    if k<=N:
        print('패턴이 나타난 위치: ',pos)
    else:
        break
