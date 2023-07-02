package com.example.multipledb.repository.mysql;

import com.example.multipledb.entity.mysql.MysqlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaMysqlRepository extends JpaRepository<MysqlEntity, String> {

    @Query(value = "SELECT entity.name FROM MysqlEntity entity")
    String fetchNameFromMysql();
}
