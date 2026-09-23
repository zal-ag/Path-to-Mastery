import threading

local_data = threading.local()

def func(name):
    local_data.value = name
    print(f"线程{name}:{local_data.value}")
t1 = threading.Thread(target=func,args=("A",))
t2 = threading.Thread(target=func,args=("B",))
t1.start()
t2.start()
t1.join()
t2.join()
