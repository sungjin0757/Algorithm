def exchangeSort(a,n):
    for i in range(1,n):
        for j in range(i+1,n+1):
            if a[i]<a[j]:
                a[i],a[j]=a[j],a[i]
       # print(a)

x=[-1,3,1,2,4,6,5,8,9,10,11]
exchangeSort(x,len(x)-1)