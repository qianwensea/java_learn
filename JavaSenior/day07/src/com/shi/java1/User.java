package com.shi.java1;

/**
 * @author 千文sea
 * @create 2020-04-03 19:32
 */
public class User implements Comparable{

        private String name;
        private int age;

        public User() {
        }

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            System.out.println("我是User方法");
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            com.shi.java1.User user = (com.shi.java1.User) o;

            if (age != user.age) return false;
            return name != null ? name.equals(user.name) : user.name == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + age;
            return result;
        }
        //按照姓名从小到大排序,再年龄从小到大
        @Override
        public int compareTo(Object o) {
            if(o instanceof com.shi.java1.User){
                com.shi.java1.User user = (com.shi.java1.User)o;
//            return this.name.compareTo(user.name);
                int compa = this.name.compareTo(user.name);
                if (compa != 0){
                    return compa;
                }else{
                    return Integer.compare(this.age,user.age);
                }
            }else{
                throw new RuntimeException("输入的类型不匹配");
            }
        }
    }


