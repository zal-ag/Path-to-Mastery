import socket

# 创建服务器socket，这个服务器在后续负责监听和接受新连接（socket可以理解成程序进行网络通信的接口）
# 参数1：使用IPv4地址，比如 127.0.0.1
# 参数2：使用流式套接字，这里对应TCP
server_socket = socket.socket(socket.AF_INET,socket.SOCK_STREAM)

# 这里是设置socket选项
# 参数1：设置socket层面的选项
# 参数2：启用地址复用
# 参数3：开启该选项
server_socket.setsockopt(socket.SOL_SOCKET,socket.SO_REUSEADDR,1)

HOST = '127.0.0.1' # IP
PORT = 8888 # 端口

# 绑定IP和端口，相当于告诉操作系统：这个服务器要在本机的8888端口接收连接
# (HOST,PORT) 作为元组传入，0.0.0.0 表示监听本机所有 IPv4 网络接口
server_socket.bind((HOST,PORT))

# 将socket设置为监听状态
server_socket.listen(5)
print(f"TCP服务器启动成功，监听 {HOST}:{PORT}")

while True:
    # accept() 会从等待队列里取出一个连接，没有可接受的连接的话，程序会等待
    # conn：专门与这个客户端通信的新socket
    # client_addr：客户端的IP与端口
    conn,client_addr = server_socket.accept()
    print(f"客户端接入: {client_addr}")
    
    while True:
        # 从这个连接接受数据，一次最多返回1024字节；暂时没有数据的话会阻塞等待
        recv_data = conn.recv(1024)
        if not recv_data:
            print(f"客户端{client_addr}断开连接")
            break
        # 收到客户端消息要进行解码，因为网络传输的是字节
        msg = recv_data.decode('utf-8')
        print(f"收到客户端消息：{msg}")
        
        rt_msg = "服务器已接受客户端消息"
        # 同样地，发送前要进行编码
        rt_bytes = rt_msg.encode('utf-8')
        # send()只会返回本次成功发送的字节数
        # sendall()内部会循环调用send，直到数据全部发送，若出现异常，则抛出
        conn.send(rt_bytes)
    
    # 当内存循环break时，执行该命令，客户端对应的socket关闭
    conn.close()
    # 之后程序会回到外层循环，继续接受下一个客户端
