"""
案例一：计数器
描述：外部函数返回内部计数器函数，每调用一次计数器函数，数字就加一
"""
def make_counter():
    count = 0
    def counter():
        nonlocal count
        count += 1
        return count
    return counter
counter1 = make_counter()
print(counter1())
print(counter1())
print(counter1())

print("="*20)

"""
案例二：日志函数
描述：对不同的前缀，打印不同的消息
核心点：内部函数log会访问外部函数的参数prefix，因此会形成闭包
"""
def make_logger(prefix:str):
    def log(message:str):
        print(f"[{prefix}] {message}")
    return log

info_log = make_logger("INFO")
error_log = make_logger("ERROR")

info_log("程序启动")
error_log("文件不存在")

print("="*20)

"""
案例一：账户余额案例
描述：crete_mount()获得一个初始余额，通过atm()实现存取款，通过bool值deposit来决定存取款状态
"""
def create_account(initial_balance:int):
    def atm(money:int,deposit = True):
        nonlocal initial_balance
        if deposit:
            initial_balance += money
            print(f"存{money},账户余额：{initial_balance}")
        else:
            if money > initial_balance:
                print("余额不足")
            else:
                initial_balance -= money
                print(f"取{money},账户余额：{initial_balance}")
    return atm
card = create_account(100)
card(100)
card(200)
card(50,deposit = False)
card(400,deposit = False)



