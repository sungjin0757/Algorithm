def cocktailsort(a,n):
    left=1
    right=n
    
    while right>left:
        for i in range(left,right):
            if a[i]>a[i+1]:
                a[i],a[i+1]=a[i+1],a[i]
                flag=True
        
        right-=1
        print(a)
        for i in range(right,left,-1):
            if a[i]<a[i-1]:
                a[i],a[i-1]=a[i-1],a[i]
                flag=True
        
        left+=1
        print(a)

x=[-1,6,5,4,3,2,1]
cocktailsort(x,len(x)-1)