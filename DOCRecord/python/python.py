# -*- coding: utf-8 -*-
"""
Created on Wed Jan 31 15:55:12 2018

@author: cjh
"""
print ('hello');

#五种基本对象类型
#字符串（string） str ‘’或“”
#整数（integer） int 十进制21，八进制025，十六进制0x15
#浮点数（float）2.1E2,1.78
#布尔值（boolean）bool True/False
#复数（complex）1+1j

############type()判断属于那种类型的函数#############
print (type(True));#<class 'bool'>

###为何区分整数和浮点数#############################
#1.浮点数表示能力更强
#2.浮点数有精度损失(因为有些浮点数用二进制无法表示如3.3)
#3.cpu有专门的的浮点数运算部件

###python运算规则#################################
#算数运算:
print (2/3);  #除法（python2向下取整需注意）
print (2.0/3);  #除法（python2向下取整需注意）
print (2%3);  #求余数
print (4%3);  #求余数
print (2**3); #指数
#math
import math;
print(math.acos(0));
print(math.pi);
#关系运算符
#逻辑运算符
# and or not
###变量不用定义其类型##############################
pi=3.13;
print (pi);
a=0;
#不能使a++;
a+=1;
print(a);
#
#流程控制########################################
score=70;
if score>=60:
    print ('yes');

if score=='long':
    score=1;    
    print('=============');
if score<60:
    print(123);
else:
    print(234);

if score<60:
    print(123);
elif score>60 and score<80:
    print(234);
elif score>=80:
    print(123333332342343);
#--
#import math;
#a=float(input('a='));
#b=float(input('b='));
#c=float(input('c='));

#循坏结构##
#while 循坏
count2=0;
while count2<5:
    print ('------------');
    count2+=1;
# for 循坏  求1-10 相加
#range(2,10)----指2,3,4，5,6,7,8,9（差值默认为1）
#range(2,10,3)--指2,5,8（3指等差数列中的差值）
#range(10,2,-1)-指10,9,8,7,6,5,4,3
s=0
for i in range(11):
    s+=i
print('sum is: ',s)
#for循坏使用：e=1+1/1!+2/2!+...+1/i!;

e=1;
for i in range(1,10):
    e+=1.0/math.factorial(i)
    
print (e);

start=1
factorial=1
for i in range(1,10):
    factorial*=i
    start+=1.0/factorial
print ('e is :',start)
#for 循坏之pi的计算求解pi=4(1-1/3+1/5-1/7+1?9-1/11+...+(-1)sqpart(i+1)/2i-1)

pii=0
for i in range(1,10000):
    pii+=(-1.0)**(i+1)/(2*i-1)
pii*=4
print(pii);

#冰雹猜想：对每个正整数，为奇数时乘以3再加1，偶数除以二，如此循坏则结果为1；
#n=6时，序列为 6,3,10,5,16，8,4,2,1
n=100
#可替换为 while n!=1:
while True:
    if(n==1):
        break
    if(n%2==0):
        n=n/2
        print (n)
    else:
        n=3*n+1
        print(n)

#乘法表打印
for i in range(1,10):
    for j in range(1,10):
        print (i*j,end='  ')
    print('')


#穷举法：鸡兔同笼 35头，94足
#循坏鸡兔个数
for  c in range(36):
    for r in range(36):
        if c*2 + r*4==94 and c+r==35:
            print ('鸡：',c)
            print ('兔：',r)
            


#二分法求平方根
#猜平方根（类似于猜数字）
#x=2
#low=0.0
#high=x
#————————————————————————————————————————————————
#while True:
#    guess=float(low+high)/2
##如果guess的平方减去被开放的值取绝对值小于等于1乘以10的-4次方就打印出来
#    if abs(guess**2-x)<=1e-4:
##    if abs(guess**2-x)<=1*10**-4:
##    if guess**2==x:
#        print (guess)
#        break;
#    elif guess**2>x:
#        high=guess
#    elif guess**2<x:
#        low=guess
#————————————————————————————————————————————————
#负数和小于1不适用
x=0.04
low=0.0
high=x
guess=float(low+high)/2
while  abs(guess**2-x)<1e-4:
    if guess**2>x:
        high=guess
    else:
        low=guess
        
    guess=float(low+high)/2
