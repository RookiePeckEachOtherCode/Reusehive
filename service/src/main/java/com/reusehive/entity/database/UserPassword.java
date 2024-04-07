package com.reusehive.entity.database;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import com.mybatisflex.core.keygen.KeyGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("user_pwd")
public class UserPassword {
    @Id(keyType = KeyType.Generator, value = KeyGenerators.snowFlakeId)
    private Long uid;
    private String password;
}
