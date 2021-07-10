n=1000-int(input())
a=[500,100,50,10,5,1]
a.sort()

cnt=0
while n!=0:

    tmp=a.pop()
    cnt+=n//tmp
    n=n%tmp
  
print(cnt)