print (guess)
#————————————————————————————————————————————————
#判断是否是一个素数
x=2
count=0
while count<50:
    #使用此参数更快
    for i in range(2,int(math.sqrt(x)+1)):
    #for i in range(2,x):
        if x%i==0:
#            print (x,'is not 素数')
            break
    #循坏非正常结束时，走此
    else:
        print (x,'is  素数')
        count+=1
    x+=1 
#————————————————————————————————————————————————
#判断回文数（对称数）
num=12321
num_p=0
num_temp=num
while num_temp!=0:
    num_p=num_p*10+num_temp%10
    num_temp=num_temp/10
#    print (num)
#    print (num_p)
if num==num_p:
    print ('ok')
else:
    print (num_temp,num_p)
    print ('No')

#-——————————————————————————————————————————————
#函数(回文数+素数)
def print_sum(start,end):
    """
    注释文档
    to calculate the sun from start to stop
    """
    result =0
    for i in range(start,end+1):
        result+=i
    print('sum is ',result)
    
print_sum(1,10);
#返回值函数
def summ(start,end):
    result =0
    for i in range(start,end+1):
        result+=i
    return result
ss=summ(1,5)
print(ss)
#全局变量函数关键字
x=1
def f():
    #全局变量申明
    global x
    x=2
    print (x)
f()
print (x)
#错误示例
#x=1
#def ff(x):
#    #全局变量申明
#    global x
#    x=2
#    print (x)
#ff(x)
#print (x)
#判断回文数+素数====python 2.x
num=131
def is_plain(num):
    num_p=0
    num_t=num
    while num_t!=0:
        num_p=num_p*10+num_t%10
        num_t=num_t/10
        print (num,' ',num_p)
    if num==num_p:
        return True
    else:
        return False
def is_prime(num):
    for i in range(2,num):
        if num%2==0:
            return False
    return True

if is_plain(num) and is_prime(num):
    print ('ok')
else:
    print ('no')
#日历打印====————————————————————————————————————————
#判断年份是否为闰年,能被4整除并且不能被100整除 或者只能被400整除
def is_leap_year(year):
    if year%4==0 and year%100!=0 or year%400==0:
        return True
    else:
        return False
#获取某月份有多少天
def get_num_of_days_in_month(year,month):
    if month in (1,3,5,7,8,10,12):
        return 31
    elif month in (4,6,9,11):
        return 30;
    elif is_leap_year(year):
        return 29
    else:
        return 28
#距离1800年1月1号(星期三)有多少天
#截止2033年12月经过多少天
def get_total_num_of_days(year,month):
    days=0
    #1800全年到2032全年所经历的天数
    for y in range(1800,year):
        if is_leap_year(y):
            days+=366
        else:
            days+=365
    #2033年1.1到month的前一个月一整月所经历的天数
    #加和求得1800.1.1--2033.month.1所经历的所有天数
    for m in range(1,month):
        days+=get_num_of_days_in_month(year,m) 
    return days
#获得某月第一天为星期几
def get_start_day(year,month):
    return (3+get_total_num_of_days(year,month))%7

print (get_start_day(2033,12))

#——————————————————————————————————————————————
#递归开始:掐头去尾留中间，循坏效率高于递归效率
#阶乘n!=1*2*3*...*n  递归n!=(n-1)!*n
def p(n):
    x=1
    i=1
    while i<=n:
        x=x*i
        i+=1
    return x
print (p(3),'---------')

def di(n):
    if n==1:
        return 1
    else:
        return n*p(n-1) 
print (di(3))
#兔子序列1，1,2,3,5,8,13,21,34,55,89....
#斐波那契数列
#1-1
#2-1
#3-(1+1)
#4-(1+1+1)
def tu(n):
    if(n==1 or n==2):
        return 1
    else:
        return tu(n-1)+tu(n-2)
print (tu(7))

