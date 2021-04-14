import sys
#sys.stdin=open("input.txt","rt")

example=input().split('-')
res=0
for i in example[0].split('+'):
    res+=int(i)
for i in example[1:]:
    for j in i.split('+'):
        res-=int(j)
print(res)
