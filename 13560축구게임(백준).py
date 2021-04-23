import sys
sys.stdin=open("input.txt","rt")

n=int(input())
a=list(map(int,input().split()))


a.sort()

cnt=0
res=1

for i in range(n):
    cnt+=a[i]
    if cnt<i*(i+1)/2:
        res=-1
        break

if cnt!=n*(n-1)/2:
    res=-1

print(res)