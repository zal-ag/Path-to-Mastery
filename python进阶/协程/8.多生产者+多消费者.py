import asyncio

queue = asyncio.Queue(maxsize=3)

async def producer(name,capacity):
    for i in range(1,capacity+1):
        item = f'{name}——岗位{i}'
        await queue.put(item)
        print(f"【{name}】发布：{item},当前岗位数量：{queue.qsize()}")
        await asyncio.sleep(0.5)
        
async def consumer(name):
    while True:
        item = await queue.get()
        print(f"【{name}】得到：{item}，剩余岗位数量：{queue.qsize()}")
        await asyncio.sleep(1)
        queue.task_done()
        
async def main():
    producers=[
        asyncio.create_task(producer("腾讯",4)),
        asyncio.create_task(producer("字节",4))
    ]
    consumers = [asyncio.create_task(consumer(f"实习生{i}")) for i in range(1,4)]
    
    await asyncio.gather(*producers)
    await queue.join()
    for con in consumers:
        con.cancel()
        
if __name__ == "__main__":
    asyncio.run(main())