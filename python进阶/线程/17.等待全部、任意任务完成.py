from concurrent.futures import ThreadPoolExecutor,wait,FIRST_COMPLETED
import time

def task(x):
    time.sleep(x)
    return x

if __name__ == "__main__":
    data = [2,1,3]
    with ThreadPoolExecutor(max_workers=3) as pool:
        fs = [pool.submit(task,d) for d in data]
        done,pending = wait(fs,return_when=FIRST_COMPLETED) 
        # 任意一个任务完成就返回，done是已完成的Future集合，pending是还未完成的任务集合
        print(done)  
        # done是一个set，里面装的是Future对象,直接打印显示的是对象的各种格式 {<Future at 0x1ab9248f250 state=finished returned int>}
        print(pending)  
        # {<Future at 0x1ab9248f610 state=running>, <Future at 0x1ab92564ad0 state=running>}
        print("最先完成任务的是:",[d.result() for d in done])
