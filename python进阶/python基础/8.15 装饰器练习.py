# 案例1：装饰器装饰【无参无返回值】的函数
def decorator1(func):
    def wrapper1():
        print("正在计算中...")
        func()
    return wrapper1
@decorator1
def two_sum1():
    a = 20
    b = 30
    print(f"a,b两数之和为:{a+b}")
two_sum1()

# 案例2：装饰器装饰【有参无返回值】的函数
def decorator2(func):
    def wrapper2(x,y):
        print("正在计算中...")
        func(x,y)
    return wrapper2
@decorator2
def two_sum2(a:int,b:int):
    print(f"x,y两数之和为:{a+b}")
two_sum2(20,30)

# 案例3：装饰器装饰【无参有返回值】的函数
def decorator3(func):
    def wrapper3():
        print("正在计算中...")
        result = func()
        return result
    return wrapper3
@decorator3
def two_sum3():
    a = 20
    b = 30
    c = a + b
    return c
print(f"a,b两数之和为：{two_sum3()}")

# 案例4：装饰器装饰【有参有返回值】的函数
def decorator4(func):
    def wrapper4(x,y):
        print("正在计算中...")
        result = func(x,y)
        return result
    return wrapper4
@decorator4
def two_sum4(a,b):
    c = a + b
    return c
print(f"a,b两数之和为：{two_sum4(20,30)}")

# 案例5：通用装饰器（可以计算多个数据和多个字典value值之和）
def decorator5(func):
    def wrapper5(*args,**kwargs):
        print("正在计算中...")
        result = func(*args,**kwargs)
        return result
    return wrapper5
@decorator5
def get_sum(*args,**kwargs):
    result = 0
    for arg in args:
        result += arg
    for v in kwargs.values():
        result += v
    return result
print(f"所有数之和为：{get_sum(10,20,30,a=40,b=50,c=60)}")

# 案例6-1：多个装饰器装饰同一个函数
def login(func):
    def wrapper_login():
        print("登录用户...")
        func()
    return wrapper_login
def check(func):
    def wrapper_check():
        print("验证码验证...")
        func()
    return wrapper_check
@check
@login
def comment():
    print("发表评论...")
comment()

# 案例7：带有参数的装饰器
def logging(flag:str):
    def decorator7(func):
        def wrapper7(x,y):
            if flag == '+':
                print("正在进行加法运算...")
            elif flag == '-':
                print("正在进行减法运算...")
            result = func(x, y)
            return result
        return wrapper7
    return decorator7
@logging('+')
def two_sum(a,b):
    result = a + b
    return result
@logging('-')
def two_minus(a,b):
    result = a - b
    return result
print(f"两数之和为{two_sum(20,30)}")
print(f"两数之差为{two_minus(20,30)}")

"""使用 functools.wraps 保留原始数据"""
# 装饰器会替代原函数，导致原函数的原始信息丢失
def my_decorator(func):
    def wrapper(*args, **kwargs):
        """wrapper 的文档"""
        return func(*args, **kwargs)
    return wrapper

@my_decorator
def say_hello():
    """say_hello 的文档"""
    print("Hello!")

print(say_hello.__name__)   # wrapper
print(say_hello.__doc__)    # wrapper 的文档
# 通过warps保留原函数的原始数据
from functools import wraps

def my_decorator(func):
    @wraps(func)          # 保留原函数的元信息
    def wrapper(*args, **kwargs):
        """wrapper 的文档"""
        return func(*args, **kwargs)
    return wrapper

@my_decorator
def say_hello():
    """say_hello 的文档"""
    print("Hello!")

print(say_hello.__name__)   # say_hello
print(say_hello.__doc__)    # say_hello 的文档