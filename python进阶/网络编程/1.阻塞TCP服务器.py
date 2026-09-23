import socket

# 创建服务器socket，后续负责监听和接受新连接（socket可以理解成程序进行网络通信的接口）
# 参数1：使用IPv4地址，比如 127.0.0.1
# 参数2：使用流式套接字，这里对应TCP
server_socket = socket.socket(socket.AF_INET,socket.SOCK_STREAM)

# 这里是设置socket选项
# 参数1：设置socket层面的选项
# 参数2：启用地址复用
# 参数3：开启该选项
server_socket.setsockopt(socket.SOL_SOCKET,socket.SO_REUSEADDR,1)

HOST = '0.0.0.0'
PORT = 8888

# 绑定IP和端口，相当于告诉操作系统：这个服务器要在本机的8888端口接收连接
server_socket.bind((HOST,PORT))

server_socket.listen(5)
print(f"TCP服务器启动成功，监听 {HOST}:{PORT}")

while True:
    conn,client_addr = server_socket.accept()
    print(f"客户端接入: {client_addr}")
    
    while True:
        recv_data = conn.recv(1024)
        if not recv_data:
            print(f"客户端{client_addr}断开连接")
            break
        msg = recv_data.decode('utf-8')
        print(f"收到客户端消息：{msg}")
        
        rt_msg = "服务器已接受客户端消息"
        rt_bytes = rt_msg.encode('utf-8')
        
        conn.send(rt_bytes)
    
    conn.close()
    
