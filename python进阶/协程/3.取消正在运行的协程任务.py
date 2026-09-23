import asyncio

async def download(name, time):
    print(f"{name} 开始下载")
    await asyncio.sleep(time)  # 模拟网络等待
    print(f"{name} 下载完成")

async def main():
    # 创建一个耗时5秒的长任务
    task = asyncio.create_task(download("长任务",5))
    # 等待1秒
    await asyncio.sleep(1)
    # 取消任务
    task.cancel()
    try:
        # 执行时报错 CancelledError
        await task
    except asyncio.CancelledError:
        print("协程任务已被手动取消")
        
if __name__ == "__main__":
    asyncio.run(main())