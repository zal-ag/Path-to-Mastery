import threading
import time 

def daemon_task():
    while True:
        print("守护线程运行中...")
        time.sleep(1)

def task():
    print("子线程开始执行")
    time.sleep(3)
    print("子线程执行完毕")
    
if __name__ == "__main__":
    
    t1 = threading.Thread(target=daemon_task,daemon=True)
    t2 = threading.Thread(target=task)
    
    t1.start()
    t2.start()
    
    # t2.join()
    
    print("主线程执行完毕")