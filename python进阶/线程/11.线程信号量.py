import threading
import time
# 最多同时三个线程运行
sem = threading.Semaphore(3)
# 定义爬虫函数
def crawl(url):
    with sem:
        print(f"开始爬取：{url}，当前线程：{threading.current_thread().name}")
        time.sleep(2)
        print("爬取完成")

if __name__ == "__main__":
    urls = [
        "https://www.saihuan.net/",
        "https://dasai.lanqiao.cn/",
        "https://www.kaggle.com/",
        "https://www.saikr.com/contests",
        "https://legacy.cplusplus.com/",
        "https://www.runoob.com/",
        "https://docs.python.org/zh-cn/3.14/contents.html",
        "https://watcha.cn/",
        "https://www.saihuan.net/",
        "https://tianchi.aliyun.com/",
    ]
    thread_list = []
    for url in urls:
        t = threading.Thread(target=crawl,args=(url,))
        thread_list.append(t)
        t.start()
    for t in thread_list:
        t.join()
