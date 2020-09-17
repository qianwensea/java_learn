package com.shi.java1;

import org.junit.Test;

import java.util.*;

/**一.Map的结构
 * |----Map: 双列数据,存储 key --> value对的数据 ----- 类似于 y = f(x)
 *          |----HashMap: 作为Map的主要实现类,线程不安全的,效率高; 可以存储null的key和valu
 *              |----LinkedHashMap: 保证在遍历Map元素时,可以按照添加的顺序实现遍历.
 *                                      原因: 在原有的HashMap底层结构基础上,添加了一对指针,指向前一个和后一个元素
 *                                       对于频繁的遍历操作,此类效率更高
 *          |----TreeMap: 可以按照添加的key-->value对进行排序,实现排序遍历.此时使用考虑key的自然排序和定制排序
 *                          底层使用的是红黑树
 *          |----Hashtable: 作为Map的古老实现类,线程安全,效率较低;不可以存储null的key和valu
 *              |----Properties: 常用来处理配置文件,key 和 value都是String类型的
 *
 *      HashMap的底层: 数组 + 链表(jdk7及之前)
 *                    数组 + 链表 + 红黑树(jdk８)
 *  面试题:
 *  1.HashMap的底层实现原理:
 *
 *  2.HashMap 和 Hashtable的异同
 *
 *  3.CurrentHashMap和Hashtable的异同?
 *
 *
 *  二.Map结构的理解
 *      Map中的key: 无序的,不可重复的,使用Set存储所有的key --> 要求key所在的类要重写equals()和hashCode() (以HashMap为例要求的)
 *      Map中的value: 无序的,可重复的,使用Collection存储所有的value --> 要求所在类要重写equals()
 *      一个键值对: key-value构成了一个Entry对象
 *      Map中的Entry: 无序的,不可重复的,使用Set来存储所有的entry
 *
 *  三.HashMap的底层实现原理?
 *  以jdk 7为例说明:
 *      HashMap map = new HashMap():
 *      在实例化以后,底层创建了长度为16的一维数组Entry[] table;
 *      map.put(key1,value1):
 *      首先,计算key1所在类的HashCode()计算key1的哈希值,此哈希值经过某种算法计算后,得到在Entry数组中的位置.
 *      如果此位置上数据为空,此时的key1-value1添加成功.  ---情况1
 *      如果此位置上的数据不为空,(意味着此位置上存在一个或多个数据(以链表形式存在)),比较key1和已经存在的一个或多个数据的哈希值:
 *          如果key1的哈希值与已经存在的数据的哈希值不同,此时key1-value1添加成功  ---情况2
 *          如果key1的哈希值与已经存在的某个数据(key2-value2)的哈希值相同,继续比较:调用key1所在类的equals()方法,比较:
 *              如果equals()返回false:此时key1-value1添加成功 ---情况3
 *              如果equals()返回true: 使用value1替换value2.
 *
 *       补充: 关于情况2和情况3: 此时key1-value1和原来的数据以链表的方式存储
 *       在不断的添加过程中,会涉及到扩容(超出临界值(且要存放的位置非空)),默认的扩容方式: 扩容为原来的2倍,并将原来的数据复制过来
 *
 *       jdk 8相较于jdk 7在底层实现方面的不同:
 *       1. 在new HashMap():底层没有创建一个长度为16的数组
 *       2. jdk 8底层的数组是: Node[],而非Entry[]
 *       3. 首次调用put()方法时,底层才创建长度为16的数组
 *       4. jdk7底层结构只有:数组 + 链表. jdk8中底层结构为: 数组 + 链表 + 红黑树
 *          当数组的某一个索引位置上的元素以链表的形式存在的数据个数 > 8且当前数组的长度 > 64时,
 *          此时此索引位置上的所有数据改为使用红黑树存储.
 *
 *  DEFAULT_INITIAL_CAPACITY : HashMap的默认容量，16
 * MAXIMUM_CAPACITY ： HashMap的最大支持容量，2^30
 * DEFAULT_LOAD_FACTOR：HashMap的默认加载因子 0.75
 * threshold：扩容的临界值，=容量*填充因子 : 16*0.75 = 12
 * TREEIFY_THRESHOLD：Bucket中链表长度大于该默认值，转化为红黑树  8
 * MIN_TREEIFY_CAPACITY：桶中的Node被树化时最小的hash表容量。  64
 *
 * 四.LinkedHashMap的底层实现(了解即可)
 *  源码中:
 *  static class Entry<K,V> extends HashMap.Node<K,V> {
 *         Entry<K,V> before, after; //能够记录添加的元素的先后顺序
 *         Entry(int hash, K key, V value, Node<K,V> next) {
 *             super(hash, key, value, next);
 *         }
 *     }
 *
 * 五.Map接口中的常用方法
 * 添加、删除、修改操作：
 *  Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
 *  void putAll(Map m):将m中的所有key-value对存放到当前map中
 *  Object remove(Object key)：移除指定key的key-value对，并返回value
 *  void clear()：清空当前map中的所有数据
 *  元素查询的操作：
 *  Object get(Object key)：获取指定key对应的value
 *  boolean containsKey(Object key)：是否包含指定的key
 *  boolean containsValue(Object value)：是否包含指定的value
 *  int size()：返回map中key-value对的个数
 *  boolean isEmpty()：判断当前map是否为空
 *  boolean equals(Object obj)：判断当前map和参数对象obj是否相等
 *  元视图操作的方法：
 *  Set keySet()：返回所有key构成的Set集合
 *  Collection values()：返回所有value构成的Collection集合
 *  Set entrySet()：返回所有key-value对构成的Set集合
 *
 *  总结:常用方法
 *  添加: put(Object key,Object value)
 *  删除: remove()
 *  修改  put(Object key,Object value)
 *  查询: get()
 *  长度: size()
 *  遍历:
 *
 * @author 千文sea
 * @create 2020-04-03 15:59
 */
