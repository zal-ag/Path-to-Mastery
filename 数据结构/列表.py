class Mylist:
    """列表类"""
    def __init__(self):
        """构造方法"""
        self._capacity = 10 # 列表容量
        self._arr = [0]*self._capacity # 数组（储存列表元素）
        self._size = 0 # 列表长度（当前元素数量）
        self._extend_radio = 2 # 每次列表扩容的倍数
    def size(self):
        """获取列表长度"""
        return self._size 
    def capacity(self):
        """获取列表容量"""
        return self._capacity
    def get(self,index):
        """访问元素"""
        try:
            return self._arr[index]
        except IndexError as e:
             raise IndexError("超出列表范围")
    def set(self,index,num):
         """更新元素"""
         if index < self._size:
              self._arr[index] = num
              return self._arr
         else:
              print("超出列表范围")
    def add(self,num):
         """在尾部添加元素"""
         if self._size == self._capacity:
               self._arr = self.extend_capacity()
         self._arr[self._size] = num
         self._size += 1
         return self._arr
    def insert(self,index,num):
          """在中间插入元素"""
          if self._size == self._capacity:
               self._arr = self.extend_capacity()
          for i in range(self._size,index,-1):
               self._arr[i] = self._arr[i-1]
          self._arr[index] = num
          self._size += 1
          return self._arr
    def remove(self,index):
         """删除元素"""
         for i in range(index,self._size-1):
             self._arr[i] = self._arr[i+1]
         self._size -= 1
         return self._arr
    def extend_capacity(self):
         """列表扩容"""
         self._capacity = self._capacity * self._extend_radio
         arr = [0] * self._capacity
         for i in range(self._size):
              arr[i] = self._arr[i]
         self._arr = arr
         return self._arr
list = Mylist()
list.add(1)
print(list._arr)
print(list.size())
list.add(2)
print(list._arr)
print(list.size())
list.add(3)
print(list._arr)
print(list.size())
list.add(4)
print(list._arr)
print(list.size())
list.add(5)
print(list._arr)
print(list.size())
list.add(6)
print(list._arr)
print(list.size())
list.add(7)
print(list._arr)
print(list.size())
list.add(8)
print(list._arr)
print(list.size())
list.add(9)
print(list._arr)
print(list.size())
list.add(10)
print(list._arr)
print(list.size())
list.add(11)
print(list._arr)
print(list.size())

print(list.get(0))
print(list.get(10))
# print(list.get(20))

print(list.set(1,22))
print(list.set(3,44))
list.set(20,1)

print(list.insert(1,100))
print(list.size())

print(list.remove(1))
print(list.size())

