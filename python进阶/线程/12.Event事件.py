import threading
import time

event = threading.Event() # 初始化时标志为False，相当于红灯

def car(name):
    print(f"{name}：红灯，等待...")
    event.wait() # 阻塞车辆通行，直到变为绿灯
    print(f"{name}：绿灯，通行——")
def traffic_light():
    time.sleep(2)
    print("信号灯变绿！")
    event.set() # 标志设为True，唤醒所有在等等中的线程
    
threading.Thread(target=traffic_light).start()

for name in ["车A","车B","车C"]:
    threading.Thread(target=car,args=(name,)).start()