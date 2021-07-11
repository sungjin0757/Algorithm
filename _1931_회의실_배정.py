n=int(input())
a=[]
for i in range(n):
    b,c=map(int,input().split())
    a.append((b,c))
a.sort(key=lambda x:(x[1],x[0]))
cnt=1
tmp=a[0][1]
for i in range(1,n):
    if a[i][0]>=tmp:
        cnt+=1
        tmp=a[i][1]
print(cnt)