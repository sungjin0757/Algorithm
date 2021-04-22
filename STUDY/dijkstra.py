import sys
import heapq
#sys.stdin=open("input.txt","rt")

INF=int(1e9)
n,m=map(int,input().split())

graph=[[]for _ in range(n+1)]
dis=[INF]*(n+1)
q=[]

for _ in range(m):
    a,b,c=map(int,input().split())
    graph[a].append((b,c))

dis[1]=0
heapq.heappush(q,(1,0))

while q:
    now,distance=heapq.heappop(q)

    if dis[now]<distance:
        continue

    for row in graph[now]:
        if row[1]+distance<dis[row[0]]:
            dis[row[0]]=row[1]+distance
            heapq.heappush(q,(row[0],row[1]+distance))

print(dis)