#汉诺塔三根柱子64圆片，大圆片不能压在小圆片上，只能以其中一个柱子作为中介
#将前n-1个盘子，通过c，从A移动到B
#将第n个盘子，从A移动到C
#将前n-1个盘子，通过B,从A移动到C
count=0
def hannuo(n,a,b,c):
    global count
    if n==1:
        print('Move disk',n,'from',a,'to',c)
        count+=1
    else:  
        hannuo(n-1,a,c,b)
        print('Move disk',n,'from',a,'to',c)
        count+=1
        hannuo(n-1,b,a,c)
hannuo(4,'A','B','C')
print (count)
#停车问题（递归）
import random
#车头车尾
def parking(low,high):
    if(high-low<1):
        return 0
    else:
        #随机位置
        x=random.uniform(low,high-1)
        return parking(low,x)+1+parking(x+1,high)
#假如停1000次
s=0
for i in range(1000):
    s+=parking(0,5)
    
print (s/1000)
print (parking(0,5))

#——————————————————————————————————————————————————
#字符串：单引号，双引号，三引号 ‘  “  '''均成对出现
#字符串的基本运算：字符串不可以与整数拼接
ss='qwe'
print (len(ss))
print (ss+ss)
print (ss*3)#重复3次

name='aqwqwreqweaz'
print ('a' in name)#大小写区分

#枚举字符串中的每个字符
for char in name:
    print (char)
    
#计算字符串中元音字母的数目
count=0
def yuanyin(s):
    global count
    for char in s:
#        if char in ('a','e','i','o','u','A','E','I','O','U'):
        if char in ('aeiouAEIOU'):
            count+=1
    return count
print (yuanyin('qwrwefafasfiiii'))

#字符串索引：向前0，向后-1，-2，。。。
my='hello world'
print(my[0])
print(my[-1])
print(my[-1]==my[10])
#print(my[-12])
#字符串切片：即字符串截取,第三个参数为计数参数,每间隔两个取一个值
print(my[0:2])
print(my[2:])
print(my[:3])
print(my[:])
print(my[0:11:2])
#逆序排列字符串
print(my[::-1])
#字符串不可变=========不支持赋值操作
#my[1]=a 此种写法会报错
my=my[0]+'a'+my[2:]
print(my)
#字符串方法:元素替换
my=my.replace('ll','mm')
print(my)
#find查找元素：第一次出现此元素的元素索引
print(my.find('m'))
print(my.split('m'))
#______________________________________
#对文件进行的操作--路径需转义
#读取文件时候的第二个参数mode可为r（读，默写）、w（写）
#f=open('C:\\Users\\cjh\\Desktop\\name.txt','r')
#f=open('C:\\Users\\cjh\\Desktop\\name.txt','r',encoding='utf-8')
f=open('C:\\Users\\cjh\\Desktop\\name.txt','r',encoding='utf-8',errors='ignore')
#此种方式会把回车也打出来
for line in f:
    #去空格
    line=line.strip()
    #转换为首字母大写的字符串
    print (line.title())
f.close()
#检验字符串是否仅由数字组成
#'123'.isdigit()
#Out[204]: True
#'123.233'.isdigit()
#Out[205]: False
#——————————————————————————————————————
#判断一个人名是否为回文（即对称）
print('-----------------------')
def is_huiwen(s):
    lens=len(s)
    print('lens=',lens)
    print('lens/2+1=',int(lens/2+1))
    print('lens/2=',int(lens/2))
    if(lens%2==0):
        for i in range(0,int(lens/2+1)):
#            print(i)
            if(s[i]!=s[int(lens-i-1)]):
                return False
        return True
    else:
        for i in range(0,int(lens/2)):
#            print(i)
            if(s[i]!=s[int(lens-i-1)]):
                return False
        return True
print(is_huiwen('bbccbb'))

print('-----------------------')
def is_hui(s):  
    low=0
    high=len(s)-1
    while low<high:
        if(s[low]!=s[high]):
            return False
        low+=1
        high-=1
    return True

print(is_hui('bbccbb'))
print('-----------------------')
#递归实现
def is_de(name):
    if(len(name)<=0):
        return True
    else:
        if name[0]!=name[-1]:
            return False
        else:
            return is_de(name[1:-1])
