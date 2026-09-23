import struct
from asyncio import Queue

MSG_QUEUE = Queue(maxsize=1000)

class TLVProtocol:
    HEADER_LEN = 4
    
    @staticmethod
    def encode(msg_type:int,body:str) -> bytes:
        body_bytes = body.encode("utf-8")
        body_len = len(body_bytes)
        header = struct.pack("!HH",msg_type,body_len)
        return header+body_bytes
        
    @classmethod
    def decode(cls,buffer:bytes) -> tuple[list[dict],bytes]:
        message = []
        while len(buffer) >= cls.HEADER_LEN:
            msg_type,body_len = struct.unpack("!HH",buffer[:cls.HEADER_LEN])
            total_pkg_len = cls.HEADER_LEN + body_len
            
            if len(buffer) < total_pkg_len:
                break
            
            body_data = buffer[cls.HEADER_LEN:total_pkg_len].decode("utf-8")
            message.append({
                "msg_type":msg_type,
                "body_len":body_len,
                "body":body_data
            })
            buffer = buffer[total_pkg_len:]
        return message,buffer