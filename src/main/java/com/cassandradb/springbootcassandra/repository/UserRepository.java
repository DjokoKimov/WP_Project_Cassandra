package com.cassandradb.springbootcassandra.repository;

import com.cassandradb.springbootcassandra.model.User;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;

public interface  UserRepository extends CassandraRepository<User,Integer> {
    @AllowFiltering
    List<User> findBySalaryGreaterThan(int salary);
}
