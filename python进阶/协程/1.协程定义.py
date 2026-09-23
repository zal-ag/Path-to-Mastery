import asyncio

# 定义协程函数

async def hello_coroutine():
    print("协程函数被执行了")

coro = hello_coroutine() # 只是创建了一个协程对象并赋值给coro，不会执行函数
print(coro)  # 只会打印出对这个协程对象的描述 <coroutine object hello_coroutine at 0x000001E8D0A26B00>
print(type(coro)) # 类型为协程

def hello_world():
    print("hello_world")

hw = hello_world() # 直接运行函数，打印字符串
print(hw) # 无返回值 None
