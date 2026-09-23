import threading
import time

class MyThread(threading.Thread):
    def __init__(self,name,delay):
        super().__init__()
        self.name = name
        self.delay = delay
    def run(self):
        print(f"线程{self.name}启动，休眠{self.delay}s")
        time.sleep(self.delay)
        print(f"线程{self.name}执行完毕")
t1 = MyThread("A",1)
t2 = MyThread("B",2)
t1.start()
t2.start()
t1.join()
t2.join()
print("所有子进程执行完毕，主进程退出")
        