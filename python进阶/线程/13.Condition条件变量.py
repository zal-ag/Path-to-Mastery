import threading
import time

cond = threading.Condition()
stop_event = threading.Event()

task_list = []
task_list_maxsize = 5

def producer():
    product_id = 0
    while not stop_event.is_set():
        with cond:
            while len(task_list) >= task_list_maxsize and stop_event.is_set(): 
            # 双重判断，防止在停止标识发出后，生产者仍在因仓库已满而处于睡眠之中，后因为t_pro.join()而使程序无法退出
                print("仓库满了，生产者等待")
                cond.wait() # 释放锁，睡觉，等消费者唤醒
            product_id += 1
            task_list.append(product_id)
            print(f"生产者生产产品：{product_id}")
            if len(task_list) == 1:
                cond.notify_all()
        time.sleep(0.5)

def consumer():
    while not stop_event.is_set():
        with cond:
            while len(task_list) == 0 and stop_event.is_set(): # 仓库为空
                cond.wait() # 睡觉，等生产者叫醒
            product_id = task_list.pop(0)
            print(f"消费者获取产品：{product_id}")
            if len(task_list) < task_list_maxsize:
                cond.notify_all()
        time.sleep(1)

t_pro = threading.Thread(target=producer)
t_con = threading.Thread(target=consumer)
t_pro.start()
t_con.start()

time.sleep(10) # 也可以将两个进程换为守护进程 daemon=True 当主进程退出后，守护线程直接结束
stop_event.set()
t_pro.join()
t_con.join()
print("It is over")
