
import geo as g
import math

class node:
    def __init__(self):
        self.p = g.point(max, max, '')
        self.next = None

def comp(t):
    if t_pass == 1:

        return t.p.x
    else:
        return t.p.y

def merge(a, b):
    c = z
    while True:
        if(comp(a) < comp(b)):
            c.next = a
            c = a
            a = a.next
        else:
            c.next = b
            c = b
            b = b.next
        if c==z:
            break
    #print('{0}\t{1}\t{2}\t{3}\t{4}\t{5}\t{6}'.format(min, cp1.c, cp2.c, 2, 3, 4, 5))
    c = z.next
    z.next = z
    return c

def check(p1, p2):
    global min, cp1, cp2
    if (p1.y != z.p.y) and (p2.y != z.p.y):
        dist = (p1.x-p2.x) * (p1.x-p2.x) + (p1.y-p2.y) * (p1.y-p2.y)
        if dist < min:
            min = dist
            cp1 = p1
            cp2 = p2

def sort(c, N):
    if c.next == z: return c
    a = c
    for i in range(2, (N//2) + 1):
        c = c.next
    b = c.next
    c.next = z
    c = merge(sort(a, N//2), sort(b, N-(N//2)))

    if t_pass == 2:
        middle = b.p.x
        p1=z.p
        p2=z.p
        p3=z.p
        p4=z.p
        a=c
        
        while a != z:
            if math.fabs(a.p.x-middle) < min:
                check(a.p,p1)
                check(a.p, p2)
                check(a.p, p3)
                check(a.p, p4)
                p1=p2
                p2=p3
                p3=p4
                p4=a.p
                print('{0}\t{1}\t{2}\t{3}\t{4}\t{5}\t{6}'.format(min, cp1.c, cp2.c, p1.c, p2.c, p3.c, p4.c))
            a=a.next

    return c

def readlist():
    p = node()
    h = p
    for i in range(N):
        t = node()
        t.p.x = g.x_value[i]
        t.p.y = g.y_value[i]
        t.p.c = g.c_value[i]
        p.next = t
        p = p.next
    p.next = z
    return h

N = 8
max = 1000
cp1 = g.point(max, max, '')
cp2 = g.point(max, max, '')
min = max

z = node()
z.p.x = max
z.p.y = max
z.next = z
h = node()
h.next = readlist()

t_pass = 1
h.next = sort(h.next, N)
t_pass = 2
h.next = sort(h.next, N)
print('min = %.3f, cp1 = %s, cp2 = %s'%(min,cp1.c,cp2.c))