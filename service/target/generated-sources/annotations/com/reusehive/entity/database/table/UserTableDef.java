package com.reusehive.entity.database.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

// Auto generate by mybatis-flex, do not modify it.
public class UserTableDef extends TableDef {

    public static final UserTableDef USER = new UserTableDef();

    public final QueryColumn ID = new QueryColumn(this, "id");

    public final QueryColumn NAME = new QueryColumn(this, "name");

    public final QueryColumn GRADE = new QueryColumn(this, "grade");

    public final QueryColumn GENDER = new QueryColumn(this, "gender");

    public final QueryColumn ACADEMY = new QueryColumn(this, "academy");

    public final QueryColumn BACK_IMG = new QueryColumn(this, "back_img");

    public final QueryColumn AVATAR_IMG = new QueryColumn(this, "avatar_img");

    public final QueryColumn SOCIAL_INFO = new QueryColumn(this, "social_info");

    public final QueryColumn PHONE_NUMBER = new QueryColumn(this, "phone_number");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, NAME, GRADE, GENDER, ACADEMY, BACK_IMG, AVATAR_IMG, SOCIAL_INFO, PHONE_NUMBER};

    public UserTableDef() {
        super("", "user");
    }

    private UserTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public UserTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new UserTableDef("", "user", alias));
    }

}
