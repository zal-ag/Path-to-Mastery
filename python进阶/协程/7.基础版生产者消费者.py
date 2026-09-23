"""
put：新增一份待办事项
get：有人领取了待办事项
task_done：这份待办事项已完成
join：等所有待办事项都完成
"""
import asyncio
# 异步队列，存放生产的数据，设置最大容量为3
queue = asyncio.Queue(maxsize=3)

async def producer():
    for i in range(8):
        item = f"商品——{i}"
        # 队列满时，此处会自动暂停协程，让出事件循环
        await queue.put(item)
        print(f"生产者：生产{item}，当前队列大小：{queue.qsize()}")
        await asyncio.sleep(0.5) # 模拟生产耗时

async def consumer():
    while True:
        # 队列为空时，协程阻塞等待数据
        item = await queue.get()
        print(f"消费者：消费{item}，剩余队列大小：{queue.qsize()}")
        await asyncio.sleep(1) # 模拟消费耗时
        queue.task_done() # 标记一个任务消费完成

async def main():
    # 创建生产者、消费者任务
    pro_task = asyncio.create_task(producer())
    con_task = asyncio.create_task(consumer())
    # 等待生产者全部生产完毕
    await pro_task
    # 等待队列里的产品全部被消费完
    await queue.join()
    # 取消无限循环的消费者任务
    con_task.cancel()

if __name__ == "__main__":
    asyncio.run(main())
