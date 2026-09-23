"""基于链表实现的队列"""

class Listnode:
    def __init__(self, val: int):
        self.val = val
        self.next: Listnode | None = None

class LinkedListQueue:
    # 构造
    def __init__(self):
        self._front:Listnode|None = None # 头节点 front
        self._rear:Listnode|None = None # 尾节点 rear
        self._size:int = 0
    # 获取队列的长度
    def size(self)->int:
        return self._size
    # 判断队列是否为空
    def is_empty(self)->bool:
        return self.size() == 0
    # 入对列
    def push(self,num:int):
        node = Listnode(num)
        if self.is_empty():
            self._front = node
            self._rear = node
        else:
            self._rear.next = node
            self._rear = node
        self._size += 1
    # 出队列
    def pop(self)->int:
        num = self.peek()
        self._front = self._front.next
        self._size -= 1
        return num
    # 访问队首元素
    def peek(self)->int:
        if self.is_empty():
            raise IndexError("队列为空")
        return self._front.val
    # 转换为列表进行打印
    def to_list(self)->list[int]:
        arr = []
        node = self._front
        while node:
            arr.append(node.val)
            node = node.next
        return arr

que = LinkedListQueue()
print(que.is_empty())
que.push(1)
que.push(3)
que.push(2)
que.push(5)
print(que.is_empty())
print(que.size())
print(que.peek())
print(que.to_list())
print(que.pop())
print(que.to_list())

"""基于数组实现的队列"""
class ArrayQueue:
    # 构造
    def __init__(self):
        self.que:list[int] = []
    # 获取队列的长度
    def size(self) -> int:
        return len(self.que)

    # 判断队列是否为空
    def is_empty(self) -> bool:
        return self.size() == 0

    # 入对列
    def push(self, num: int):
        self.que.append(num)

    # 出队列
    def pop(self) -> int:
        num = self.que.pop(0)
        return num

    # 访问队首元素
    def peek(self) -> int:
        if self.is_empty():
            raise IndexError("队列为空")
        return self.que[0]

    # 转换为列表进行打印
    def to_list(self) -> list[int]:
        return self.que

que = ArrayQueue()
print(que.is_empty())
que.push(1)
que.push(3)
que.push(2)
que.push(5)
print(que.is_empty())
print(que.size())
print(que.peek())
print(que.to_list())
print(que.pop())
print(que.to_list())
