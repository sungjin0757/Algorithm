import sys
sys.stdin=open("input.txt","rt")

n=int(input())
a=[]
b=[]
c=[]
for i in range(n):
    tmp=int(input())
    if tmp>1:
        a.append(tmp)
    elif tmp<0:
        b.append(tmp)
    else:
        c.append(tmp)
a.sort(reverse=True)
b.sort()
res=0
if len(a)%2==0:
    for i in range(0,len(a)-1,2):
        res+=a[i]*a[i+1]
elif len(a)%2==1:
    for i in range(0,len(a)-1,2):
        res+=a[i]*a[i+1]
    res+=a[len(a)-1]

if len(b)%2==0:
    for i in range(0,len(b)-1,2):
        res+=b[i]*b[i+1]
elif len(b)%2==1:
    for i in range(0,len(b)-1,2):
        res+=b[i]*b[i+1]
    if 0 not in c:
        res+=b[len(b)-1]
res+=sum(c)

print(res)
    