import socket
def create_bind():
    server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    server_socket.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)

    HOST = "0.0.0.0"
    PORT = 8888

    server_socket.bind((HOST, PORT))

    server_socket.listen(5)
    print(f"TCP服务器启动成功，监听 {HOST}:{PORT}")
    
    return server_socket

def handle_client(conn,client_addr):
    try:
        while True:
            recv_data = conn.recv(1024)
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
    
def server_loop(server_socket):
    while True:
        try:
            conn,client_addr = server_socket.accept()
            print(f"客户端接入: {client_addr}")
            handle_client(conn,client_addr)
        except Exception as e:
            print(e)
            break
        
if __name__ == "__main__":
    server_socket = create_bind()
    try:
        server_loop(server_socket)
    except:
        print("服务器停止")
    finally:
        server_socket.close()

    