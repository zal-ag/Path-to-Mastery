import multiprocessing

def pipe_child(conn):
    conn.send("子进程消息1")
    print(f"子进程收到：{conn.recv()}")
    conn.close()
    
if __name__ == "__main__":
    # 创建管道，返回两端连接对象
    parent_conn,child_conn = multiprocessing.Pipe()
    p = multiprocessing.Process(target=pipe_child,args=(child_conn,))
    p.start()
    
    print(f"主进程收到：{parent_conn.recv()}")
    parent_conn.send("主进程回复信息")
    p.join()