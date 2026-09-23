"""
魔术方法
"""

"""__str__和__repr__的区别"""
class Student():
    pass
p = Student()
print(p) # 输出内存地址
# 在可交互环境下直接返回p也是内存地址

class Student:
    def __str__(self):
        return "__str__"

student = Student() 
print(student) # __str__
# 在可交互环境下直接返回student为 内存地址

class Student:
    def __repr__(self):
        return "__repr__"

student = Student()
print(student) # __repr__
# 在可交互环境下直接返回student也是 __repr__

class Student:
    def __str__(self):
        return "__str__"
    def __repr__(self):
        return "__repr__"
    
student = Student()
print(student) # __str__
# 在可交互环境下直接返回student是 __repr__

import datetime

d = datetime.datetime.now()
print(str(d)) # 给用户看，可读性更强
print(repr(d)) # 给程序员看，信息更丰富、准确

"__iter__"
"""__iter__不支持下标访问"""
class Fib():
    def __init__(self):
        self.a,self.b = 0,1
    def __iter__(self):
        return self
    def __next__(self):
        self.a,self.b = self.b,self.a+self.b
        if self.a > 100000:
            raise StopIteration
        return self.a
for n in Fib():
    print(n)

"""__getitem"""

"""无法进行切片操作"""
class Fib():
    def __getitem__(self,n):
        a,b = 1,1
        for i in range(n):
            a,b = b,a+b
        return a
f = Fib()
print(f[0])
print(f[1])
print(f[2])
print(f[3])
print(f[4])
print(f[5])

class Fib():
    def __getitem__(self,n):
        a,b = 1,1
        if isinstance(n,int):
            for i in range(n):
                a,b = b,a+b
            return a
        elif isinstance(n,slice):
            start = n.start
            stop = n.stop
            if start is None:
                start = 0
            L = []
            for i in range(stop):
                a,b = b,a+b
                if i >= start:
                    L.append(a)
            return L
b = Fib()
print(b[5:10])
print(b[:10])
print(b[0:10:2]) # 没有对step做处理

class Student():
    def __init__(self):
        self.name = "yigaoren"
s = Student()
print(s.name)
print(getattr(s,"score",404))

class Student():
    def __init__(self):
        self.name = "yigaoren"
    def __getattr__(self,attr):
        if attr == "score":
            return 99
            # return lambda:99
        raise AttributeError

s =  Student()
print(s.score) # 99 如果是返回 lambda:99 结果是：<function Student.__getattr__.<locals>.<lambda> at 0x000002151A6CF7F0>

class Chain():
    def __init__(self,path=''):
        self._path = path
    def __getattr__(self,path):
        return Chain("%s/%s" % (self._path,path))
    def __str__(self):
        return self._path
    __repr__ = __str__
print(Chain().status.user.timeline.list)

"""
__call__方法
使得对象可以当作函数来调用，能被调用的对象就是一个Callable对象，
比如python中的内置函数和下面的定义带有__call__的类实例
"""
class Student():
    def __init__(self,name):
        self._name = name
    def __call__(self):
        print(f"My name is {self._name}")
s = Student("machael")
s()

"""判断一个变量是函数还是对象"""
print(callable(s)) # True
print(callable(max)) # True
print(callable([1,2,3])) # False



"""练习"""
class Chain():
    def __init__(self,path=''):
        self._path = path
    def __getattr__(self,path):
        return Chain("%s/%s" % (self._path,path))
    def __call__(self,param):
        return Chain('%s/%s' % (self._path, param))
    def __str__(self):
        return self._path
    __repr__ = __str__
print(Chain().users('machael').repos) # /users/machael/repos

"""
枚举类
"""
from enum import Enum
class Color(Enum):
    RED = 1
    GREEN = 2
    BLUE = 3

# Color.RED 是一个枚举对象（枚举成员实例）
print(Color.RED) # Color.RED 类名访问
print(Color(1)) # Color.RED 值访问
print(Color['RED']) # Color.RED 名称字符串访问

Month = Enum("Month",('Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'))
for name,member in Month.__members__.items():
    print(name, '=>', member, ',', member.value)

"""练习"""
from enum import Enum,unique
class Gender(Enum):
    Female = 0
    Male = 1
 
class Student():
    def __init__(self,name,gender):
        self.name = name
        if not isinstance(gender,Gender):
            raise ValueError("gender must be an instance of Gemder")
        self.gender = gender

s1 = Student('Alice', Gender.Female)
s2 = Student('Bob', Gender.Male)

print(s1.gender)        # Gender.Female
print(s1.gender.name)   # 'Female'
print(s1.gender.value)  # 0

"""元类"""
class Hello():
    def hello(self,name='world'):
        print(f"hello {name}!")
h = Hello()
print(type(Hello))# <class 'type'>
print(type(h)) # <class '__main__.Hello'> ,当 Python 解释器直接运行一个脚本文件时，该脚本的模块名就是 __main__,
# 这个类没有显式指定它属于哪个模块，所以 Python 会默认将它的 __module__ 属性设置为创建该类时所在的模块。由于这段代码是在交互式环境或主脚本中执行的，其模块名就是 __main__

# 若该类是从其他模块导入进来的，比如：hello.py 
# 那么 type(h) 的结果是 <class 'hello.Hello'>

def fn(self,name="world"):
    print(f"hello {name}!")
Hello = type("Hello",(object,),dict(hello=fn))
h = Hello()
print(type(Hello))
print(type(h))

class ListMetaclass(type):
    def __new__(cls,name,bases,attrs):
        # cls：当前元类（即 ListMetaclass）
        # name：要创建的类的名字，例如 'MyList'
        # bases：要创建的类的基类元组，例如 (list,)
        # attrs：类的属性字典，包含类体中定义的所有属性和方法
        attrs['add'] = lambda self,value : self.append(value)
        return type.__new__(cls,name,bases,attrs)
class Mylist(list,metaclass=ListMetaclass):
    pass
my_list = Mylist()
my_list.add(1)
my_list.add(2)
print(my_list) 