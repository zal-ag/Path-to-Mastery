import threading
import time

def task(name,delay):
    print(f"线程{name}启动，休眠{delay}s")
    time.sleep(delay)
    print(f"线程{name}执行完毕")

t1 = threading.Thread(target=task,args=("A",1))
t2 = threading.Thread(target=task,kwargs={"name":"B",
                                          "delay":2})
t1.start()
t2.start()
t1.join()
t2.join()
print("所有子进程执行完毕，主进程退出")