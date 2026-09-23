import asyncio

async def long_task(name):
    await asyncio.sleep(4)
    return f"{name}任务执行完毕"

async def main():
    try:
        res = await asyncio.wait_for(long_task("A"),timeout=3)
        print("res：",res)
    except TimeoutError:
        print("任务执行超时")
        
if __name__ == "__main__":
    asyncio.run(main())