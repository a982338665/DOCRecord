# -*- coding: utf-8 -*-
"""
Created on Wed Feb  7 10:10:47 2018

@author: cjh
"""

#练习1：测试url，测试成功爬取100次网页的时间======
#import requests
#import time
#def getweb(url):
#    try:
#        r=requests.get(url,timeout=10)
#        r.raise_for_status()
#        r.encoding=r.apparent_encoding
#        return '成功'
#    except:
#        return '异常'
#url='http://www.zhihu.com'
#t1=time.time()
#for i in range(100):
#    print ('爬取第：',i+1,'次',getweb(url))
#t2=time.time()
#print ('爬取100次共花费时间：',t2-t1,'秒')


#网络爬虫引发的问题：
#1.小规模，数据量小，爬取速度不敏感Requests库-----爬取网页、玩转网页
#2.中规模，数据规模较大，爬取速度敏感Scrapy库-----爬取网站，爬取系列网站
#3.大规模，搜索引擎，爬取速度为关键--定制开发-----爬取全网（爬取全Internet规模）
################
#缺点：
#1.网络爬虫会给被爬取web服务器带来巨大的资源消耗
#2.法律风险：服务器上的数据有产权归属（若用此数据牟利会有法律风险）
#3.隐私泄露
################
#使用规则：
#1.网络爬虫的限制:
#    --1.来源审查：判断User-Agent进行限制
#            ·检查http协议头的User_Agent域，只响应浏览器或友好爬虫的访问
#    --2.发布公告：robots协议-不提供此协议的被认为可以无限制爬取内容
#            ·告知所有网站的爬取策略，要求爬虫遵守
#2.robots（机器人）协议：网络爬虫排除标准
#   --1形式：在网站根目录下的rotbots.txt文件
#   --2例如：京东的robots协议：http://www.jd.com/robots.txt
#User-agent: *                  任何网络爬虫都应该遵守以下协议
#Disallow: /?*                  不允许访问以？*作为访问路径的
#Disallow: /pop/*.html 
#Disallow: /pinpai/*.html?* 
#User-agent: EtaoSpider         以下四种不允许爬虫（恶意）
#Disallow: / 
#User-agent: HuihuiSpider 
#Disallow: / 
#User-agent: GwdangSpider 
#Disallow: / 
#User-agent: WochachaSpider 
#Disallow: /
#
#3.robots协议的使用：
#   --1.网络爬虫：自动或人工识别robots.txt,在进行内容爬取
#   --2.约束性：可以不遵守，但是存在法律风险
#爬去网页：
#   访问量很小：可以遵守
#   访问量较大：建议遵守
#爬取网站：
#    非商业且偶尔：建议遵守
#    商业利益：必须遵守
#爬取全网：
#    必须遵守   
#自己写的小程序对服务器无大影响可不参考robots协议（类似于人类行为可不遵守）


#练习2：爬虫实例一：京东页面爬取+++++++++++++++++++++++++
#import requests
#url="https://item.jd.com/4482544.html"
#try:
#    #模拟浏览器发送请求
#    kv={'user-agent':'Mozilla/5.0'}
#    r=requests.get(url,headers=kv)
#    r.raise_for_status()
#    r.encoding=r.apparent_encoding
#    print (r.text[0:1000])
#except:
#    print ('爬取失败')
#实例二;亚马逊商品信息爬取(模拟浏览器发送请求)++++++++++++
#实例三：百度关键词搜索提交
#百度关键词搜索接口：www.baidu.com/s?wd=keyword
#360关键词搜索接口：www.so.com/s?q=keyword
#import requests
#kv={'wd':'python'}
#try:
#    r=requests.get('http://www.baidu.com/s',params=kv)
#    print(r.request.url)
#    r.raise_for_status()
#    print(len(r.text))
#except:
#    print('爬取失败')
#实例四：网络图片的爬取存储++++++++++++++++++++++++++++
#import requests
#import os
#url='https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1517995216337&di=4d064779256c161692e1c683c01e6a7e&imgtype=0&src=http%3A%2F%2Fh.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F242dd42a2834349b9440e8d6c3ea15ce36d3be1b.jpg'
#root='C:\\Users\\cjh\\Desktop\\' 
##path=root+url.split('/')[-1]
#path=root+'\\abcd.jpg'
#try:
#    if not os.path.exists(root):
#        os.mkdir(root)
#    if not os.path.exists(path):
#        r=requests.get(url)
#        with open (path,'wb') as f:
#            f.write(r.content)
#            f.close()
#            print ('文件保存成功')
#    else:
#        print ('文件已存在')
#except:
#    print ('爬取失败')
#视屏爬取++++++++++++++++++++++++++++++++++++++++++
#import requests
#import os
#url='http://player.pptv.com/flashplayer/pid/86001/pl/0a2eoKmcpqiknJzHraCS07OW/rcc_id/baiduduanshipin.swf'
#root='C:\\Users\\cjh\\Desktop\\' 
##path=root+url.split('/')[-1]
#path=root+'\\abcd.swf'
#try:
#    if not os.path.exists(root):
#        os.mkdir(root)
#    if not os.path.exists(path):
#        r=requests.get(url)
#        with open (path,'wb') as f:
#            f.write(r.content)
#            f.close()
#            print ('文件保存成功')
#    else:
#        print ('文件已存在')
#except:
#    print ('爬取失败')
#实例五：ip地址归属地查询 www.ip138.com++++++++++++++
import requests
url='http://m.ip138.com/ip.asp?ip='
try:
    r=requests.get(url+'202.204.80.112')
    r.raise_for_status()
    r.encoding=r.apparent_encoding
    print(r.text[-500:])
except:
    print ('爬取失败')









