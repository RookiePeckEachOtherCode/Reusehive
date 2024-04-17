class BaseItem {
  id: String;
  uid: String;
  name: String;
  description: String;
  prices: number;
  type: number;

  constructor(
    id?: String,
    uid?: String,
    name?: String,
    description?: String,
    prices?: number,
    type?: number
  ) {
    this.id = id || "";
    this.uid = uid || "";
    this.name = name || "";
    this.description = description || "";
    this.prices = prices || 1000000;
    this.type = type || 0;
  }
}

export default BaseItem;