print(is_de('bbccbb'))    

######################
#字符串比较：ASCII --美国信息交换标准码（数字，标点符号都可以用它来表示）
#A-65 B-66
#a-97 b-98
print ('a'<'b')
print('-----------------------')
#判断人名是否升序排列
def is_shen(name):
    if len(name)==1:
        return True
    else:
        if name[0]>name[1]:
            return False
        else:
            name=name[1:]
            return is_shen(name)
#print (is_shen('abbbbbddeffgijk'))
#print (is_shen('abbbbbddeffgijka'))

def is_name(name):
    first=0
    second=1
    while name[first]<=name[second]:
#        print(str(second)+'|'+str(len(name)))
#        print(name[first])
#        print(name[second])
#        print(name[first]<name[second])
        if len(name)-1==second:
            return True
        else:
            first+=1
            second+=1
    return False
print (is_name('abbbbbddeffgijk'))
print (is_name('abbbbbddeffgijka'))   

def is_nn(name):
    print ('=========')
    p=name[0]
    print (p)
    for s in name :
        
        print ('---------------------')
        print (s)
        print (p>=s)
        if p>=s:
            return False
        p=c
    return True
print (is_nn('abbbbbddeffgijk'))
print (is_nn('abbbbbddeffgijka'))   

#字符串格式化#####
print ("Hello {} good {}.".format(5,'day'))
#{} 的格式：{域名：对齐方式 宽度.精度}
print("Pi is {:.4f}".format(math.pi))
print("Pi is {:9.4f}".format(math.pi))
print("Pi is {: > 9.4f}".format(math.pi))
print("Pi is {:e}".format(math.pi))

#正则表达式#####3________________________________
#.表示任意字符
#\d+表示一系列数字
#判断一个人名是否含有c.A模式
import re
f=open('C:\\Users\\cjh\\Desktop\\name.txt','r',encoding='utf-8',errors='ignore')
pattern='(c.A)'
#此种方式会把回车也打出来
for line in f:
    print (line)
    #去空格
    line=line.strip()
    result=re.search(pattern,line)
    if(result):
        print ('find in {}'.format(line))
f.close()

#列表和元组___--___________________________________
#列表List--支持前后向索引及切片(存在下标越界)
lists=[4.5,'ssss',2]
print(lists[0])
print(lists[0:])
print(lists[1:3])
print([1,2,3]+lists)
print([1,2,3]+lists)
print(3*lists)
print(4.5 in lists)
print(len(lists))
for e in lists:
    print (e)
lists[0]=5.4#赋值
print(lists)
lists[1:3]=[1,2,3,4,5]#将2,3位置元素替换为12345
print(lists)
lists.append('abc')#追加单个元素
print(lists)
lists.extend(['def','ddd'])#追加列表
print(lists)
lists.insert(1,'1111')#在任意位置插入元素
print(lists)
lists.pop()#删除最后一个元素并且返回该元素内容
print(lists)
lists.pop(3)#删除下标为3的元素
print(lists)
lists.remove('1111')#删除元素内容
lists.remove('abc')#删除元素内容
lists.remove('def')#删除元素内容
print(lists)
lists.sort()
print(lists)
lists.reverse()
print(lists)
print(sum(lists))
print(max(lists))
print(min(lists))

#列表赋值传递性-__________________________
a=[1,2,3,4]
b=a#指针引用改变
b[1]=23
print (a[1])

a=[1,2,3,4]
b=a[:]#生成新列表
b[1]=23
print (a[1])
#交换位置
def swap(lst,a,b):
    tmp=lst[a]
    lst[a] = lst[b]
    lst[b]=tmp
x=[10,20,30]
swap(x,0,1);
print (x)
#查找值:不存在返回-1.存在返回下标
def search(lst,x):
    for i in range(len(lst)):
        if lst[i]==x:
            return i
    return -1
x=[1,2,3,4,444]
print(search(x,4))

