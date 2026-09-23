"""
演示进程操作共享空间
"""

import multiprocessing

def add_num(share_list,lock,num):
    lock.acquire()
    try:
        share_list.append(num)
    finally:
        lock.release()
        
if __name__ == "__main__":
    # 创建管理器
    manager = multiprocessing.Manager()
    # 创建跨进程共享列表
    share_data = manager.list()
    # 创建进程锁
    lock = multiprocessing.Lock()
    
    # 存储创建的子进程，将来主进程等待子进程执行完成
    p_list = []
    
    for i in range(25):
        p = multiprocessing.Process(target=add_num,args=(share_data,lock,i)) 
        p.start()
        p_list.append(p)
    
    # 等待所有子进程运行完成
    for p in p_list:
        p.join()
        
    print("最终共享列表",share_data)