import multiprocessing

def producer(q):
    """生产者：向队列写入数据"""
    for i in range(10):
        q.put(f"数据{i}")
        print(f"生产者写入：数据{i}")
        # 生产者发出结束标识
    q.put("end")

def consumer(q):
    """消费者：从队列读取数据"""
    while True:
        # 队列为空则阻塞
        data = q.get()
        print(f"消费者读取：{data}")
        if data == "end":
            break
        
if __name__ == "__main__":
    # 创建进程安全队列
    queue = multiprocessing.Queue(maxsize=10)
    # 创建生产者进程
    p_pro = multiprocessing.Process(target=producer,args=(queue,))
    # 创建消费者进程
    p_con = multiprocessing.Process(target=consumer,args=(queue,))
    # 启动两个进程
    p_pro.start()
    p_con.start()
    
    p_pro.join()
    p_con.join()
    
    print("通信完成")