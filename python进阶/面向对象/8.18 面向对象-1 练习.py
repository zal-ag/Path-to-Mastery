"""Object Oriented Programming"""

# Student类——抽象的模板
class Student:
    # 拥有name和score两个属性
    def __init__(self,name,score):
        self.name = name
        self.score = score
    # 类方法
    def __print_score__(self):
        print(f"{self.name}的成绩为{self.score}")
# 实例（Instance），调用类，创建对象
bob = Student("Bob",21)
lisa = Student("Lisa",20)
# 调用类方法
bob.__print_score__()
lisa.__print_score__()

"""
__init__()方法的第一个参数永远是self，表示创建的实例本身，因此，在__init__()方法内部，就可以把各种属性绑定到self，因为self就指向创建的实例本身
有了__init__()方法，在创建实例的时候，就不能传入空的参数了
"""

"""
数据封装，指的是将数据（属性）和操作这些数据的方法（函数）捆绑在一起，形成一个独立的单元（类），并对外部隐藏内部实现细节，只暴露必要的接口。
"""

class Student:
    def __init__(self,name,score):
        # 属性前面家两个下划线表示私有属性，外部无法直接访问
        self.__name = name
        self.__score = score
    # 添加新的类方法，提供对私有属性的访问接口
    def get_name(self):
        return self.__name
    def get_score(self):
        return self.__score
    # 添加类方法允许外部修改score，在方法中还可以对参数进行检查，保证score的合法性
    def set_score(self,score):
        if 0 <= score <= 100:
            self.__score = score
        else:
            raise ValueError("成绩必须在0~100之间")

# 练习
class Student:
    def __init__(self,name,gender):
        self.name = name
        self.__gender = gender
    def get_gender(self):
        return self.__gender
    def set_gender(self,gender):
        if gender in ("male","female"):
            self.__gender = gender
            print("修改成功")
        else:
            raise ValueError("性别只能是男或者女！")
# 测试
s = Student("Bob","male")

s.__gender = "man"
print(s.__gender) # man，这是外部代码给Student类添加了一个新的属性__gender，并不是修改原有的私有属性__gender

print(s.get_gender())

s.set_gender("female")
print(s.get_gender())

# s.set_gender("unknown")
# print(s.get_gender())

"""多态:鸭子案例"""
class robot(object):
    def __speaking__(self):
        print("I am a robot")

class human(object):
    def __speaking__(self):
        print("I am a human")

def in_speaking(Robot):
    Robot.__speaking__()

robot = robot()
human = human()

in_speaking(robot) # I am a robot
in_speaking(human) # I am a human