package com.reusehive.entity.database;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserPassword {
    private long id;
    private String password;
}
