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
while True:
    Input = input('Your message: ')
    ClientSocket.send(str.encode(Input))
    Response = ClientSocket.recv(2048)
    print("ID\tAddress\tMobile\t\tDept_id\tC_id")
    print(Response.decode('utf-8'))
ClientSocket.close()
