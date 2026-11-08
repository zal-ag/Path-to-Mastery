package com.Silas.API.collection.equality;

import java.util.Objects;

public class StudentIdentity {
    private final String id;
    private String name;

    public StudentIdentity(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        // getClass() = this.getClass()，获取调用者的类
        if (o == null || getClass() != o.getClass()) return false; // 传入对象为空 或者 二者不是同一个类 返回false
        StudentIdentity that = (StudentIdentity) o; // 被传入的对象被包装为为 Object 类，后面需要用到子类特有的属性id，必须强转为对应类
        return Objects.equals(id, that.id); // 比较二者的id是否相同
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
