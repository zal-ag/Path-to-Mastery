import asyncio
import time


async def download(name, time):
    print(f"{name} 开始下载")
    await asyncio.sleep(time)  # 模拟网络等待
    print(f"{name} 下载完成")


async def main1():
    start = time.time()
    d1 = download("A", 2)
    d2 = download("B", 1)
    d3 = download("C", 3)

    res1 = await d1
    res2 = await d2
    res3 = await d3
    

    print(f"main1 总耗时: {time.time() - start}")


async def main2():
    start = time.time()
    d1 = asyncio.create_task(download("A", 2))
    d2 = asyncio.create_task(download("B", 1))
    d3 = asyncio.create_task(download("C", 3))

    res1 = await d1
    res2 = await d2
    res3 = await d3
    
    # await asyncio.create_task(download("A", 2))
    # await asyncio.create_task(download("B", 1))
    # await asyncio.create_task(download("C", 3))
    # 和main1一样，会按顺序等待，先 create_task() 所有相关任务，再await，才能并发推进
    
    print(f"main2 总耗时: {time.time() - start}")


async def main3():
    start = time.time()
    await asyncio.gather(
        download("A", 2),
        download("B", 1),
        download("C", 3),
    )
    print(f"main3 总耗时: {time.time() - start}")


if __name__ == "__main__":
    asyncio.run(main1())
    asyncio.run(main2())
    asyncio.run(main3())
