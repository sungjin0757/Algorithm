import sys
#sys.stdin=open("input.txt","rt")
sys.setrecursionlimit(10**6)
n=int(input())
w=int(input())

a=[]

for i in range(w):
    x,y=map(int,input().split())
    a.append([x,y])
a.insert(0,0)

dy=[[0]*(w+1) for _ in range(w+1)]

def solv(x,y):
    if x==w or y==w:    
        return 0
    if dy[x][y]!=0:
        return dy[x][y]

    next=max(x,y)+1

    if x==0:
        car_1_dis=abs(1-a[next][0])+abs(1-a[next][1])
    else:
        car_1_dis=abs(a[x][0]-a[next][0])+abs(a[x][1]-a[next][1])

    if y==0:
        car_2_dis=abs(n-a[next][0])+abs(n-a[next][1])
    else:
        car_2_dis=abs(a[y][0]-a[next][0])+abs(a[y][1]-a[next][1])

    dy[x][y]=min(solv(next,y)+car_1_dis,solv(x,next)+car_2_dis)
    
    return dy[x][y]
res=[]
def bt(x,y):
    if x==w or y==w:

        return
    next=max(x,y)+1

    if x==0:
        car_1_dis=abs(1-a[next][0])+abs(1-a[next][1])
    else:
        car_1_dis=abs(a[x][0]-a[next][0])+abs(a[x][1]-a[next][1])

    if y==0:
        car_2_dis=abs(n-a[next][0])+abs(n-a[next][1])
    else:
        car_2_dis=abs(a[y][0]-a[next][0])+abs(a[y][1]-a[next][1])

    if solv(next,y)+car_1_dis<solv(x,next)+car_2_dis:
        bt(next,y)
        res.append(1)
    else:
        bt(x,next)
        res.append(2)
    return
print(solv(0,0))
bt(0,0)
for i in range(w):
    print(res[-i-1])
