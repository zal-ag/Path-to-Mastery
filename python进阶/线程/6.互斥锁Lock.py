import threading

num = 0
lock = threading.Lock()

def add():
    global num
    for _ in range(10000):
        with lock:
            num += 1

t1 = threading.Thread(target=add)
t2 = threading.Thread(target=add)
t1.start()
t2.start()
t1.join()
t2.join()

print("正确结果：",num)