package com.shi.java1;

import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * @author 千文sea
 * @create 2020-04-11 19:01
 */
public class java11Test {
    /*
    java11 新特性: String中新增方法
     */
    @Test
    public void test1(){
//        判断字符串是否为空白 " ".isBlank(); // true
        System.out.println(" \t\n ".isBlank());
//        去除首尾空白 " Javastack ".strip(); // "Javastack"
        System.out.println("---" + " \thelloworld\t\n ".strip() + "---");
        System.out.println("---" + " \thelloworld\t\n ".trim() + "---");
//        去除尾部空白 " Javastack ".stripTrailing(); // " Javastack"
        System.out.println("---" + " \thelloworld\t\n ".stripTrailing() + "---");
//        去除首部空白 " Javastack ".stripLeading(); // "Javastack "
        System.out.println("---" + " \thelloworld\t\n ".stripLeading() + "---");
//        复制字符串 "Java".repeat(3);// "JavaJavaJava"
        System.out.println("helloworld".repeat(2));
//        行数统计 "A\nB\nC".lines().count(); // 3
        System.out.println("a\n\nb\nc".lines().count());
    }

    /*
    java11 新特性2: Optional 加强
     */
    @Test
    public void test2(){
        Optional<Object> op = Optional.empty();
        System.out.println(op.isPresent());//判断内部的value是否存在
        System.out.println(op.isEmpty());//判断内部的value是否为空

        op = Optional.of("ABC");
        Object obj = op.orElseThrow(); //value非空，返回value；否则抛异常NoSuchElementException
        System.out.println(obj);

        //or
        Optional<String> op1 = Optional.of("hello");
        //value非空，返回对应的Optional；  op
        //value为空，返回形参封装的Optional  op1
        Optional<Object> op2 = op.or(() -> op1);
        System.out.println(op2);
    }
    /*
    java11 新特性3:局部变量类型推断升级
     */
    @Test
    public void test3(){
        //错误的形式: 必须要有类型, 可以加上var
//        Consumer<String> con1 = (@Deprecated t) ->System.out.println(t.toUpperCase());
        //正确的形式:
        //使用var的好处是在使用lambda表达式时给参数加上注解。
        Consumer<String> con2 = (@Deprecated var t) -> System.out.println(t.toUpperCase());
    }
    /*
    java11 新特性4:全新的HTTP 客户端API
     */
    @Test
    public void test4(){
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request =
                    HttpRequest.newBuilder(URI.create("http://127.0.0.1:8080/test/")).build();
            HttpResponse.BodyHandler<String> responseBodyHandler = HttpResponse.BodyHandlers.ofString();
            HttpResponse<String> response = client.send(request, responseBodyHandler);
            String body = response.body();
            System.out.println(body);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test5(){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request =
                HttpRequest.newBuilder(URI.create("http://127.0.0.1:8080/test/")).build();
        HttpResponse.BodyHandler<String> responseBodyHandler = HttpResponse.BodyHandlers.ofString();
        CompletableFuture<HttpResponse<String>> sendAsync =
                client.sendAsync(request, responseBodyHandler);
        sendAsync.thenApply(t -> t.body()).thenAccept(System.out::println);
        //HttpResponse<String> response = sendAsync.get();
        //String body = response.body();
        //System.out.println(body);
    }
}
