import socket
host = '127.0.0.1'
port = 1233

ClientSocket = socket.socket()
print('Waiting for connection')
try:
    ClientSocket.connect((host, port))
except socket.error as e:
    print(str(e))
Response = ClientSocket.recv(2048)
arr1=[]
while True:
    Input = input('Your message: ')
    ClientSocket.send(str.encode(Input))
    Response = ClientSocket.recv(2048)
    arr1.append(Response.decode('utf-8'))
    sol=arr1[0].split('\n')

    #sorting the table
    if(sol[-1].split(':')[0]=="sort"):
        s=[]
    
        for i in range(len(sol)-1):
            val=sol[i].split('\t')
            s.append(float(val[3]))
        s.sort(reverse=True)
        sorted_arr=[]

        print("\nsorting the data based on th cgpa");
        for j in range(len(s)):
            for i in range(len(sol)-1):
                val=sol[i].split('\t')
                if(s[j]==float(val[3])):
                    sorted_arr.append(sol[i])

        print("ID\tDiv\tBranch\tCGPA")
        for i in sorted_arr:
            print(i)

    #unique values of branch     
    elif(sol[-1].split(':')[0]=="select1"):
        set1=set()
        l=int(sol[-1].split(":")[1])
        s=[]

        for i in range(len(sol)-1):
            val=sol[i].split('\t')
            set1.add(val[l])

        print("\nprinting unique values of division in range 1-5")
        for i in set1:
            print(i)

    #unique values of div   
    else:
        set1=set()
        l=int(sol[-1].split(":")[1])
        s=[]

        for i in range(len(sol)-1):
            val=sol[i].split('\t')
            set1.add(val[l])

        print("\nselecting unique values of branch in range 11-15")
        for i in set1:
            print(i)
ClientSocket.close()
