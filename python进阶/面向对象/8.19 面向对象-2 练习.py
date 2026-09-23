"""
获取对象信息
"""

# 对于基本数据类型可以直接用type()来判断...
# import types 中的types方法 可判断函数类型


"""通过isinstance，判断对象是否是该类的实例"""
class animal():
    pass
class dog(animal):
    pass
class wangcai(dog):
    pass
a = animal()
d = dog()
w = wangcai()
print(isinstance(w,wangcai))
print(isinstance(w,dog))
print(isinstance(d,wangcai))

"""dir可以获取一个对象所有的属性和方法"""
print(dir("abc"))
# __len__用于获取对象的长度
print(len("abc")) # 3
print("abc".__len__()) # 3
# 我们也可以在自己写的类里重新定义__len__方法进行使用
class height():
    def __len__(self):
        return 180
me = height()
print(len(me)) # 180

"""配合getattr()、setattr()以及hasattr()，我们可以直接操作一个对象的状态"""
class myobject(object):
    def __init__(self):
        self.x = 9
    def power(self):
        return self.x * self.x
obj = myobject()
print(hasattr(obj,"x")) # True
print(hasattr(obj,"y")) # False
setattr(obj,"y",19)
print(hasattr(obj,"y")) # True
print(getattr(obj,"y")) # 19
print(obj.y) # 19
print(getattr(obj,"z",404)) # 404 如果属性不存在，返回默认值404
print(hasattr(obj,"power")) # True
fn = getattr(obj,"power") # 获取属性power并赋值给变量fn,注意：类中的方法，本身就是对象的一个属性，属性值是函数对象。
print(fn())


"""
实例属性和类属性
"""

class Student(object):
    name = "student"
s = Student()
print(s.name) # 打印name属性，因为实例并没有name属性，所以会继续查找class的name属性
s.name = "zal"
print(s.name) #实例属性优先级比类属性高，因此，它会屏蔽掉类的name属性
print(Student.name) # 类属性依然存在
del s.name # 删除实例属性s.name
print(s.name) # 实例属性消失，返回类属性

"""
练习：为了统计学生人数，可以给Student类增加一个类属性，每创建一个实例，该属性自动增加
"""

# 错误写法
class Student():
    count = 0 # 类属性count为0
    def __init__(self):
        self.count += 1
        # 对实例属性count的操作 即self.count = self.count + 1，
        # 右边 self.count 首先在实例中查找属性 count，但实例还没有，于是访问到类变量 count = 0
        # 左边 self.count = ... 是赋值操作，这会在实例上创建一个新的实例属性 count，值为 0 + 1 = 1。


bob = Student()
print(bob.count) # 1
print(Student.count) # 0
lisa = Student()
print(lisa.count) # 1
print(Student.count) # 0

# 正确写法
class Student():
    count = 0
    def __init__(self):
        Student.count += 1

bob = Student()
print(Student.count) # 1
print(bob.count) # 1
lisa = Student()
print(Student.count) # 2
print(lisa.count) # 2