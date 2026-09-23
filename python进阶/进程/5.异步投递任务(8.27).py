import multiprocessing
import time

def task(x):
    time.sleep(0.5)
    return x*10

if __name__ == '__main__':
    # 创建进程池，三个进程
    with multiprocessing.Pool(3) as pool:
        tasks = []
        for i in range(5):
            # apply_asyns 异步提交任务，不阻塞主进程（主进程不等待任务完成，立即返回数据，继续执行后续代码）
            async_res = pool.apply_async(task,args=(i,))
            # 将异步执行的结果状态放入tasks列表
            tasks.append(async_res)

        # 统一获取所有任务的返回hi，res.get()会阻塞等待，直到任务执行完成
        final_results = [res.get() for res in tasks]

    print("异步处理结果：",final_results)
