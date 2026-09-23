import multiprocessing
import traceback
from multiprocessing.pool import Pool

# =============== 核心工具封装（无需修改） ===============
def single_task_safe_wrapper(func,*args,**kwargs):
    
    try:
        result = func(*args,**kwargs)
        return {"status":"success","data":result,"error":None}
    except Exception as e:
        return {
            "status":"fail",
            "data":None,
            "error":f"任务异常:{str(e)}",
            "traceback":traceback.format_exc()
        }
        
def create_production_pool(max_workers=None,max_task_per_child=20):
    
    if not max_workers:
        max_workers = multiprocessing.cpu_count()
        
    return Pool(processes=max_workers,maxtasksperchild=max_task_per_child)

def batch_run_tasks(task_func,task_params_list,timeout=30):
    
    pool = create_production_pool()
    async_results = []
    
    for params in task_params_list:
        if isinstance(params,(list,tuple)):
            res = pool.apply_async(single_task_safe_wrapper,args=(task_func,*params))
        else:
            res = pool.apply_async(single_task_safe_wrapper,args=(task_func,params))
        async_results.append(res)
        
    all_results = []
    
    for res in async_results:
        try:
            all_results.append(res.get(timeout=timeout))
        except multiprocessing.TimeoutError:
            all_results.append(
                {
                    "status":"timeout",
                    "data":None,
                    "error":f"任务超时（最大{timeout}s）",
                    "traceback":None
                }
            )
            
    pool.close()
    pool.join()
    
    return all_results
            
# =============== 业务层（改这里） ===============
def business_task(x):
    res = 0
    for i in range(1000000):
        res += i**2
    return x*res

# =============== 入口（固定写法） ===============
if __name__ == "__main__":
    task_params = [1,2,3,4,5,6,7,8]
    final_results = batch_run_tasks(business_task,task_params,timeout=20)
    
    success_count = sum(1 for res in final_results if res["status"] == "success")
    fail_count = len(final_results) - success_count
    
    print(f"任务执行完毕：成功：{success_count}个，失败/超时：{fail_count}个")
    print("详细执行结果：")
    for index,item in enumerate(final_results):
        print(f"任务{index+1}：{item}")
    
    