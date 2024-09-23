package com.bootapp.springbootapplication.accessingdatamysql;

import org.springframework.data.repository.CrudRepository;
import com.bootapp.springbootapplication.accessingdatamysql.User;
public interface UserRepository extends CrudRepository<User,Integer> {
}
