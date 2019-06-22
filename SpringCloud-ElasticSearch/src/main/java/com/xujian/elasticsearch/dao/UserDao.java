package com.xujian.elasticsearch.dao;

import com.xujian.elasticsearch.pojo.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface UserDao extends ElasticsearchRepository<User, Long> {

    /**
     * 自定义接口，可以进行定义查询
     *
     * @param name
     * @param pageable
     * @return
     */
    Page<User> findUserByName(String name, Pageable pageable);

}
