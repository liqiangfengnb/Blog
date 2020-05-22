package com.blog.Service.admin;

import com.blog.vo.admin.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TypeService {

    //增加
    Type SaveType(Type type);

    Type getType(Long id);

    Type getTypeByName(String name);

    List<Type> listType();

    List<Type> listTypeTop(Integer size);

    //查询
    Page<Type> listType(Pageable pageable);

    //修改
    Type updateType(Long id,Type type);

    //删除
    void deleteType(Long id);

}
