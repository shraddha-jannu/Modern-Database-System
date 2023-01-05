import mysql.connector
import socket

conn=mysql.connector.connect(host='localhost',username='root',password='root',database='MDS')
my_curr=conn.cursor()
#create sockets using socket method
s=socket.socket(socket.AF_INET,socket.SOCK_STREAM)
s.bind((socket.gethostname(),1025))

s.listen(1024)

my_curr.execute("select * from department")
result1=my_curr.fetchall()
#department table display
print("\nDepartment Table :")
print("Dept_id\tDept_name")
for row in result1:
    for col in row:
        print(col, end='\t')
    print()
   
my_curr.execute("select * from customer")
result2=my_curr.fetchall()
#customer table display
print("\nCustomer Table :")
print("Cust_id\t\tFirst_name\tLast_name\tDept_id")
for row in result2:
    for col in row:
        print(col, end='\t\t')
    print()
        
while True:
    try:
            
        sol=[]
        for x in result2:
            if(x[3] is not None):
                for v in result1:
                    if(x[3]==v[0]):
                        str1=str(v[0])+"\t"+str(v[1])+"\t\t"+str(x[1])+"\t\t"+str(x[2])+"\n"
                        sol.append(str1)
                        break
        
    except:
        conn.rollback()
    clt,adr=s.accept()
    print(f"connection to {adr} established ")
    for x in sol:
        '''str1=''
        for i in x:
            str1+=str(i)+" "
        clt.send(bytes(str1,"utf-8"))'''
        clt.send(bytes(x,"utf-8"));
        #print(x)
    clt.close()


