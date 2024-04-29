class BaseItem {
  id: String;
  uid: String;
  name: String;
  description: String;
  prices: number;
  itemStatus: number;
  itemType:string;
  constructor(
    id?: String,
    uid?: String,
    name?: String,
    description?: String,
    prices?: number,
    itemStatus?: number,
    itemType?:string
  ) {
    this.id = id || "";
    this.uid = uid || "";
    this.name = name || "";
    this.description = description || "";
    this.prices = prices || 1000000;
    this.itemStatus = itemStatus || 0;
    this.itemType=itemType||"";
  }
}

export default BaseItem;
