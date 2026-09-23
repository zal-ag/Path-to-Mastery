import multiprocessing
import time

"""进程运行需要执行任务，定义内容task"""
def task(name,delay):
    '''
    子进程执行函数
    :param name:参数，接受子进程名称
    :param delay:参数，接受延迟的时间s
    :return:None
    '''
    print(f"子进程：{name}启动，PID：{multiprocessing.current_process().pid}")
    time.sleep(delay)
    print(f"子进程{name}执行完毕")

print(f"main函数PID：{multiprocessing.current_process().pid}\n"
      f"__name__：{__name__}")

if __name__ == "__main__":
    print(f"主进程PID：{multiprocessing.current_process().pid}")
    
    # 创建两个子进程
    p1 = multiprocessing.Process(target=task,args=("A",2))
    p2 = multiprocessing.Process(target=task,kwargs={"name":"B",
                                                   "delay":3})
    
    # 启动子进程
    p1.start()
    p2.start()
    
    # join():主进程阻塞，等待子进程执行完毕再往下走
    p1.join()
    p2.join()
    
    print("所有子进程执行完毕，主进程退出")
