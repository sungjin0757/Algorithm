import sys
#sys.stdin=open("input.txt","rt")

n=int(input())
a=[input() for _ in range(n)]
alp=[0]*26
for x in a:
    for j in range(len(x)):
        alp[ord(x[-j-1])-ord('A')]+=pow(10,j)
alp.sort(reverse=True)
res=0

for i in range(9,0,-1):
    res+=alp[9-i]*i
    
print(res)
