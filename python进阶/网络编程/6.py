import struct
import asyncio
from typing import Dict
from tlv_protocol import MSG_QUEUE,TLVProtocol
CLIENT_POOL = dict()

async def client_logic_worker():
    while True:
        msg_info = await MSG_QUEUE.get()
        client_addr = msg_info["client_addr"]
        msg_type = msg_info["msg_type"]
        msg_body = msg_info["body"]
        if msg_type == 1:
            resp_body = f"[聊天回执]已收到消息：{msg_body}"
        elif msg_type == 2:
            resp_body = f"[心跳回执]心跳检测正常"
        else:
            resp_body = f"[未知指令]暂不支持消息类型{msg_type}"
        if client_addr in CLIENT_POOL:
            resp_pkg = TLVProtocol.encode(
                msg_type = msg_type,
                body = resp_body
            )
            writer = CLIENT_POOL[client_addr]
            writer.write(resp_pkg)
            await writer.drain()
        MSG_QUEUE.task_done()
            
        
    
async def client_handle(reader,writer):
    try:
        while True:
            client_addr = f"{writer.get_extra_info("peername")}"
            CLIENT_POOL[client_addr] = writer
            print(f"新客户端接入：{client_addr}，当前在线：{len(CLIENT_POOL)}")
            
            recv_buffer = b""
            recv_data = await reader.read(4096)
            if not recv_data:
                break
            recv_buffer += recv_data
            full_msgs,recv_buffer = TLVProtocol.decode(recv_buffer)
            for msg in full_msgs:
                msg["client_addr"] = client_addr
                await MSG_QUEUE.put(msg)
    except Exception as e:
        print(f"客户端{client_addr} 连接异常 {e}")
    finally:
        del CLIENT_POOL[client_addr]
        writer.close()
        await writer.wait_closed()
        print(f"客户端{client_addr}已断开，当前在线：{len(CLIENT_POOL)}")

async def main():
    asyncio.create_task(client_logic_worker())
    
    server = await asyncio.start_server(
        client_handle,
        host = "0.0.0.0",
        port = 8888
    )
    
    await server.serve_forever()
    
if __name__ == "__main__":
    asyncio.run(main())