import multiprocessing
import time

class Myprocess(multiprocessing.Process):
    
    def __init__(self,name,delay):
        super().__init__()
        self.name = name
        self.delay = delay
        
    def run(self):
        print(f"子进程：{self.name}启动，PID：{multiprocessing.current_process().pid}")
        time.sleep(self.delay)
        print(f"子进程{self.name}执行完毕")


print(f"main函数PID：{multiprocessing.current_process().pid}\n" f"__name__：{__name__}")

if __name__ == "__main__":
    print(f"主进程PID：{multiprocessing.current_process().pid}")

    # 创建子进程实例 
    p1 = Myprocess("C",1.5)

    # 启动子进程
    p1.start()

    # join():主进程阻塞，等待子进程执行完毕再往下走
    p1.join()

    print("子进程执行完毕，主进程退出")
