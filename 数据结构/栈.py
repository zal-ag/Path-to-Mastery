"""基于链表实现的栈"""


class Listnode:
    def __init__(self, val: int):
        self.val = val
        self.next: Listnode | None = None


class LinkedListStack:
    # 构造
    def __init__(self):
        self._peek: Listnode | None = None
        self._size: int = 0

    # 获取栈的长度
    def size(self) -> int:
        return self._size

    # 判断栈是否为空
    def is_empty(self) -> bool:
        return self._size == 0

    # 入栈
    def push(self, val: int):
        node = Listnode(val)
        node.next = self._peek
        self._peek = node
        self._size += 1

    # 出栈
    def pop(self) -> int:
        num = self.peek()
        self._peek = self._peek.next
        self._size -= 1
        return num

    # 访问栈顶元素
    def peek(self) -> int:
        if self.is_empty():
            raise IndexError("栈为空")
        return self._peek.val

    # 转换为列表用于打印
    def to_list(self) -> list[int]:
        get_list = []
        node = self._peek
        while node:
            get_list.append(node.val)
            node = node.next
        get_list.reverse()
        return get_list


stack = LinkedListStack()
print(stack.is_empty())
stack.push(1)
stack.push(3)
stack.push(2)
stack.push(5)
print(stack.is_empty())
print(stack.size())
print(stack.peek())
print(stack.to_list())
print(stack.pop())
print(stack.to_list())


"""基于数组实现的栈"""
class ArrayStack:
    # 构造
    def __init__(self):
        self.stack: list[int] = []

    # 获取栈的长度
    def size(self) -> int:
        return len(self.stack)

    # 判断栈是否为空
    def is_empty(self) -> bool:
        return self.size() == 0

    # 入栈
    def push(self, item: int):
        self.stack.append(item)

    # 出栈
    def pop(self) -> int:
        num = self.stack.pop(-1)
        return num

    # 访问栈顶元素
    def peek(self) -> int:
        if self.is_empty():
            raise IndexError("栈为空")
        return self.stack[-1]

    # 转换为列表用于打印
    def to_list(self) -> list[int]:
        return self.stack


stack = ArrayStack()
print(stack.is_empty())
stack.push(1)
stack.push(3)
stack.push(2)
stack.push(5)
print(stack.is_empty())
print(stack.size())
print(stack.peek())
print(stack.to_list())
print(stack.pop())
print(stack.to_list())
