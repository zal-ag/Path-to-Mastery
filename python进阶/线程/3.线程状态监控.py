import threading
import time

def test():
    print("子线程名称：",threading.current_thread().name)
    time.sleep(2)
    
t = threading.Thread(target=test)
print("启动前是否活跃：",t.is_alive())
t.start()
print("启动后是否活跃",t.is_alive())
print("当前线程名",threading.current_thread().name)
print("活跃线程数量",threading.active_count())
t.join()
print("结束后是否活跃",t.is_alive())