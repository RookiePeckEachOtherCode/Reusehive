package com.reusehive.entity.database;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import com.mybatisflex.core.keygen.KeyGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.checkerframework.checker.units.qual.A;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Table("message")
public class Message {
    @Id(keyType = KeyType.Generator, value = KeyGenerators.snowFlakeId)
    private Long id;

    private Long toid;

    private Long fromid;

    private String content;

    private LocalDateTime createTime;



}