public class MapTest {
    /*
     元视图操作的方法：
 *  Set keySet()：返回所有key构成的Set集合
 *  Collection values()：返回所有value构成的Collection集合
 *  Set entrySet()：返回所有key-value对构成的Set集合
     */
    @Test
    public void test5(){
        Map map = new HashMap();
        map.put("AA",123);
        map.put("BB",183);
        map.put(22,133);
        Set set = map.keySet();
        //遍历所有的key
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //遍历所有的value
        Collection values = map.values();
        for(Object obj : values){
            System.out.println(obj);
        }

        //遍历所有的key-value
        Set set1 = map.entrySet();
//        for (Object obj : set1){
//            System.out.println(obj);
//        }
        Iterator iterator1 = set1.iterator();
        while (iterator1.hasNext()){
            Object obj = iterator1.next();
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }
    }
    /*
     元素查询的操作：
 *  Object get(Object key)：获取指定key对应的value
 *  boolean containsKey(Object key)：是否包含指定的key
 *  boolean containsValue(Object value)：是否包含指定的value
 *  int size()：返回map中key-value对的个数
 *  boolean isEmpty()：判断当前map是否为空
 *  boolean equals(Object obj)：判断当前map和参数对象obj是否相等
     */
    @Test
    public void test4(){
        Map map = new HashMap();
        map.put("AA",123);
        map.put("BB",123);
        map.put(22,123);
        System.out.println(map.get(22));
        System.out.println(map.get(222));

        System.out.println(map.containsKey("AA"));
        System.out.println(map.containsValue(123));
        System.out.println(map.isEmpty());

        Map map1 = new HashMap();
        map1.put("AA",123);
        map1.put("BB",123);
        map1.put(22,123);
        System.out.println(map.equals(map1));
    }

    /*
    添加、删除、修改操作：
 *  Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
 *  void putAll(Map m):将m中的所有key-value对存放到当前map中
 *  Object remove(Object key)：移除指定key的key-value对，并返回value
 *  void clear()：清空当前map中的所有数据
     */
    @Test
    public void test3(){
        Map map = new HashMap();
        map.put("AA",123);
        //修改的AA的value
        map.put("AA",144);
        map.put("BB",123);
        map.put(22,123);
        System.out.println(map);
        Map map1 = new HashMap();
        map1.put("CC",222);
        map1.put(99,222);
        map.putAll(map1);
        System.out.println(map);
        Object value = map.remove(22);
        System.out.println(map);
        boolean remove = map.remove(99, 222);
        System.out.println(map);
        map.clear();
        System.out.println(map.size());
        System.out.println(map);
    }
    @Test
    public void test2(){
        Map map = new LinkedHashMap();
        map.put(123,"AA");
        map.put(345,"BB");
        map.put(678,"CC");
        System.out.println(map);
    }
    @Test
    public void test1(){
        Map map = new HashMap();
        map.put(null,null);
        Map map1 = new Hashtable();
        map1.put(null,null); //java.lang.NullPointerException
    }
}
