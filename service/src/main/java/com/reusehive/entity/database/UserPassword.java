package com.reusehive.entity.database;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserPassword {
    private Long id;
    private String password;
}
