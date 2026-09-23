import socket
# 创建、绑定、监听
def create_bind():
    server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    server_socket.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)

    HOST = "127.0.0.1"
    PORT = 8888

    server_socket.bind((HOST, PORT))
    server_socket.settimeout(1.0)

    server_socket.listen(5)
    print(f"TCP服务器启动成功，监听 {HOST}:{PORT}")
    
    # server_client 是函数内部创建的局部变量，需要通过return把这个socket对象交给调用者
    return server_socket

# 让客户端收发数据
# 增加异常处理，如果当前的客户端接收、解码、发送异常，都可以关闭当前连接，返回到它的外层server_loop继续接收新的客户端
def handle_client(conn,client_addr):
    conn.settimeout(30)
    try:
        while True:
            try:
                recv_data = conn.recv(1024)
            except TimeoutError:
                print(f"客户端{client_addr}长时间没有发送数据，超时断开")
                continue
            
            if not recv_data:
                print(f"客户端{client_addr}断开连接")
                break
                    
            msg = recv_data.decode("utf-8")
            print(f"收到客户端消息：{msg}")
            
            rt_msg = "服务器已接受客户端消息"
            rt_bytes = rt_msg.encode("utf-8")
            conn.sendall(rt_bytes)
    except Exception  as e:
        print(e)
    finally:
        conn.close()

# 不断接受客户端连接
# 增加异常处理，出现异常会退出服务器循环
def server_loop(server_socket):
    while True:
        try:
            conn,client_addr = server_socket.accept()
            print(f"客户端接入: {client_addr}")
            handle_client(conn,client_addr)
        except TimeoutError:
            continue
        except Exception as e:
            print(e)
            break

if __name__ == "__main__":
    server_socket = create_bind()
    try:
        server_loop(server_socket)
    # Windows 系统上，阻塞的socket调用 accept()或recv() 不会响应KeyboardInterrupt信号
    # 当程序阻塞在 server_socket.accept() 或 conn.recv(1024) 时，即使按下 Ctrl+C，Python也无法立即抛出 KeyboardInterrupt，
    # 所以 try...except KeyboardInterrupt 不会被执行，需要设置socket超时处理，或者使用多线程处理客户端
    except KeyboardInterrupt:
        print("\n服务器停止")
    finally:
        server_socket.close()

