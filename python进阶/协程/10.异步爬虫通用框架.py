import asyncio
import aiohttp

MAX_CONCURRENT = 5
sem = asyncio.Semaphore(MAX_CONCURRENT)
headers = {"User-Agent": "Mozilla/5.0"}
TIMEOUT = aiohttp.ClientTimeout(total=3) # 请求最大时间为3秒

async def fetch_url(session,url):
    async with sem:
        try:
            # 全局复用ClientSession,性能远高于频繁创建对话
            async with session.get(url,headers=headers,timeout=TIMEOUT) as resp:
                page_html = await resp.text()
                return f"{url} | 状态码：{resp.status} | 页面长度：{len(page_html)}"
        except Exception as e:
            return f"{url} | 请求失败：str(e)"
        
async def main():
    url_list = [
        "https://llfc.club",
        "https://www.baidu.com",
        "https://www.bing.com",
        "https://www.qq.com",
        "https://www.zhihu.com",
        "https://www.163.com"
    ]
    async with aiohttp.ClientSession() as session:
        task_list = [fetch_url(session,url) for url in url_list]
        result_list = await asyncio.gather(*task_list)
    for res in result_list:
        print(res)
        
if __name__ == "__main__":
    asyncio.run(main())
