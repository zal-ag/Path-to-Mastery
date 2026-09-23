import asyncio
from tlv_protocol import TLVProtocol


async def tlv_tcp_client():
    reader, writer = await asyncio.open_connection("127.0.0.1", 8888)

    # 发送不同类型TLV消息
    test_msgs = [
        (1, "你好，TCP全双工服务"),  # 1=聊天消息
        (2, "heartbeat"),  # 2=心跳包
        (1, "测试TLV协议解析"),
    ]

    for msg_type, content in test_msgs:
        pkg = TLVProtocol.encode(msg_type, content)
        writer.write(pkg)
        await writer.drain()

        # 接收服务端响应
        res = await reader.read(1024)
        msgs, _ = TLVProtocol.decode(res)
        for m in msgs:
            print(f"服务端响应：{m}")

    await asyncio.sleep(2)
    writer.close()
    await writer.wait_closed()


if __name__ == "__main__":
    asyncio.run(tlv_tcp_client())
