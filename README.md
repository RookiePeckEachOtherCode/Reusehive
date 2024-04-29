# ReuseHive

RuseHive，译名 `蜂巢回收`。一个校园二手交易app


**接口文档**
 
---
title: Reusehive
language_tabs:
- shell: Shell
- http: HTTP
- javascript: JavaScript
- ruby: Ruby
- python: Python
- php: PHP
- java: Java
- go: Go
  toc_footers: []
  includes: []
  search: true
  code_clipboard: true
  highlight_theme: darkula
  headingLevel: 2
  generator: "@tarslib/widdershins v4.0.23"

---

# Reusehive

Base URLs:localhost:8888

# Authentication

# 用户接口

## POST 用户注册

POST /user/register

> Body 请求参数

```yaml
avatar_img: string
back_img: string

```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|name|query|string| 否 |none|
|password|query|string| 否 |none|
|gender|query|string| 否 |none|
|grade|query|string| 否 |none|
|academy|query|string| 否 |none|
|phone_number|query|string| 否 |none|
|social_info|query|string| 否 |none|
|body|body|object| 否 |none|
|» avatar_img|body|string(binary)| 否 |none|
|» back_img|body|string(binary)| 否 |none|

> 返回示例

> 成功

```json
{
  "msg": "",
  "code": 0,
  "data": 0
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[Result«String»](#schemaresult«string»)|

## POST 用户登陆

POST /user/login

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|name|query|string| 否 |none|
|password|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "msg": "",
  "code": 0,
  "data": 0
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[Result«String»](#schemaresult«string»)|

## GET 退出登陆

GET /user/logout

> 返回示例

> 成功

```json
{
  "msg": "",
  "code": 0,
  "data": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[Result«None»](#schemaresult«none»)|

## GET 根据id获取用户信息

GET /user/{id}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "msg": "",
  "code": 0,
  "data": {
    "id": 0,
    "name": "",
    "gender": "",
    "grade": "",
    "academy": "",
    "phone_number": "",
    "social_info": ""
  }
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[Result«User»](#schemaresult«user»)|

## GET 获取当前用户信息

GET /me

> 返回示例

> 成功

```json
{
  "msg": "",
  "code": 0,
  "data": {
    "id": 0,
    "name": "",
    "gender": "",
    "grade": "",
    "academy": "",
    "phone_number": "",
    "social_info": "",
    "avatar_img": "",
    "back_img": ""
  }
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[Result«User»](#schemaresult«user»)|

## GET 根据用户名获取用户信息

GET /user/name/{name}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|name|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "msg": "",
  "code": 0,
  "data": {
    "id": 0,
    "name": "",
    "gender": "",
    "grade": "",
    "academy": "",
    "phone_number": "",
    "social_info": ""
  }
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[Result«User»](#schemaresult«user»)|

## POST 修改用户信息

POST /user/update

> Body 请求参数

```yaml
avatar_img: string
back_img: string

```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|name|query|string| 否 |none|
|gender|query|string| 否 |none|
|grade|query|string| 否 |none|
|academy|query|string| 否 |none|
|phone_number|query|string| 否 |none|
|social_info|query|string| 否 |none|
|body|body|object| 否 |none|
|» avatar_img|body|string(binary)| 否 |none|
|» back_img|body|string(binary)| 否 |none|

> 返回示例

> 成功

```json
{
  "msg": "",
  "code": 0,
  "data": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[Result«None»](#schemaresult«none»)|

## POST 删除用户

POST /user/delete

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|query|integer| 否 |none|

> 返回示例

> 成功

```json
{
  "msg": "",
  "code": 0,
  "data": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[Result«None»](#schemaresult«none»)|

## GET 获取用户信息及其物品列表

GET /user-items/{id}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "msg": "",
  "code": 0,
  "data": {
    "user": {
      "id": 0,
      "name": "",
      "gender": "",
      "grade": "",
      "academy": "",
      "phone_number": "",
      "social_info": "",
      "avatar_img": "",
      "back_img": ""
    },
    "items": [
      {
        "item": {
          "id": 0,
          "uid": 0,
          "name": "",
          "description": "",
          "prices": 0,
          "itemStatus": 0,
          "itemType": ""
        },
        "images": [
          ""
        ]
      }
    ]
  }
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[Result«UserItemsInfo»](#schemaresult«useritemsinfo»)|

## POST UploadIcon

POST /user/{id}/upload

> Body 请求参数

```yaml
file: string

```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|path|string| 是 |none|
|body|body|object| 否 |none|
|» file|body|string(binary)| 否 |none|

> 返回示例

> 成功

```json
{
  "msg": "",
  "code": 0,
  "data": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[Result«String»](#schemaresult«string»)|

## GET 获取用户聊天对象

GET /user/chatsinfo

> 返回示例

> 成功

```json
{
  "msg": "",
  "code": 0,
  "data": [
    {
      "id": 0,
      "name": "",
      "gender": "",
      "grade": "",
      "academy": "",
      "phone_number": "",
      "social_info": "",
      "avatar_img": "",
      "back_img": ""
    }
  ]
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[Result«List«User»»](#schemaresult«list«user»»)|

## GET VerifyToken

GET /user/verify

> 返回示例

> 成功

```json
{
  "msg": "",
  "code": 0,
  "data": false
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[Result«Boolean»](#schemaresult«boolean»)|

# 交易接口

## POST 建立交易

POST /purchase/new

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|item_id|query|integer| 是 |none|
|item_uid|query|integer| 是 |none|
|price|query|number| 是 |none|

> 返回示例

> 成功

```json
{
  "msg": "",
  "code": 0,
  "data": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[Result«Long»](#schemaresult«long»)|

## POST 结束交易

POST /purchase/end

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|purchase_id|query|integer| 是 |none|

> 返回示例

> 成功

```json
{
  "msg": "",
  "code": 0,
  "data": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[Result«None»](#schemaresult«none»)|

## POST 取消交易

POST /purchase/cancel

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|purchase_id|query|integer| 是 |none|

> 返回示例

> 成功

```json
{
  "msg": "",
  "code": 0,
  "data": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[Result«None»](#schemaresult«none»)|

## GET 获取用户交易列表

GET /purchase/user/list

> 返回示例

> 成功

```json
{
  "msg": "",
  "code": 0,
  "data": [
    {
      "id": 0,
      "uid": 0,
      "itemId": 0,
      "createTime": "",
      "prices": 0,
      "lock": false,
      "lockTime": ""
    }
  ]
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[Result«List«PurchaseInfo»»](#schemaresult«list«purchaseinfo»»)|

## GET 根据id获取交易信息

GET /purchase/{purchase_id}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|purchase_id|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "msg": "",
  "code": 0,
  "data": {
    "id": 0,
    "uid": 0,
    "itemId": 0,
    "createTime": "",
    "prices": 0,
    "lock": false,
    "lockTime": ""
  }
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[Result«PurchaseInfo»](#schemaresult«purchaseinfo»)|

## POST 下架物品

POST /purchase/remove

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|item_id|query|integer| 是 |none|

> 返回示例

> 成功

```json
{
  "msg": "",
  "code": 0,
  "data": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[Result«None»](#schemaresult«none»)|

# 物品接口

## POST 新建物品

POST /item/new

> Body 请求参数

```yaml
images: file:///home/beri/Pictures/wallpapers/wallhaven-o5g125.jpg

```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|name|query|string| 否 |none|
|description|query|string| 否 |none|
|prices|query|number| 否 |none|
|itemType|query|string| 否 |none|
|body|body|object| 否 |none|
|» images|body|string(binary)| 是 |none|

> 返回示例

> 成功

```json
{
  "msg": "",
  "code": 0,
  "data": 0
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[Result«Long»](#schemaresult«long»)|

## GET 根据id获取物品信息

GET /item/{id}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "msg": "",
  "code": 0,
  "data": {
    "item": {
      "id": 0,
      "uid": 0,
      "name": "",
      "description": "",
      "prices": 0,
      "itemStatus": 0,
      "itemType": ""
    },
    "images": [
      ""
    ]
  }
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[Result«ItemDetail»](#schemaresult«itemdetail»)|

## GET 根据uid获取用户所有物品信息

GET /item/user/{uid}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|uid|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "msg": "",
  "code": 0,
  "data": [
    {
      "id": 0,
      "uid": 0,
      "name": "",
      "description": "",
      "prices": 0,
      "itemStatus": 0,
      "itemType": ""
    }
  ]
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[Result«List«ItemDetail»»](#schemaresult«list«itemdetail»»)|

## GET 获取所有物品列表

GET /item/all

> 返回示例

> 成功

```json
{
  "msg": "",
  "code": 0,
  "data": [
    {
      "item": {
        "id": 0,
        "uid": 0,
        "name": "",
        "description": "",
        "prices": 0,
        "itemStatus": 0,
        "itemType": ""
      },
      "images": [
        ""
      ]
    }
  ]
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[Result«List«ItemDetail»»](#schemaresult«list«itemdetail»»)|

## POST 更新物品信息

POST /item/update

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|query|integer| 否 |none|
|name|query|string| 否 |none|
|description|query|string| 否 |none|
|prices|query|number| 否 |none|
|type|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "msg": "",
  "code": 0,
  "data": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[Result«None»](#schemaresult«none»)|

## POST 删除物品

POST /item/delete

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|query|integer| 否 |none|

> 返回示例

> 成功

```json
{
  "msg": "",
  "code": 0,
  "data": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[Result«None»](#schemaresult«none»)|

## POST 更新物品状态为未交易

POST /item/update/status/undo

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|query|integer| 否 |none|

> 返回示例

> 成功

```json
{
  "msg": "",
  "code": 0,
  "data": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[Result«None»](#schemaresult«none»)|

## POST 更新物品状态为交易中

POST /item/update/status/trading

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|query|integer| 否 |none|

> 返回示例

> 成功

```json
{
  "msg": "",
  "code": 0,
  "data": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[Result«None»](#schemaresult«none»)|

## POST 更新物品状态为已完成

POST /item/update/status/done

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|query|integer| 否 |none|

> 返回示例

> 成功

```json
{
  "msg": "",
  "code": 0,
  "data": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[Result«None»](#schemaresult«none»)|

## GET 根据物品类型获取物品列表

GET /item/type/{type}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|type|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "msg": "",
  "code": 0,
  "data": [
    {
      "id": 0,
      "uid": 0,
      "name": "",
      "description": "",
      "prices": 0,
      "itemStatus": 0,
      "itemType": ""
    }
  ]
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[Result«List«Item»»](#schemaresult«list«item»»)|

## GET 根据物品id获取物品图片url列表

GET /item/image

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|query|integer| 否 |none|

> 返回示例

> 成功

```json
{
  "msg": "",
  "code": 0,
  "data": [
    ""
  ]
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[Result«List«String»»](#schemaresult«list«string»»)|

## POST 当前用户添加物品到收藏

POST /item/collection/add

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|item_id|query|integer| 是 |none|

> 返回示例

> 成功

```json
{
  "msg": "",
  "code": 0,
  "data": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[Result«Boolean»](#schemaresult«boolean»)|

## POST 根据id添加物品图片

POST /item/image/add

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|query|integer| 否 |none|
|imageUrl|query|array[string]| 否 |none|

> 返回示例

> 成功

```json
{
  "msg": "",
  "code": 0,
  "data": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[Result«None»](#schemaresult«none»)|

## GET 获得当前用户的收藏列表

GET /item/collection/query

> 返回示例

> 成功

```json
{
  "msg": "",
  "code": 0,
  "data": [
    {
      "item": {
        "id": 0,
        "uid": 0,
        "name": "",
        "description": "",
        "prices": 0,
        "itemStatus": 0,
        "itemType": ""
      },
      "images": [
        ""
      ]
    }
  ]
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[Result«List«ItemDetail»»](#schemaresult«list«itemdetail»»)|

## POST 当前用户取消收藏

POST /item/collection/delete

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|item_id|query|integer| 是 |none|

> 返回示例

> 成功

```json
{
  "msg": "",
  "code": 0,
  "data": {}
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[Result«Boolean»](#schemaresult«boolean»)|

## GET 当前用户是否收藏

GET /item/collection/collected

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|item_id|query|integer| 是 |none|

> 返回示例

> 成功

```json
{
  "msg": "",
  "code": 0,
  "data": false
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[Result«Boolean»](#schemaresult«boolean»)|

## GET 条件搜索物品

GET /item/search

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|condition|query|string| 是 |none|

> 返回示例

> 成功

```json
{
  "msg": "",
  "code": 0,
  "data": [
    {
      "item": {
        "id": 0,
        "uid": 0,
        "name": "",
        "description": "",
        "prices": 0,
        "itemStatus": 0,
        "itemType": ""
      },
      "images": [
        ""
      ]
    }
  ]
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» msg|string¦null|false|none||none|
|» code|integer¦null|false|none||none|
|» data|[object]|false|none||none|
|»» item|[Item](#schemaitem)|false|none||none|
|»»» id|integer¦null|false|none||none|
|»»» uid|integer¦null|false|none||none|
|»»» name|string¦null|false|none||none|
|»»» description|string¦null|false|none||none|
|»»» prices|number¦null|false|none||none|
|»»» itemStatus|integer¦null|false|none||none|
|»»» itemType|string¦null|false|none||none|
|»» images|[string]|false|none||none|

# 对象存储接口

## POST 上传用户头像

POST /oss/upload/user_icon

> Body 请求参数

```yaml
icon: string

```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|object| 否 |none|
|» icon|body|string(binary)| 否 |none|

> 返回示例

> 成功

```json
{
  "msg": "",
  "code": 0,
  "data": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[Result«String»](#schemaresult«string»)|

## POST 上传物品背景图

POST /oss/upload/item_back

> Body 请求参数

```yaml
item_back: string

```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|object| 否 |none|
|» item_back|body|string(binary)| 否 |none|

> 返回示例

> 成功

```json
{
  "msg": "",
  "code": 0,
  "data": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[Result«String»](#schemaresult«string»)|

## POST 上传用户背景图

POST /oss/upload/user_back

> Body 请求参数

```yaml
user_back: string

```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|object| 否 |none|
|» user_back|body|string(binary)| 否 |none|

> 返回示例

> 成功

```json
{
  "msg": "",
  "code": 0,
  "data": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[Result«String»](#schemaresult«string»)|

## GET 预览用户头像

GET /oss/preview/user_icon

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|uid|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "msg": "",
  "code": 0,
  "data": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[Result«String»](#schemaresult«string»)|

## GET 预览物品背景图

GET /oss/preview/item_back

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|uid|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "msg": "",
  "code": 0,
  "data": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[Result«String»](#schemaresult«string»)|

## GET 预览用户背景图

GET /oss/preview/user_back

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|uid|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "msg": "",
  "code": 0,
  "data": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[Result«String»](#schemaresult«string»)|

# 数据模型

<h2 id="tocS_Result<<List<<Purchase>>>>">Result<<List<<Purchase>>>></h2>

<a id="schemaresult<<list<<purchase>>>>"></a>
<a id="schema_Result<<List<<Purchase>>>>"></a>
<a id="tocSresult<<list<<purchase>>>>"></a>
<a id="tocsresult<<list<<purchase>>>>"></a>

```json
{
  "msg": "string",
  "code": 0,
  "data": [
    {
      "id": 0,
      "uid": 0,
      "itemId": 0,
      "itemUid": 0,
      "createTime": "string",
      "prices": 0,
      "lock": true,
      "lockTime": "string"
    }
  ]
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|msg|string|true|none||none|
|code|integer|true|none||none|
|data|[[PurchaseInfo](#schemapurchaseinfo)]|true|none||none|

<h2 id="tocS_Result«UserItemsInfo»">Result«UserItemsInfo»</h2>

<a id="schemaresult«useritemsinfo»"></a>
<a id="schema_Result«UserItemsInfo»"></a>
<a id="tocSresult«useritemsinfo»"></a>
<a id="tocsresult«useritemsinfo»"></a>

```json
{
  "msg": "string",
  "code": 0,
  "data": {
    "user": {
      "id": 0,
      "name": "string",
      "gender": "string",
      "grade": "string",
      "academy": "string",
      "phone_number": "string",
      "social_info": "string",
      "avatar_img": "string",
      "back_img": "string"
    },
    "items": [
      {
        "item": {
          "id": 0,
          "uid": 0,
          "name": "string",
          "description": "string",
          "prices": 0,
          "itemStatus": 0,
          "itemType": "string"
        },
        "images": [
          "string"
        ]
      }
    ]
  }
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|msg|string¦null|false|none||none|
|code|integer¦null|false|none||none|
|data|[UserItemsInfo](#schemauseritemsinfo)|false|none||none|

<h2 id="tocS_Result«String»">Result«String»</h2>

<a id="schemaresult«string»"></a>
<a id="schema_Result«String»"></a>
<a id="tocSresult«string»"></a>
<a id="tocsresult«string»"></a>

```json
{
  "msg": "string",
  "code": 0,
  "data": "string"
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|msg|string¦null|false|none||none|
|code|integer¦null|false|none||none|
|data|string¦null|false|none||none|

<h2 id="tocS_UserItemsInfo">UserItemsInfo</h2>

<a id="schemauseritemsinfo"></a>
<a id="schema_UserItemsInfo"></a>
<a id="tocSuseritemsinfo"></a>
<a id="tocsuseritemsinfo"></a>

```json
{
  "user": {
    "id": 0,
    "name": "string",
    "gender": "string",
    "grade": "string",
    "academy": "string",
    "phone_number": "string",
    "social_info": "string",
    "avatar_img": "string",
    "back_img": "string"
  },
  "items": [
    {
      "item": {
        "id": 0,
        "uid": 0,
        "name": "string",
        "description": "string",
        "prices": 0,
        "itemStatus": 0,
        "itemType": "string"
      },
      "images": [
        "string"
      ]
    }
  ]
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|user|[User](#schemauser)|false|none||none|
|items|[[ItemDetail](#schemaitemdetail)]¦null|false|none||none|

<h2 id="tocS_Result«Boolean»">Result«Boolean»</h2>

<a id="schemaresult«boolean»"></a>
<a id="schema_Result«Boolean»"></a>
<a id="tocSresult«boolean»"></a>
<a id="tocsresult«boolean»"></a>

```json
{
  "msg": "string",
  "code": 0,
  "data": true
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|msg|string¦null|false|none||none|
|code|integer¦null|false|none||none|
|data|boolean¦null|false|none||none|

<h2 id="tocS_Result«List«String»»">Result«List«String»»</h2>

<a id="schemaresult«list«string»»"></a>
<a id="schema_Result«List«String»»"></a>
<a id="tocSresult«list«string»»"></a>
<a id="tocsresult«list«string»»"></a>

```json
{
  "msg": "string",
  "code": 0,
  "data": [
    "string"
  ]
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|msg|string¦null|false|none||none|
|code|integer¦null|false|none||none|
|data|[string]¦null|false|none||none|

<h2 id="tocS_Result«PurchaseInfo»">Result«PurchaseInfo»</h2>

<a id="schemaresult«purchaseinfo»"></a>
<a id="schema_Result«PurchaseInfo»"></a>
<a id="tocSresult«purchaseinfo»"></a>
<a id="tocsresult«purchaseinfo»"></a>

```json
{
  "msg": "string",
  "code": 0,
  "data": {
    "id": 0,
    "uid": 0,
    "itemId": 0,
    "itemUid": 0,
    "createTime": "string",
    "prices": 0,
    "lock": true,
    "lockTime": "string"
  }
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|msg|string¦null|false|none||none|
|code|integer¦null|false|none||none|
|data|[PurchaseInfo](#schemapurchaseinfo)|false|none||none|

<h2 id="tocS_Result«List«ItemDetail»»">Result«List«ItemDetail»»</h2>

<a id="schemaresult«list«itemdetail»»"></a>
<a id="schema_Result«List«ItemDetail»»"></a>
<a id="tocSresult«list«itemdetail»»"></a>
<a id="tocsresult«list«itemdetail»»"></a>

```json
{
  "msg": "string",
  "code": 0,
  "data": [
    {
      "item": {
        "id": 0,
        "uid": 0,
        "name": "string",
        "description": "string",
        "prices": 0,
        "itemStatus": 0,
        "itemType": "string"
      },
      "images": [
        "string"
      ]
    }
  ]
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|msg|string¦null|false|none||none|
|code|integer¦null|false|none||none|
|data|[[ItemDetail](#schemaitemdetail)]¦null|false|none||none|

<h2 id="tocS_Result«UserPurchaseInfo»">Result«UserPurchaseInfo»</h2>

<a id="schemaresult«userpurchaseinfo»"></a>
<a id="schema_Result«UserPurchaseInfo»"></a>
<a id="tocSresult«userpurchaseinfo»"></a>
<a id="tocsresult«userpurchaseinfo»"></a>

```json
{
  "msg": "string",
  "code": 0,
  "data": {
    "user": {
      "id": 0,
      "name": "string",
      "gender": "string",
      "grade": "string",
      "academy": "string",
      "phone_number": "string",
      "social_info": "string",
      "avatar_img": "string",
      "back_img": "string"
    },
    "items": [
      {
        "id": 0,
        "uid": 0,
        "itemId": 0,
        "itemUid": 0,
        "createTime": "string",
        "prices": 0,
        "lock": true,
        "lockTime": "string"
      }
    ]
  }
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|msg|string¦null|false|none||none|
|code|integer¦null|false|none||none|
|data|[UserPurchaseInfo](#schemauserpurchaseinfo)|false|none||none|

<h2 id="tocS_UserPurchaseInfo">UserPurchaseInfo</h2>

<a id="schemauserpurchaseinfo"></a>
<a id="schema_UserPurchaseInfo"></a>
<a id="tocSuserpurchaseinfo"></a>
<a id="tocsuserpurchaseinfo"></a>

```json
{
  "user": {
    "id": 0,
    "name": "string",
    "gender": "string",
    "grade": "string",
    "academy": "string",
    "phone_number": "string",
    "social_info": "string",
    "avatar_img": "string",
    "back_img": "string"
  },
  "items": [
    {
      "id": 0,
      "uid": 0,
      "itemId": 0,
      "itemUid": 0,
      "createTime": "string",
      "prices": 0,
      "lock": true,
      "lockTime": "string"
    }
  ]
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|user|[User](#schemauser)|false|none||none|
|items|[[PurchaseInfo](#schemapurchaseinfo)]¦null|false|none||none|

<h2 id="tocS_Result«List«User»»">Result«List«User»»</h2>

<a id="schemaresult«list«user»»"></a>
<a id="schema_Result«List«User»»"></a>
<a id="tocSresult«list«user»»"></a>
<a id="tocsresult«list«user»»"></a>

```json
{
  "msg": "string",
  "code": 0,
  "data": [
    {
      "id": 0,
      "name": "string",
      "gender": "string",
      "grade": "string",
      "academy": "string",
      "phone_number": "string",
      "social_info": "string",
      "avatar_img": "string",
      "back_img": "string"
    }
  ]
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|msg|string¦null|false|none||none|
|code|integer¦null|false|none||none|
|data|[[User](#schemauser)]¦null|false|none||none|

<h2 id="tocS_Result«SaTokenInfo»">Result«SaTokenInfo»</h2>

<a id="schemaresult«satokeninfo»"></a>
<a id="schema_Result«SaTokenInfo»"></a>
<a id="tocSresult«satokeninfo»"></a>
<a id="tocsresult«satokeninfo»"></a>

```json
{
  "msg": "string",
  "code": 0,
  "data": {
    "tokenName": "string",
    "tokenValue": "string",
    "isLogin": true,
    "loginId": {},
    "loginType": "string",
    "tokenTimeout": 0,
    "sessionTimeout": 0,
    "tokenSessionTimeout": 0,
    "tokenActiveTimeout": 0,
    "loginDevice": "string",
    "tag": "string"
  }
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|msg|string¦null|false|none||none|
|code|integer¦null|false|none||none|
|data|[SaTokenInfo](#schemasatokeninfo)|false|none||none|

<h2 id="tocS_Result«ItemDetail»">Result«ItemDetail»</h2>

<a id="schemaresult«itemdetail»"></a>
<a id="schema_Result«ItemDetail»"></a>
<a id="tocSresult«itemdetail»"></a>
<a id="tocsresult«itemdetail»"></a>

```json
{
  "msg": "string",
  "code": 0,
  "data": {
    "item": {
      "id": 0,
      "uid": 0,
      "name": "string",
      "description": "string",
      "prices": 0,
      "itemStatus": 0,
      "itemType": "string"
    },
    "images": [
      "string"
    ]
  }
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|msg|string¦null|false|none||none|
|code|integer¦null|false|none||none|
|data|[ItemDetail](#schemaitemdetail)|false|none||com.reusehive.entity.database.Item|

<h2 id="tocS_Result«List«PurchaseInfo»»">Result«List«PurchaseInfo»»</h2>

<a id="schemaresult«list«purchaseinfo»»"></a>
<a id="schema_Result«List«PurchaseInfo»»"></a>
<a id="tocSresult«list«purchaseinfo»»"></a>
<a id="tocsresult«list«purchaseinfo»»"></a>

```json
{
  "msg": "string",
  "code": 0,
  "data": [
    {
      "id": 0,
      "uid": 0,
      "itemId": 0,
      "itemUid": 0,
      "createTime": "string",
      "prices": 0,
      "lock": true,
      "lockTime": "string"
    }
  ]
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|msg|string¦null|false|none||none|
|code|integer¦null|false|none||none|
|data|[[PurchaseInfo](#schemapurchaseinfo)]¦null|false|none||none|

<h2 id="tocS_PurchaseInfo">PurchaseInfo</h2>

<a id="schemapurchaseinfo"></a>
<a id="schema_PurchaseInfo"></a>
<a id="tocSpurchaseinfo"></a>
<a id="tocspurchaseinfo"></a>

```json
{
  "id": 0,
  "uid": 0,
  "itemId": 0,
  "itemUid": 0,
  "createTime": "string",
  "prices": 0,
  "lock": true,
  "lockTime": "string"
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|id|integer¦null|false|none||none|
|uid|integer¦null|false|none||none|
|itemId|integer¦null|false|none||none|
|itemUid|integer¦null|false|none||none|
|createTime|string¦null|false|none||none|
|prices|number¦null|false|none||none|
|lock|boolean¦null|false|none||none|
|lockTime|string¦null|false|none||none|

<h2 id="tocS_Result«User»">Result«User»</h2>

<a id="schemaresult«user»"></a>
<a id="schema_Result«User»"></a>
<a id="tocSresult«user»"></a>
<a id="tocsresult«user»"></a>

```json
{
  "msg": "string",
  "code": 0,
  "data": {
    "id": 0,
    "name": "string",
    "gender": "string",
    "grade": "string",
    "academy": "string",
    "phone_number": "string",
    "social_info": "string",
    "avatar_img": "string",
    "back_img": "string"
  }
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|msg|string¦null|false|none||none|
|code|integer¦null|false|none||none|
|data|[User](#schemauser)|false|none||none|

<h2 id="tocS_SaTokenInfo">SaTokenInfo</h2>

<a id="schemasatokeninfo"></a>
<a id="schema_SaTokenInfo"></a>
<a id="tocSsatokeninfo"></a>
<a id="tocssatokeninfo"></a>

```json
{
  "tokenName": "string",
  "tokenValue": "string",
  "isLogin": true,
  "loginId": {},
  "loginType": "string",
  "tokenTimeout": 0,
  "sessionTimeout": 0,
  "tokenSessionTimeout": 0,
  "tokenActiveTimeout": 0,
  "loginDevice": "string",
  "tag": "string"
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|tokenName|string¦null|false|none||none|
|tokenValue|string¦null|false|none||none|
|isLogin|boolean¦null|false|none||none|
|loginId|[Object](#schemaobject)|false|none||none|
|loginType|string¦null|false|none||none|
|tokenTimeout|integer¦null|false|none||none|
|sessionTimeout|integer¦null|false|none||none|
|tokenSessionTimeout|integer¦null|false|none||none|
|tokenActiveTimeout|integer¦null|false|none||none|
|loginDevice|string¦null|false|none||none|
|tag|string¦null|false|none||none|

<h2 id="tocS_ItemDetail">ItemDetail</h2>

<a id="schemaitemdetail"></a>
<a id="schema_ItemDetail"></a>
<a id="tocSitemdetail"></a>
<a id="tocsitemdetail"></a>

```json
{
  "item": {
    "id": 0,
    "uid": 0,
    "name": "string",
    "description": "string",
    "prices": 0,
    "itemStatus": 0,
    "itemType": "string"
  },
  "images": [
    "string"
  ]
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|item|[Item](#schemaitem)|false|none||none|
|images|[string]¦null|false|none||none|

<h2 id="tocS_Result«List«Item»»">Result«List«Item»»</h2>

<a id="schemaresult«list«item»»"></a>
<a id="schema_Result«List«Item»»"></a>
<a id="tocSresult«list«item»»"></a>
<a id="tocsresult«list«item»»"></a>

```json
{
  "msg": "string",
  "code": 0,
  "data": [
    {
      "id": 0,
      "uid": 0,
      "name": "string",
      "description": "string",
      "prices": 0,
      "itemStatus": 0,
      "itemType": "string"
    }
  ]
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|msg|string¦null|false|none||none|
|code|integer¦null|false|none||none|
|data|[[Item](#schemaitem)]¦null|false|none||none|

<h2 id="tocS_User">User</h2>

<a id="schemauser"></a>
<a id="schema_User"></a>
<a id="tocSuser"></a>
<a id="tocsuser"></a>

```json
{
  "id": 0,
  "name": "string",
  "gender": "string",
  "grade": "string",
  "academy": "string",
  "phone_number": "string",
  "social_info": "string",
  "avatar_img": "string",
  "back_img": "string"
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|id|integer¦null|false|none||none|
|name|string¦null|false|none||none|
|gender|string¦null|false|none||none|
|grade|string¦null|false|none||none|
|academy|string¦null|false|none||none|
|phone_number|string¦null|false|none||none|
|social_info|string¦null|false|none||none|
|avatar_img|string¦null|false|none||none|
|back_img|string¦null|false|none||none|

<h2 id="tocS_Object">Object</h2>

<a id="schemaobject"></a>
<a id="schema_Object"></a>
<a id="tocSobject"></a>
<a id="tocsobject"></a>

```json
{}

```

### 属性

*None*

<h2 id="tocS_Result«Item»">Result«Item»</h2>

<a id="schemaresult«item»"></a>
<a id="schema_Result«Item»"></a>
<a id="tocSresult«item»"></a>
<a id="tocsresult«item»"></a>

```json
{
  "msg": "string",
  "code": 0,
  "data": {
    "id": 0,
    "uid": 0,
    "name": "string",
    "description": "string",
    "prices": 0,
    "itemStatus": 0,
    "itemType": "string"
  }
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|msg|string¦null|false|none||none|
|code|integer¦null|false|none||none|
|data|[Item](#schemaitem)|false|none||none|

<h2 id="tocS_Result«None»">Result«None»</h2>

<a id="schemaresult«none»"></a>
<a id="schema_Result«None»"></a>
<a id="tocSresult«none»"></a>
<a id="tocsresult«none»"></a>

```json
{
  "msg": "string",
  "code": 0,
  "data": {}
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|msg|string¦null|false|none||none|
|code|integer¦null|false|none||none|
|data|[None](#schemanone)|false|none||none|

<h2 id="tocS_Item">Item</h2>

<a id="schemaitem"></a>
<a id="schema_Item"></a>
<a id="tocSitem"></a>
<a id="tocsitem"></a>

```json
{
  "id": 0,
  "uid": 0,
  "name": "string",
  "description": "string",
  "prices": 0,
  "itemStatus": 0,
  "itemType": "string"
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|id|integer¦null|false|none||none|
|uid|integer¦null|false|none||none|
|name|string¦null|false|none||none|
|description|string¦null|false|none||none|
|prices|number¦null|false|none||none|
|itemStatus|integer¦null|false|none||none|
|itemType|string¦null|false|none||none|

<h2 id="tocS_Result«Long»">Result«Long»</h2>

<a id="schemaresult«long»"></a>
<a id="schema_Result«Long»"></a>
<a id="tocSresult«long»"></a>
<a id="tocsresult«long»"></a>

```json
{
  "msg": "string",
  "code": 0,
  "data": 0
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|msg|string¦null|false|none||none|
|code|integer¦null|false|none||none|
|data|integer¦null|false|none||none|

<h2 id="tocS_None">None</h2>

<a id="schemanone"></a>
<a id="schema_None"></a>
<a id="tocSnone"></a>
<a id="tocsnone"></a>

```json
{}

```
