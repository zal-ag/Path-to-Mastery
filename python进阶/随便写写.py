import multiprocessing
import time


def calc_power(num):
	res = num**2
	time.sleep(0.3)
	print(f"计算{num}^2 = {res}")
	return res
	
if __name__ == "__main__":
	core_count = multiprocessing.cpu_count()
	print(f"本机的cpu核心数:{core_count}")
	
	with multiprocessing.Pool(processes=core_count) as pool:
		data_list = [1,2,3,4,5,6,7,8]
		result = pool.map(calc_power,data_list)
	print("所有计算结果",result)