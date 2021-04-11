
def encipher(p,k):
    c=''
    n=len(k)
    for i in range(len(p)):
        a=ord(p[i])
        if a==32:
            a=64
        b=ord(k[i%n])-64
        t=a+b
        if t>90:
            t-=27
        if t==64:
            t=32
        c+=chr(t)
    return c

def decipher(p,k):
    c=''
    n=len(k)
    for i in range(len(p)):
        a=ord(p[i])
        b=ord(k[i%n])-64
        t=a-b
        if t<65:
            t+=27
        if t>90:
            t-=27
        if t==64:
            t=32
        c+=chr(t)
    return c
plainText='SAVE PRIVATE RYAN'
k='ABC'
print('평 문:',plainText)
cipherText=encipher(plainText,k)
print('암호문:',cipherText)
decipherText=decipher(cipherText,k)
print('복호문:',decipherText)