"""
链表
"""
"""初始化链表"""
class Listnode:
    def __init__(self,val:int):
        self.val = val
        self.next:Listnode|None = None
   
n0 = Listnode(1)
n1 = Listnode(3)
n2 = Listnode(2)
n3 = Listnode(5)
n4 = Listnode(4)

n0.next = n1
n1.next = n2
n2.next = n3
n3.next = n4

print(n0.next) # n1内存地址
print(n0.next.val) # 3

"""插入节点"""
# 在相邻的两个节点之间插入节点p
def insert(nx:Listnode,p:Listnode):
    ny = nx.next
    p.next = ny
    nx.next = p     
p = Listnode(100)
insert(n0,p) # n0->p->n1
print(n0.next.val) # 100
print(p.next.val) # 3

"""删除节点"""
# nx->p->ny 只需改变nx.next的值
def delete(nx:Listnode):
    if not nx.next:
        return
    p = nx.next
    nx.next = p.next

delete(n0) # n0->n1
print(n0.next.val) # 3 

"""访问节点"""
def access(head:Listnode,index:int): # A (0)-> B (1)-> C (2)-> None 
    for _ in range(index):
        if not head:
            return None
        head = head.next
    return head
print(access(n0,3)) # n3的内存地址：<__main__.Listnode object at 0x0000029272B7DBA0>
print(access(n0,3).val) # 5 下标为3，对应n3,值为5

"""查找节点"""

"""自己写的，返回Listnode"""
def find(head:Listnode,target:int):
    while head.val != target:
        head = head.next
    return head
print(find(n0,5)) # n3对应的值为5，得到n3的内存地址：<__main__.Listnode object at 0x0000029272B7DBA0>

"""返回index"""
def find(head:Listnode,target:int):
    index = 0
    while head.val != target:
        head = head.next
        index += 1
    return index
print(find(n0,5))

"""双向链表"""
class Listnode:
    def __init__(self,val):
        self.val = val
        self.next:Listnode|None = None
        self.prev:Listnode|None = None