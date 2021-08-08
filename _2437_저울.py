import sys
sys.stdin=open("input.txt","rt")

n=int(input())
a=sorted(map(int,input().strip().split()))
res=0

print(a)
for i in range(n):
    if res+1>=a[i]:
        res+=a[i]
    else:
        break
print(res+1)