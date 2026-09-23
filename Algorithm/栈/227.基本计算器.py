class Solution:
    def calculate(self,s:str) -> int:
        stack = []
        pre_sign = "+"
        n = len(stack)
        num = 0
        for i in range(n):
            char = s[i]
            if char.isdigit():
                num = num*10 + int(char)
            if not char.isdigit() or i == n-1:
                if pre_sign == "+":
                    stack.append(num)
                elif pre_sign == "-":
                    stack.append(-num)
                elif pre_sign == "*":
                    stack.append(stack.pop()*num)
                elif pre_sign == "/":
                    stack.append(int(stack.pop()/num))
                pre_sign = char
                num = 0
        
        return sum(stack)
