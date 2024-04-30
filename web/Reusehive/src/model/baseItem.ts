class BaseItem {
    id: String;
    uid: String;
    name: String;
    description: String;
    prices: number;
    itemType: String;
    itemStatus: number;

    constructor(
        id?: String,
        uid?: String,
        name?: String,
        description?: String,
        prices?: number,
        itemType?: String,
        itemStatus?: number,
    ) {
        this.id = id || "";
        this.uid = uid || "";
        this.name = name || "";
        this.description = description || "";
        this.prices = prices || 1000000;
        this.itemType = itemType || "";
        this.itemStatus = itemStatus || -1;
    }
}

export default BaseItem;
