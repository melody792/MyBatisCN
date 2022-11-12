package org.apache.ibatis.reflection;

import org.apache.ibatis.pzb.Blog;
import org.apache.ibatis.pzb.Comment;
import org.apache.ibatis.pzb.User;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.apache.ibatis.reflection.wrapper.BeanWrapper;
import org.apache.ibatis.session.Configuration;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

class MetaObjectTest {

    @Test
    public void testMetaObject() {
        /**
         * 1 mybatis反射工具类模拟setter getter
         * 2 操作子属性
         * 3 自动创建子对象
         * 4 查找属性名，支持驼峰命名
         * 5 基于索引访问List数据
         * 6 操作map
         */
        Blog blog = mockBlog();
        Configuration configuration = new Configuration();
        MetaObject metaObject = configuration.newMetaObject(blog);
        //2
        metaObject.setValue("author.id", 1);
        System.out.println(metaObject.getValue("author.id"));
        //4
        System.out.println(metaObject.findProperty("author.phone_number", true));
        //5
        System.out.println(metaObject.getValue("comments[0].user.name"));
        //6
        metaObject.setValue("labels", new HashMap<>());
        metaObject.setValue("labels[red_key]", blog.getAuthor());
        System.out.println(metaObject.getValue("labels[red_key].id"));
    }

    @Test
    public void testBeanWrapper() {
        Blog blog = mockBlog();
        Configuration configuration = new Configuration();
        MetaObject metaObject = configuration.newMetaObject(blog);
        metaObject.getValue("comments[0].user.name");
        BeanWrapper beanWrapper = new BeanWrapper(metaObject, blog);
        //两种处理方式
        beanWrapper.get(new PropertyTokenizer("comments[0]"));
        beanWrapper.get(new PropertyTokenizer("comments"));
    }

    @NotNull
    private Blog mockBlog() {
        Blog blog = new Blog();
        Comment comment =new Comment();
        User user = new User();
        user.setName("mock user name");
        comment.setUser(user);
        ArrayList<Comment> comments = new ArrayList<>();
        comments.add(comment);
        blog.setComments(comments);
        return blog;
    }
}