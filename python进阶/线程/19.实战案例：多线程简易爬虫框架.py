from concurrent.futures import ThreadPoolExecutor
import requests

MAX_WORKERS = 5
headers = {"User-Agent":"Mozilla/5.0"}

def fetch(url):
    try:
        resp = requests.get(url,headers=headers,timeout=3)
        return f"{url}，状态码：{resp.status_code}"
    except Exception as e:
        return f"{url} 请求失败：{str(e)}"

if __name__ == "__main__":
    url_list = [
        "https://www.baidu.com",
        "https://www.bing.com",
        "https://www.zhihu.com",
        "https://www.github.com",
        "https://www.163.com",
        "https://www.qq.com",
    ]
    with ThreadPoolExecutor(max_workers=MAX_WORKERS) as pool:
        result = pool.map(fetch,url_list)
        for res in result:
            print(res)
