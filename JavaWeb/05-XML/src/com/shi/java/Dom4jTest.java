package com.shi.java;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

/**
 * @author 千文sea
 * @create 2020-04-16 15:37
 */
public class Dom4jTest {
   @Test
    public void test1() throws Exception {
       //创建一个输入流去读取xml配置方式,生成document对象
      SAXReader saxReader;
      try {
         saxReader = new SAXReader();
         Document document = saxReader.read("src/books.xml");
         System.out.println(document);
      } catch (DocumentException e) {
         e.printStackTrace();
      }
   }
   /*
   读取books.xml文件生成book类
    */
   @Test
   public void test2() throws DocumentException {
      //1.读取books.xml文件
      SAXReader saxReader = new SAXReader();
      Document document = saxReader.read("src//books.xml");
      //2.通过Document获取根元素
      Element rootElement = document.getRootElement();
      //3.通过根元素获取book标签对象
      //element()和elements()都是通过标签名来获取子元素
      List<Element> books = rootElement.elements("book");
      //4.遍历,处理每个book标签转换为Book类
      for (Element book:books) {
         //asXML(): 把标签对象转换为标签字符串
//         System.out.println(book.asXML());
         Element nameElement = book.element("name");
         //getText():获取便签中的文本内容
         String name = nameElement.getText();
         //elementText(): 获取指定标签里的内容
         String price = book.elementText("price");
         String author = book.elementText("author");
         String sn = book.attributeValue("SN");
         System.out.println(new book(sn,name,Double.parseDouble(price),author));
      }
   }
}
