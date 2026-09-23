import socket

client_socket = socket.socket(socket.AF_INET,socket.SOCK_STREAM)

server_host = '127.0.0.1'
server_port = 8888
client_socket.connect((server_host,server_port))

while True:
    input_msg = input("输入发送消息（输入quit可退出）：\n")
    if input_msg == "quit":
        break
    client_socket.send(input_msg.encode('utf-8'))
    
    res_data = client_socket.recv(1024)
    print(f"客户端收到服务器回复：【{res_data.decode('utf-8')}】") 
    
client_socket.close()