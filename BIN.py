from math import log
class BIN():
    def __init__(self, num="0000", remainder ="0000"):
        """This creates a Binary Number entered as a string or as its decimal"""
        if type(num)==str:
            self.bin = num
            self.dec = self.binToDec(num)
            self.rem = remainder
        elif type(num)==int:
            self.bin = self.decToBin(num)
            self.dec = num
            self.rem = remainder
        else:
            raise ValueError("Incorrect Value: Enter a binary number (as string) or decimal (as int)")

    def checkIfDecimal(self):
        pass

    def binToDec(self, num):
        decrement = 2**(len(num) - 1)
        dec = 0
        for i in num:
            if i == "1":
                dec += decrement
            decrement /= 2
        return dec
    
    def decToBin(self, num):
        if num <= 0:
            return "0"
        bin = ""
        binNum = ""
        holder = int(log(num) / log(2)) + 1
        base = 2**(holder-1)

        bin = "0" * holder
        bin = list(bin)
        for i in range(len(bin)):
            if num >= base:
                num-=base
                bin[i]='1'
            base/=2
            binNum+=bin[i]
            
        return binNum

    def __str__(self):
        if self.rem == "0000":
            return self.bin
        else:
            return self.bin + " with remainder " + str(self.rem)

    def increment(self, by=1):
        """Increments the obj by desired value, or by 1 if nothing is entered"""
        if type(by)==str:
            by = self.binToDec(by)
        self.dec += by
        self.bin = self.decToBin(self.dec)

    def decrement(self, by=1):
        """Decrements the obj by desired value, or by 1 if nothing is entered"""
        if type(by)==str:
            by = self.binToDec(by)
        self.dec -= by
        self.bin = self.decToBin(self.dec)

    def __add__(self, obj2):
        num = self.dec + obj2.dec
        num = int(num)
        return BIN(num)
    
    def __sub__(self, obj2):
        num = self.dec - obj2.dec
        num = int(num)
        return BIN(num)
    
    def __mul__(self, obj2):
        num = self.dec * obj2.dec
        num = int(num)
        return BIN(num)
    
    def __truediv__(self, obj2):
        num = self.dec // obj2.dec
        num = int(num)
        remainderAsDec = self.dec % obj2.dec
        remainder = self.decToBin(remainderAsDec)
        return BIN(num, remainder)
