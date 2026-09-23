from concurrent.futures import ThreadPoolExecutor
import time

def task(num):
    print(f"任务{num}开始")
    time.sleep(1)
    return f"任务{num}结束"
    
if __name__ == "__main__":
    with ThreadPoolExecutor(max_workers=4) as pool: # 线程池里最多同时存在4个工作线程
        futures = [pool.submit(task,i) for i in range(4)] # pool.submit() 将任务投递进线程池，不会阻塞主线程
        for f in futures:
            print(f.result()) # 阻塞等待任务完成，获取返回值