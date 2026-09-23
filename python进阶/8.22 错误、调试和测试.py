import logging
logging.basicConfig(level=logging.INFO)
def foo(s):
    return 10 / int(s)
def bar(s):
    return foo(s)*2
def main():
    try:
        bar('0')
    except Exception as e:
        logging.exception(e)
main()
print("END") # 程序打印完错误，会继续运行

def foo(s):
    n = int(s)
    if n==0:
        raise ValueError('invalid value: %s' % s)
    return 10 / n

def bar():
    try:
        foo('0')
    except ValueError as e:
        print('ValueError!')
        # raise

bar()

"""练习"""
from functools import reduce

def str2num(s):
    try:
        return int(s)
    except ValueError:
        return float(s)

def calc(exp):
    ss = exp.split('+')
    ns = map(str2num, ss)
    return reduce(lambda acc, x: acc + x, ns)

def main():
    r = calc('100 + 200 + 345')
    print('100 + 200 + 345 =', r)
    r = calc('99 + 88 + 7.6')
    print('99 + 88 + 7.6 =', r)

main()

"""
调试
"""
import logging
logging.basicConfig(level=logging.INFO) # 解释器只看第一次导包的配置，重复会跳过

s = '0'
n = int(s)
logging.info('n = %d' % n)
print(10/n)
