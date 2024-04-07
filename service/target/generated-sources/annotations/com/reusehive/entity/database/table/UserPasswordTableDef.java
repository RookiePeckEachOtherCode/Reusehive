package com.reusehive.entity.database.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

// Auto generate by mybatis-flex, do not modify it.
public class UserPasswordTableDef extends TableDef {

    public static final UserPasswordTableDef USER_PASSWORD = new UserPasswordTableDef();

    public final QueryColumn UID = new QueryColumn(this, "uid");

    public final QueryColumn PASSWORD = new QueryColumn(this, "password");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{UID, PASSWORD};

    public UserPasswordTableDef() {
        super("", "user_pwd");
    }

    private UserPasswordTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public UserPasswordTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new UserPasswordTableDef("", "user_pwd", alias));
    }

}