#index查找元素
print(x.index(4))
#线性查找：最坏运行时间：k0n+k1
#时间复杂度：量化一个算法的运行时间为输入长度的函数
#二分查找
lst=[1,2,3,23,454,655]
def is_search(lst,s):
    low=0
    high=len(lst)-1
    
    while low<=high:
        mid=int((low+high)/2)
#        print(high)
#        print('===============')
#        print(str(mid))
#        print(lst[mid])
#        print(s)
        if lst[mid]==s:
            return mid
        elif lst[mid]<s:
            low=mid+1
        else:
            high=mid-1
    return -1;
print(lst)
print(is_search(lst,23))

#排序
#选择排序+冒泡排序
#选择排序1：1.找到最小的元素-2.删除插入相应位置-3.对剩余元素重复步骤1,2
#删除在插入执行速度慢--
def selection_sort(lst):
    for i in range(len(lst)):
        min_index=i
        for j in range(i+1,len(lst)):
            if lst[j]<lst[min_index]:
                min_index=j
        lst.insert(i,lst.pop(min_index))
lst=[10,5,8,13]
selection_sort(lst)
print (lst)
#选择排序二：1.找到最小的元素，-2.和第一个元素交换。3.重复步骤
def swap2(lst,a,b):
    tmp=lst[a]
    lst[a] = lst[b]
    lst[b]=tmp
def select_sort(lst):
    for i in range(len(lst)):
        min_index=i
        for j in range(i+1,len(lst)):
            if lst[j]<lst[min_index]:
                min_index=j
        swap2(lst,i,min_index)
lst=[10,5,8,13,14,23,2]
select_sort(lst)
print (lst)       
#选择排序的时间复杂度(O(n的平方))
#冒泡排序时间复杂度(O(n的平方))：1.每次便利不止一次交换 -2.每次便利都将最大的值排在最后，-3.一旦排好序，算法可停止
#相比效率更快
def bubble_sort(lst):
    top=len(lst)-1
    is_ex=True
    while is_ex:
        is_ex=False
        for i in range(top):
            if(lst[i])>lst[i+1]:
                is_ex=True
                swap(lst,i,i+1)
        top-=1
lst=[10,5,8,13,14,23,2]
bubble_sort(lst)
print (lst)

#python的内建排序函数
lst=[10,5,8,13,14,23,2,888]
print (sorted(lst))#不修改原列表
lst=[10,5,8,13,14,23,2,8887]
lst.sort()#修改原列表
print (lst)

#嵌套列表--等同于java二维数组
x=[[1,2,3],[2,2,3],[4,3]]
print (x)
print (x[1][2])
print (x[0][2])

#列表生成:表达式 for 变量 in 列表 if 条件
#生成值为{x^2:x属于{1...9}}
#列表最快的时间复杂度为O(logn)-----慢
lst =[]
for x in range(1,10):
    lst.append(x**2)
print (lst)

lst=[x**2 for x in range (1,10)]
print (lst)

#求年龄平均数
stu=[['qwe',12],['asd',23],['zxc',34]]
print (float(sum([x[1] for x in stu]))/len(stu))

#使用列表解析对输入数字x 的因数（能被x整除的所有数，包含自己）求和
#在1-x范围内，所有数均作判断如果可被x整除则拿出i进行加和
sum([ i for i in range(1,x+1) if x%i==0])

#元组：不可变的列表：不能使用会修改列表的一些方法，可使用索引切片len()等
my=1,2,3,4,4
myy=(1,2,3,4,5)

#元组赋值：
#交换值
temp=a
a=b
b=temp
#或者
a,b=b,a
#茹切分一个邮件地址________________________________________
name,domain='982338665@qq.com'.split('@')
print(name+'|'+domain)

#函数只能有一个返回值：元组/单个值
def jud(lst):
    print (lst)
    max_=min_=lst[0]
    for i in lst:
        if i>max_:
            max_=i
        if i<min_:
            min_=i
    return max_,min_
judd=[1,3,4,55,65,32,21]
print(jud(judd))

#元组DSU模式：___________________________________________
#1,。装饰，排序，反装饰
words=['qwe','wer','qwerrr','sdfsf','fgh','ghjj']

