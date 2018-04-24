package pers.li.xml;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

/**
 * create by lishengbo on 2018-04-23 10:17
 * DOM方式解析XML:
 * 将整个XML加载再去解析
 */
public class analysisDOM {


    public static void main(String[] args) {
        parserDOM();
        createXMLDOM();

    }

    /**
     * 抽取公用方法
     *
     * @return
     */
    public static DocumentBuilder createPublicDocumentBuilder() {
        //创建一个DocumentBuilderFactory 对象
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        //创建一个DocumentBuilder 对象
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            return db;
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * dom创建XML
     */
    public static void createXMLDOM() {
        //创建一个DocumentBuilder 对象
        DocumentBuilder db = createPublicDocumentBuilder();
        Document document = db.newDocument();
        /**
         * standalone="no"表示的意思：
         * ·=yes表示的意思是：xml文件没有相关的dtd和schema作为说明文档
         * ·=no,有dtd和schema文档
         * ·所以此处应该设置为yes 并隐藏
         */
        document.setXmlStandalone(true);
        Element rootNode = document.createElement("bookstore");
        Element book = document.createElement("book");
        Element name = document.createElement("name");
        Element author = document.createElement("author");
        Element year = document.createElement("year");
        Element price = document.createElement("price");
        name.setTextContent("小狼狗");
        author.setTextContent("乔治");
        year.setTextContent("1988");
        price.setTextContent("100");
        //不能正常使用
//        name.setNodeValue("小狼狗");
//        author.setNodeValue("乔治");
//        year.setNodeValue("1988");
//        price.setNodeValue("100");
        //book中添加子节点
        book.appendChild(name);
        book.appendChild(author);
        book.appendChild(year);
        book.appendChild(price);
        //添加子节点属性
        book.setAttribute("id","1");
        //添加子节点
        rootNode.appendChild(book);
        //添加根节点
        document.appendChild(rootNode);

        //将现有的树结构转换为xml文件
        TransformerFactory factory = TransformerFactory.newInstance();
        try {
            Transformer transformer = factory.newTransformer();
            //添加有换行符的输出
            transformer.setOutputProperty(OutputKeys.INDENT,"yes");
            transformer.transform(new DOMSource(document),new StreamResult(new File("src/xml/createDOM.xml")));
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    /**
     * dom解析xml
     */
    private static void parserDOM() {
        try {
            //创建一个DocumentBuilder 对象
            DocumentBuilder db = createPublicDocumentBuilder();
            //通过parser方法加载books.xml
            Document document = db.parse("src/xml/books.xml");
            //获取根节点的集合
            NodeList childNodes1 = document.getChildNodes();
            for (int i = 0; i < childNodes1.getLength(); i++) {
                Node item = childNodes1.item(i);
                String nodeName = item.getNodeName();
                //获取根节点的所有属性集合
                NamedNodeMap attr = item.getAttributes();
                //遍历根节点的属性
                System.out.println("第" + (i + 1) + "本书共有" + attr.getLength() + "个属性+++++++++++++++++++++++" + nodeName);
            }
            System.out.println("获取根节点集合长度：" + childNodes1.getLength());
            //获取所有book节点的集合
            NodeList book = document.getElementsByTagName("book");
            System.out.println("获取集合长度：" + book.getLength());
            System.out.println("一共有几本书：" + book.getLength());
            //遍历每一个book节点
            for (int i = 0; i < book.getLength(); i++) {
                System.out.println("================================下面开始遍历第" + (i + 1) + "本书的内容");
                //获取一个book节点（通过item）,索引值从0开始
                Node item = book.item(i);
                //获取book节点的所有属性集合
                NamedNodeMap attr = item.getAttributes();
                //遍历book的属性
                System.out.println("第" + (i + 1) + "本书共有" + attr.getLength() + "个属性");
                for (int j = 0; j < attr.getLength(); j++) {
                    //获取属性id=1/2
                    Node node = attr.item(j);
                    //获取属性名属性值
                    String nodeName = node.getNodeName();
                    String nodeValue = node.getNodeValue();
                    System.out.print("属性名：" + nodeName);
                    System.out.println("--属性值：" + nodeValue);

                }
                //使用Element的前提：已经知道book节点只有一个属性并且属性名叫做id
                Element bookss = (Element) book.item(i);
                String id = bookss.getAttribute("id");
                System.out.println("输出id属性的属性值为：" + id);
                //解析book的子节点
                NodeList childNodes = item.getChildNodes();
                //遍历获取节点名和节点值
                System.out.println("含有几个子节点（包含节点与节点之间的空格）：" + childNodes.getLength());
                for (int j = 0; j < childNodes.getLength(); j++) {
                    //遍历节点名称：空格+换行符为#text节点
//                    System.out.print(childNodes.item(j).getNodeName()+"|");
                    //获取element类型节点的节点名和节点值
                    if (childNodes.item(j).getNodeType() == Node.ELEMENT_NODE) {
                        System.out.print(childNodes.item(j).getNodeName() + "--");
//                        System.out.println(childNodes.item(j).getNodeValue());//null
                        //<></>之间的内容被看作为子节点的子节点
                        System.out.print(childNodes.item(j).getFirstChild().getNodeValue() + "--");
                        System.out.println(childNodes.item(j).getTextContent());

                    }
                }

                System.out.println("==================================结束遍历第" + (i + 1) + "本书的内容");

            }

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
