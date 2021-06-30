import sys
sys.stdin=open("input.txt","rt")

w=int(input())
word_temp=[sys.stdin.readline().strip() for _ in range(w)]

dx=[-1,-1,-1,0,0,1,1,1]
dy=[1,0,-1,-1,1,1,0,-1]
def DFS(x,y,z,word_len):
    global point
   
    if tmp[z-1]!=check[z-1]:
        return
    if check in res:
        return
    if z>=word_len:
        tmp_s=''.join(tmp)
        
        if tmp_s in word_temp:
            res.append(tmp_s)
            if 4>=word_len>=3:
                point+=1
            elif word_len==5:
                point+=2
            elif word_len==6:
                point+=3
            elif word_len==7:
                point+=5
            elif word_len==8:
                point+=11
    else:
        for i in range(8):
            xx=x+dx[i]
            yy=y+dy[i]
            if 0<=xx<4 and 0<=yy<4 and ch[xx][yy]==0:
                ch[xx][yy]=1
                tmp[z]=grid[xx][yy]
                
                DFS(xx,yy,z+1,word_len)
                ch[xx][yy]=0
  
input()
b=int(input())

for i in range(b):
    grid=[list(map(str,sys.stdin.readline().strip()))for _ in range(4)]
    ch_2=[0]*len(word_temp)
    res=list()
    point=0
    mlen=''
    ch=[[0]*4 for _ in range(4)]

    for j in range(4):
        for k in range(4):
            for s in range(len(word_temp)):
                if ch_2[s]==0:
                    if grid[j][k]==word_temp[s][0]:
                        ch[j][k]=1
                        tmp=[0]*len(word_temp[s])
                        tmp[0]=word_temp[s][0]
                        check=word_temp[s]
                        DFS(j,k,1,len(word_temp[s]))
                        ch[j][k]=0
                        if word_temp[s] in res:
                            ch_2[s]=1
                   
    if i<b-1:
        input()
    
    cnt=len(res)
    mlen=''
    tmp=[]
    for j in range(cnt):
        if len(res[j])>len(mlen):
            mlen=res[j]
    for j in range(cnt):
        if len(res[j])==len(mlen):
            tmp.append(res[j])
    if len(tmp)<=1:
        print(point,mlen,cnt)
    else:
        tmp.sort()
        print(point,tmp[0],cnt)
    
