import threading

num = 0

def add():
    global num
    for _ in range(10000):
        num += 1
        
t1 = threading.Thread(target=add)
t2 = threading.Thread(target=add)
t1.start()
t2.start()
t1.join()
t2.join()
print("预期结果20000，实际结果：",num)