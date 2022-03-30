#거스름돈 

a=int(input("거스름 받을 돈을 입력하세요:" ))
count=0
money=[500,100,50,10,5,1]
for i in money:

    count+=a//i
    print(count)
    a=a-(a//i)*i
    if a==0:break
print(count)






#분할 배낭 문제


def backpack(n,w):
    for i in range(n):
        weight,price=map(int,input("무게(kg)와 kg 당 가치를 순서대로 입력: ").split())
        w.append([weight,price])
    w.sort(key=lambda x: -x[1])
    return w 

def knapsack(b,w):
    weight=0
    price=0
    for i in w:
   
        weight+=i[0]
        price+=i[1]*i[0]
        if weight>b:
            price=price-i[1]*(weight-b)
    return price

b=int(input("배낭 무게 입력: "))
n=int(input("물건의 개수 입력:" ))
w=[]

w=backpack(n,w)
price=knapsack(b,w)
print("배낭의 가치는 "+str(price)+" 입니다.")



#MST KRUSKAL 알고리즘


import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline
print("정점의 수 입력: ")

N = int(input())
print("간선의 수 입력:")
M = int(input())
graph=[]
p=p=[0]*int(N+1)
height=[0]*int(N+1)



for j in range(M):
    print(str(M)+"번째 중"+str(j+1)+" 번재 출발 정점 , 도착 정점 , 가중치 입력: ")
    a,b,c = map(int, input().split())
    graph.append([a,b,c])
graph.sort(key=lambda x:x[2])

for j in range(N+1):
    p[j]=j 

def find(a): 
    if p[a] == a: 
        return a
    parent = find(p[a]) 
    p[a] = parent 
    return p[a]
def union(a,b):
    
        
        a,b=find(a),find(b)
        
        if height[a]>height[b]:
            p[b]=a
            
        else:
            p[a]=b
            if height[a]==height[b]:
                height[b]+=1
      


weight=0
ganseon=0
i=0

while True:

    if ganseon==N-1:
        break
    a,b,c=graph[i]
    
    if find(a)!=find(b):
            union(a,b)
            ganseon+=1
            
            
            weight+=c
   

    i+=1
print(weight)

        


        
        



