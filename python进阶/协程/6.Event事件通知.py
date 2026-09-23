import asyncio

event = asyncio.Event()

async def car():
    print("红灯停——")
    await event.wait()
    print("绿灯行——")
    
async def traffic_light():
    await asyncio.sleep(3)
    print("变为绿灯")
    event.set()
    
async def main():
    t1 = asyncio.create_task(car())
    t2 =  asyncio.create_task(traffic_light())
    await t1
    await t2

if __name__ == "__main__":
    asyncio.run(main())