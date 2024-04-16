class Item {
  id: String;
  uid: String;
  name: string;
  description: string;
  prices: number;
  type: number;

  constructor(
    id: String,
    uid: String,
    name: string,
    description: string,
    prices: number,
    type: number
  ) {
    this.id = id;
    this.uid = uid;
    this.name = name;
    this.description = description;
    this.prices = prices;
    this.type = type;
  }
}

export default Item;
