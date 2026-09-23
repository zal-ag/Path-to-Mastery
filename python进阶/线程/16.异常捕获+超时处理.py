from concurrent.futures import ThreadPoolExecutor
import time

def err_task():
    time.sleep(2) # 进入任务后自动睡眠2秒
    raise ValueError("任务内部报错")

if __name__ == "__main__":
    with ThreadPoolExecutor(2) as pool:
        f = pool.submit(err_task) # 把任务提交给线程池，立即返回一个Future对象f
        try:
            f.result(timeout=1) # 阻塞等待结果，最多等1秒，所以会抛出TimeoutError
        except TimeoutError: # 抛出错误后进入这里，任务还会继续跑
            print("任务执行超时")
            try:
                f.result() # 任务跑完，结果是抛错误，进入下面的except
            except Exception as e:
                print("任务异常",e)
        except Exception as e:
            print("任务异常",e)