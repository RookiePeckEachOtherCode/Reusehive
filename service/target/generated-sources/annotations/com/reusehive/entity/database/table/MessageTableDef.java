package com.reusehive.entity.database.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

// Auto generate by mybatis-flex, do not modify it.
public class MessageTableDef extends TableDef {

    public static final MessageTableDef MESSAGE = new MessageTableDef();

    public final QueryColumn ID = new QueryColumn(this, "id");

    public final QueryColumn CONTENT = new QueryColumn(this, "content");

    public final QueryColumn CREATE_TIME = new QueryColumn(this, "create_time");

    public final QueryColumn TOUSERNAME = new QueryColumn(this, "tousername");

    public final QueryColumn FROMUSERNAME = new QueryColumn(this, "fromusername");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, CONTENT, CREATE_TIME, TOUSERNAME, FROMUSERNAME};

    public MessageTableDef() {
        super("", "message");
    }

    private MessageTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public MessageTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new MessageTableDef("", "message", alias));
    }

}
