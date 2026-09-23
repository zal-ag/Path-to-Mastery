"""" 随机访问元素 """
import random
def random_access(nums:list):
    random_index = random.randint(0,len(nums)-1)
    return nums[random_index]
print(random_access([1,2,3,4,5]))

""" 插入元素 """
def insert(nums:list,index:int,value)->list:
    for i in range(len(nums)-1,index,-1):
        nums[i] = nums[i-1]
    nums[index] = value
    return nums
print(insert([1,2,3,4,5],1,10)) # [1, 10, 2, 3, 4]

""" 删除元素 """
def delete(nums:list[int],index:int)->list[int]:
    for i in range(index,len(nums)-1):
        nums[i] = nums[i+1]
    return nums
print(delete([1,3,2,3,4],1))

""" 遍历元素 """
def traverse(nums:list):
    for i in range(len(nums)):
        print(nums[i],end=" ") # 1 2 3 4 5
    print()
    for num in nums:
        print(num,end=" ") # 1 2 3 4 5
    print()
    for i,num in enumerate(nums):
        print(f"Index: {i}, Value: {num}") # Index:0,Value:1 ...
traverse([1,2,3,4,5])

""" 查找元素 """
def find(nums:list,target):
    for i in range(len(nums)):
        if nums[i] == target:
            return i
    return -1 # -1是一个无效下标 ，return -1，表示没有找到
print(find([1,2,3,4,5],4)) # 3

""" 扩展数组 """
def extend(nums:list,enlarge:int)->list:
    res = [0]*(len(nums)+enlarge)
    for i in range(len(nums)):
        res[i] = nums[i]
    return res
print(extend([1,2,3,4,5],5)) # [1,2,3,4,5,0,0,0,0,0]

res = [0]
print(res*10) # [0,0,0,0,0,0,0,0,0,0]