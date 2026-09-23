from concurrent.futures import ThreadPoolExecutor
import time

def calc(x):
    time.sleep(1)
    return x*x

if __name__ == "__main__":
    data = [1,2,3,4,5,6,7,8]
    with ThreadPoolExecutor(max_workers=4) as pool:
        res = pool.map(calc,data) 
        # 自动分配任务到进程池，任务立即开始执行，但结果是通过迭代器按顺序完成
        print(list(res))