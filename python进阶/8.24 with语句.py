"""with语句"""
with open("D:/bill.txt","r",encoding="utf-8") as file:
    content = file.read()
"""列表生成器"""

print(list(range(1,11))) # [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

L = []
for x in range(1,11):
    L.append(x*x)
print(L)
# 列表生成器
print([x*x for x in range(1,11)])
# if判断<过滤条件>
print([x*x for x in range(1,11) if x % 2 == 0])
# 两层循环
print([m+n for m in "ABC" for n in "XYZ"])
# for中增加一个变量
d = {'x':'1','y':'2','z':'3'}
print([k+"="+v for k,v in d.items()])
# if-else用法 <条件表达式>
# for返回x，x经过判断后再传递
print([x if x % 2 == 0 else -x for x in range(1, 11)])

"""生成器 generator"""
g = (x*x for x in range(1,10))
print(g)
# 打印元素 1
print(next(g))
print(next(g))
print(next(g))
# 打印元素 2
for n in g:
    print(n)
# 斐波那契 函数
def fib(max:int):
    n,a,b = 0,0,1
    while n < max:
        print(b)
        a,b = b,a+b
        n += 1
    return "done"
fib(6)
# 斐波那契 生成器
def fib(max:int):
    n,a,b = 0,0,1
    while n < max:
        yield b
        a,b = b,a+b
        n += 1
    return "done"
f = fib(6)
print(f)
print(next(f))
for n in f:
   print(n)
# 手动处理，获取StopIteration的值
d = fib(10)
while True: # 无限循环
    try:
        v = next(d)
        print(f"g:{v}")
    except StopIteration as e:
        print("Geneator return value:",e.value)
        break
"""练习：杨辉三角"""

def triangles():
    N = [1]
    while True:
        yield N
        N_next = [1]
        for i in range(len(N)-1):
            N_next.append(N[i]+N[i+1])
        N_next.append(1)
        N = N_next

g = triangles()
for _ in range(10):
    print(next(g))

"""io模块——内存流"""

"""StringIO,在内存中读写字符串"""
from io import StringIO

# 将str写入StringIO
f = StringIO()
f.write("hello") # 5 
f.write(" ") # 1  
f.write("world!") # 6
print(f.getvalue())

# 读取StringIO
f = StringIO("Hello!\nHi!\nGoodbye!")
while True:
    s = f.readline()
    if s == "":
        break
    print(s.strip()) # 去除换行符

"""BytesIO，在内存中读写二进制数据"""
from io import BytesIO

b = BytesIO()
b.write("后端".encode('utf-8'))
print(b.getvalue()) # b'\xe5\x90\x8e\xe7\xab\xaf'

b = BytesIO(b'\xe5\x90\x8e\xe7\xab\xaf')
print(b.read())

"""操作文件和目录"""
import os
print(os.name) # nt 证明是windows系统
print(os.environ) # 操作系统中定义的环境变量
print(os.path.abspath(".")) # D:\PyCharmMiscProject\python进阶 查看当前目录的绝对路径
# 将两个字符串拼接，形成新目录的绝对路径
print(os.path.join("D:/PyCharmMiscProject/python进阶","testdir"))
new_dir = os.path.join("D:/PyCharmMiscProject/python进阶","testdir")
# 创建新目录
# os.mkdir("new_dir") 第一次运行时已经创建，不能重复操作
# 删除目录
# os.rmdir("new_dir")  第一次运行时已经删除，不能重复操作

# 拆字符串，将路径分为两部分，后一部分往往是最后级别的目录或文件名
print(os.path.split(new_dir)) # ('D:/PyCharmMiscProject/python进阶', 'testdir')
# 得到文件扩展名
print(os.path.splitext("D:/PyCharmMiscProject/python进阶/草稿.py")) # ('D:/PyCharmMiscProject/python进阶/草稿', '.py')

# 对文件重命名
# os.rename("草稿.py","草稿.txt") 只能操作一次
#删除文件
#os.remove("草稿.txt") 同样

# 列出当前下所有的文件夹及其文件
print(os.listdir("."))
# 列出当前目录下所有目录
all_dir = [x for x in os.listdir(".") if os.path.isdir(x)]
print(all_dir)
# 列出所有的.py文件
all_py = [x for x in os.listdir(".") if os.path.isfile(x) and os.path.splitext(x)[1]=='.py']
print(all_py)