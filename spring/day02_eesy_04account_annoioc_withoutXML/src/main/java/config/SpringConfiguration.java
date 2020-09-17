package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @author 千文sea
 * @create 2020-09-17 17:00
 *
 * 该类是一个配置类,它的作用和xml的作用是一样的
 *
 * spring中的新注解
 * Configuration
 *      作用:指定当前类是一个配置类
 *      细节:当配置类作为AnnotationConfigApplicationContext对象创建的参数,该注解可以不写
 *
 * ComponentScan
 *      作用:用于通过注解指定spring在创建容器时要扫描的包
 *      属性:
 *          value: 它和backpackgesd的作用是一样的,都是用于指定穿甲容器时要扫描的包.
 *          我们使用此注解就等同于在xml中配置了: <context:component-scan base-package="com.shi"></context:component-scan>
 * Bean
 *      作用:用于把当前方法的返回值作为bean对象存入spring的ioc容器中.
 *      属性:
 *          name: 用于指定当前bean对象的id(默认值为当前方法的名称)
 *      细节:
 *          当我们使用注解配置方法时,如果方法有参数,spring框架会去容器中查找有没有可用的bean对象
 *          查找的方式和Autowired的作用一样
 *
 * Import
 *  作用:用于导入其他的配置类
 *  属性:
 *      value: 用于指定其他配置类的字节码
 *                 当我们使用Import注解之后,有Import注解的类就是父配置类,导入的就是子配置类
 *
 * PropertySource
 *      作用: 用于指定properties文件的位置
 *      属性:
 *          value: 指定文件的名称和路径
 *              关键字: classpath:表示在类路径下
 */
@Configuration
@ComponentScan(basePackages = {"com.shi"})
@Import(value = {JdbcConfig.class})
@PropertySource(value = "classpath:jdbcConfig.properties")
public class SpringConfiguration {


}
