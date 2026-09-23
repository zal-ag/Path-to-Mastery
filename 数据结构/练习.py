def recur(n: int) -> int:
    print(f"递：进入 recur({n})")
    if n == 1:
        print("归：到达终止条件，返回 1")
        return 1
    res = recur(n - 1)
    print(f"归：recur({n}) 收到 recur({n-1}) 返回 {res}，所以返回 {n} + {res} = {n + res}")
    return n + res

print(recur(5))

# def tail_recur(n, res):
#     """尾递归"""
#     # 终止条件
#     if n == 0:
#         return res
#     # 尾递归调用
#     return tail_recur(n - 1, res + n)
# print(tail_recur(5,0))

def fib(n):
    print(f"递，进入fib{n-1}+fib{n-2}")
    if n == 1 or n == 2:
        print("到达终止条件，存在 n==1 or n == 2,归")
        return n-1
    res = fib(n-1) + fib(n-2)
    return res
print(fib(7))

def for_loop_recur(n: int) -> int:
    """使用迭代模拟递归"""
    # 使用一个显式的栈来模拟系统调用栈
    stack = []
    res = 0
    # 递：递归调用
    for i in range(n, 0, -1):
        # 通过“入栈操作”模拟“递”
        stack.append(i)
    # 归：返回结果
    while stack:
        # 通过“出栈操作”模拟“归”
        res += stack.pop()
    # res = 1+2+3+...+n
    return res
print(for_loop_recur(5))

def exponential(n: int) -> int:
    """指数阶（循环实现）"""
    count = 0
    base = 1
    # 细胞每轮一分为二，形成数列 1, 2, 4, 8, ..., 2^(n-1)
    for _ in range(n):
        for _ in range(base):
            count += 1
        base *= 2
    # count = 1 + 2 + 4 + 8 + .. + 2^(n-1) = 2^n - 1
    return count