words.sort(key=lambda x:len(x),reverse=True)
print (words)

#装饰
lst=[]
for word in words:
    lst.append((len(word),word))
#排序:默认从小到大排列，
lst.sort(reverse=True)
#反装饰
res=[]
for length,word in lst:
    res.append(word)
print (res)

#字典：一系列键值对——————————————————————————————————————
#键不可变，值可为任意字符
#时间复杂度：O(1)--原因是hash数据结构
my={'zhu':18,'long':25,'海洋':4}
print (my['zhu'])
my['zhu']='long'
print(my)
#字典运算符
print(len(my))
#判断key值是否存在与字典中
print('zhu' in my)
#print(my.has_key(key))
#输出键值：无序的
for key in my:
    print (key)
#全部键值对
print(my.items())
#全部键
print(my.keys())
#全部值
print(my.values())
#清空字典
print(my.clear())
print(my)
#_____________________________________________________
#字母计数：读取一个字符串，计算每个字符出现的个数：
strs='qwwwwreererdf'
lst=[0]*26
for i in strs:
    lst[ord(i)-97]+=1
print(lst)

dic={}
for i in strs:
    if i in dic:
        dic[i]+=1
    else:
        dic[i]=1
print (dic)
#读取小说txt，打印是个最常见的单词—————————————————————————
f=open('C:\\Users\\cjh\\Desktop\\小说.txt','r',encoding='utf-8',errors='ignore')
#此种方式会把回车也打出来
dic_word={}

for line in f:
    words=line.strip().split()
    for word in words:
        if word in dic_word :
            dic_word[word]+=1
        else:
            dic_word[word]=1
print (dic_word)
#元组
print('++++++++++++++++++++++++++++++++++++++++++++')
fre_word=[]
for word,fre in dic_word.items():
    fre_word.append((fre,word))
fre_word.sort(reverse=True)
for fre,word in fre_word[:10]:
    print (word)
f.close()

#字典翻转：键值互换：注意键不可重复，故翻转后需要用列表存储
d1={'zhang':123,'li':123,'wang':456,'zhao':456}
d2={}
for name,room in d1.items():
    if room in d2:
        d2[room].append(name)
    else:
        d2[room]=[name]
print (d2)

#集合set：无顺序不重复元素———————————————————————————————
#- 差集
#& 交集
#| 并集
#！= 不等于
#== 等于
#in 成员
#for key in set 枚举
#添加 x.add('body')
#删除 x.remove('body')
#x=set()
#y={1,2,3,4,6}
#中文分词______________________________________________
#算法：正向最大匹配
#研究生命的起源-->研究生/命/的/起源
#实际为：研究/生命的/起源  ---解决此问题的衍生学科：自然语言处理
def load(filename):
    word_dict=set()
    max_len=0
    f=open(filename,'r',encoding='utf-8',errors='ignore')
    for line in f:
#        word=unicode(line.strip(),'utf-8')
        word=line.strip()
        word_dict.add(word)
        if len(word)>max_len:
            max_len=len(word)
    return max_len,word_dict 
#print(load('C:\\Users\\cjh\\Desktop\\lexicon.dic'))
def fmm_word_seg(send,max_len,word_dict):
    begin=0
    words=[]
    while begin <len(send):
        for end in range(begin+max_len,begin,-1):
            if send[begin:end] in word_dict:
                words.append(send[begin:end])
                break
        begin=end
    return words

max_len,word_dict=load('C:\\Users\\cjh\\Desktop\\lexicon.dic')
#send=input('input start:')
#words=fmm_word_seg(send,max_len,word_dict)
#print (words)


import requests
def getHTMLText(url):
    try:
        r=requests.get(url,timeout=30)
        r.raise_for_status()
        r.encoding=r.apparent_encoding
        return r.text
    except:
        return '产生异常'
print(getHTMLText('http://www.baidu.com'))
print('------------------------------------')
payload={'key1':'va1','key2':'va2'}
#r=requests.post('http://httpbin.org/post',data=payload)#自动编码为form表单、
r=requests.post('http://httpbin.org/post',data='abc')#自动编码为form表单、
print(r.text)







































