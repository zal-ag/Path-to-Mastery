import asyncio
import aiohttp
# 创建信号量，控制同时访问某个资源的写成数量为3
sem = asyncio.Semaphore(3)

async def crawl_page(session,url):
    # 获取并自动释放信号量，超出并发限制的任务会在此等待
    async with sem: 
        # 发起异步HTTP请求并获取响应
        async with session.get(url) as resp:
            # 读取响应内容
            html = await resp.text()
            print(f"{url} 页面字节大小：{len(html)}")

async def main():
    # 创建ClientSession，管理连接池
    async with aiohttp.ClientSession() as session:
        url_list = ["http://baidu.com"]*8
        # 创建8个协程任务
        tasks = [crawl_page(session,url) for url in url_list]
        await asyncio.gather(*tasks) # 并发调度

if __name__ == "__main__":
    # 运行主协程
    asyncio.run(main())
