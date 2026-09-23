import multiprocessing
import time

def calc_power(num):
    """模拟CPU密集计算"""
    res = num ** 2
    time.sleep(0.3)
    print(f"计算 {num}^2 = {res}")
    return res

if __name__ == '__main__':
    # 获取CPU核心数，设置进程池大小
    core_count = multiprocessing.cpu_count()
    print(f"本机的cpu核心数：{core_count}")

    # 创建进程池，进程数=CPU核心数
    with multiprocessing.Pool(processes=core_count) as pool:
        data_list = [1,2,3,4,5,6,7,8]
        # map自动分配任务，阻塞等待全部完成，返回结果列表
        result = pool.map(calc_power,data_list)

    print("所有计算结果：",result)
