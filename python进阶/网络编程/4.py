import asyncio

async def handle_client(
    reader:asyncio.StreamReader,
    writer:asyncio.StreamWriter
):
    client_addr = writer.get_extra_info("peername")
    print(f"协程客户端接入：{client_addr}")
    while True:
        recv_data = await reader.read(1024)
        if not recv_data:
            print(f"客户端{client_addr}断开连接")
            break
        msg = recv_data.decode("utf-8")
        print(f"{client_addr}消息：{msg}")
        writer.write(f"协程服务器已经收到：{msg}".encode("utf-8"))
        await writer.drain()
    writer.close()
    await writer.wait_closed()
    
async def main():
    server = await asyncio.start_server(
        handle_client,
        host = "127.0.0.1",
        port = 8888
    )
    print("协程异步TCP高并发服务启动成功")
    await server.serve_forever()
    
if __name__ == "__main__":
    asyncio.run(main())