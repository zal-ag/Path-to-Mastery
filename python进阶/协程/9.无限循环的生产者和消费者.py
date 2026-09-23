import asyncio

queue = asyncio.Queue(maxsize=3)


async def producer(name):
    num = 1
    while True:
        item = f"{name}——岗位{num}"
        await queue.put(item)
        print(f"【{name}】发布：{item},当前岗位数量：{queue.qsize()}")
        num += 1
        await asyncio.sleep(0.5)


async def consumer(name):
    while True:
        item = await queue.get()
        print(f"【{name}】得到：{item}，剩余岗位数量：{queue.qsize()}")
        await asyncio.sleep(1)
        queue.task_done()


async def main():
    producers = [
        asyncio.create_task(producer("腾讯")),
        asyncio.create_task(producer("字节")),
    ]
    consumers = [asyncio.create_task(consumer(f"实习生{i}")) for i in range(1, 4)]

    try:
        # 创建了一个永远不会set_result()的Future，因此会一直等待，直到超时
        await asyncio.wait_for(asyncio.Future(),timeout=10)
    # 表示这个异常来自 asyncio
    except asyncio.TimeoutError:
        print("========秋招时间结束，准备取消所有招聘========")
        
    for task in producers+consumers:
        task.cancel() # 通知所有任务停止
    # 等待所有任务停止
    await asyncio.gather(
        *producers,
        *consumers,
        return_exceptions=True # 不会直接抛异常，而是把异常收集起来，让程序正常结束
    )
    print("招聘结束")
    
if __name__ == "__main__":
    asyncio.run(main())
