package com.reusehive.entity.database.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

// Auto generate by mybatis-flex, do not modify it.
public class PurchaseInfoTableDef extends TableDef {

    public static final PurchaseInfoTableDef PURCHASE_INFO = new PurchaseInfoTableDef();

    public final QueryColumn ID = new QueryColumn(this, "id");

    public final QueryColumn UID = new QueryColumn(this, "uid");

    public final QueryColumn TYPE = new QueryColumn(this, "type");

    public final QueryColumn ITEM_ID = new QueryColumn(this, "item_id");

    public final QueryColumn PRICES = new QueryColumn(this, "prices");

    public final QueryColumn CREATE_TIME = new QueryColumn(this, "create_time");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, UID, TYPE, ITEM_ID, PRICES, CREATE_TIME};

    public PurchaseInfoTableDef() {
        super("", "purchase_info");
    }

    private PurchaseInfoTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public PurchaseInfoTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new PurchaseInfoTableDef("", "purchase_info", alias));
    }

}
