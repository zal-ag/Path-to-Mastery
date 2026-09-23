"""给创建的实例绑定属性和方法 <动态语言的灵活性>"""
class Student:
    pass
s = Student()
# 绑定属性
s.name = "jack"
# 绑定方法
def set_age(self,age):
    self.age = age
from types import MethodType
s.set_age = MethodType(set_age,s)
s.set_age(25)
print(s.age)

# 绑定完方法后只有被绑定的实例 s 可以使用该方法，其他实例不可以
s2 = Student()

# 可以给class绑定方法，这样所有实例均可使用，但这样的方法一般定义在类里
def set_score(self,score):
    self.score = score
Student.set_score = set_score

"""__slots__限制实例的属性"""
class Student(object):
    __slots__ = ('name','age') # 用元组定义允许绑定的属性名称
s = Student()
s.name = "jack"
print(s.name)
try:
    s.score = 66
    print(s.score)
except AttributeError as e:
    print("该属性无法绑定")

"""对属性所被传入的参数进行限制"""
class Student(object):
    def set_score(self,value):
        if not isinstance(value,int):
            raise ValueError("score must be an integer")
        if value < 0 or value > 100:
            raise ValueError("score must between 0~100" )
        self.score = value
    def get_score(self):
        return self.score
s = Student()
s.set_score(60)
print(s.get_score())
# s.set_score(1000)

"""使用 @property 装饰器将一个方法变成属性调用"""
class Student():
    @property # score = property(score)，score经过装饰器的作用变成了property对象
    def score(self): # 只读
        return self._score
    @score.setter # 这里的score即property对象，调用setter实例方法，下面的函数体和setter有关（注册赋值逻辑）
    def score(self,value): # 赋值
        if not isinstance(value,int):
            raise ValueError("score must be an integer")
        if value < 0 or value > 100:
            raise ValueError("score must between 0~100" )
        self._score = value
s = Student()
s.score = 80 # 相当于 s.score(60)
print(s.score) # 相当于s.score()

"""易错"""
# def Student():
#     @property
#     def birth(self):
#         return self.birth

# 因为调用s.birth时 其实是方法调用s.birth()，
# 在进入 return 语句后，看见self.birth，又进行调用，形成无限递归，
# 导致栈溢出，出现报错RecursionError