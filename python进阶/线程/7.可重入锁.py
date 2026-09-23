import threading

rlock = threading.RLock()

def func():
    rlock.acquire()
    print("第一次加锁成功")
    rlock.acquire()
    print("第二加锁成功")
    rlock.release()
    rlock.release()
    print("执行完毕")
    
if __name__ == "__main__":
    
    t = threading.Thread(target=func)
    t.start()
    t.join()
    
