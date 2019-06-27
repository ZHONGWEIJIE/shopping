# Shopping 项目

- [Shopping 项目](#shopping-项目)
  - [接口声明约定](#接口声明约定)
    - [HTTP 请求](#http-请求)
    - [接口参数](#接口参数)
    - [未约定](#未约定)
  - [接口用例](#接口用例)
    - [用户管理](#用户管理)
    - [商品管理](#商品管理)
    - [订单管理](#订单管理)
    - [留言管理](#留言管理)

## 接口声明约定

### HTTP 请求

- `GET`：获取数据
- `POST`：增加 / 修改数据
- `DELETE`：删除数据

示例：`GET /user` 获取用户，`POST /product`：新增 / 修改商品，`DELETE /user`：删除用户

### 接口参数

| 字段名       | 字段说明                                                     |
| ------------ | ------------------------------------------------------------ |
| `data`       | **业务数据**建议始终返回一个 `Object` JSON 数据类型，以便于扩展字段。例如：用户数据应该返回 `{ "user": { "name": "test" }}`，而不是直接返回 `{ "name": "test"}`。 |
|`url`|**业务方法**由后端完成相应接口方法后，在此处填上相应接口 `url`。|
| `status`     | **状态码**必须是 `>= 0` 的 `Number` JSON 整数。`200` 表示请求处理成功，此时可忽略 `status` 字段；非 `200` 表示发生错误时的错误码，此时可以省略 `data` 字段，并视情况输出 `statusInfo` 字段作为补充信息。 |
| `statusInfo` | **状态信息**建议始终返回一个 `Object` JSON 数据类型，包含 `message` 和 `detail` 字段。`message` 字段作为接口处理失败时，**给予用户的友好的提示信息**，即所有给用户的提示信息都统一由后端来处理。`detail` 字段用来放置接口处理失败时的详细错误信息，只是为了方便排查错误，前端无需使用。 |

### 未约定

分页参数和分页信息

- 限制只返回 N 条数据（`limit` 参数）
- 控制每页的数据条数（`pageSize` 参数）
- 加载某一页的数据（`page` 参数）
  - 第一页是从 `0` 开始还是从 `1` 开始
- 分页信息包含什么 (`total`, `page`, `pageSize`)
- 分页信息何时表明已经是最后一页：
  - 请求某页数据时返回的数据条数 < `pageSize`
  - 请求某页数据时返回的数据条数 = `0`
  - 如果碰巧最后一页有 `pageSize` 条数据，前端无法通过数据条数来判断已经处于最后一页

---

## 接口用例

> 以下 `data` 中的 JSON 数据字段是前端必须显示内容，不可缺省，后端可以返回在此基础上多的关联字段。

### 用户管理

| case|获取用户列表|
| ----------- | ----- |
| HTTP method | `GET /userList` |
| data        | { userList: { 用户id, 用户Email, 用户昵称, 性别, 年龄, 收件人, 联系电话, 收货地址 }`*` } |
| url         |       |
| status/statusInfo |       |

| case              | 获取用户信息                                |
| ----------------- | ------------------------------------------- |
| HTTP method       | `GET /userInfo`                             |
| data              | { userInfo: { *与用户自身相关的表字段*  } } |
| url               |                                             |
| status/statusInfo |                                             |

| case              | 删除用户              |
| ----------------- | --------------------- |
| HTTP method       | `DELETE /user?userId` |
| data              | 无                    |
| url               |                       |
| status/statusInfo |                       |

| case              | 查询用户                                                     |
| ----------------- | ------------------------------------------------------------ |
| HTTP method       | `GET /user?keyWord`                                          |
| data              | { userList: { 用户id, 用户Email, 用户昵称, 性别, 年龄, 收件人, 联系电话, 收货地址 }`*` } |
| url               |                                                              |
| status/statusInfo |                                                              |

| case              | 更改用户信息          |
| ----------------- | --------------------- |
| HTTP method       | `POST /user?userInfo` |
| data              | 无                    |
| url               |                       |
| status/statusInfo |                       |

| case              | 更改用户密码          |
| ----------------- | --------------------- |
| HTTP method       | `POST /user?password` |
| data              | 无                    |
| url               |                       |
| status/statusInfo |                       |

---

### 商品管理

| case              | 获取商品类目列表                                        |
| ----------------- | ------------------------------------------------------ |
| HTTP method       | `GET /productCategories`                               |
| data              | { productCategories: { 商品类目id, 商品类目名称 }`*` }   |
| url               |                                                        |
| status/statusInfo |                                                        |

| case              | 获取商品列表                                                 |
| ----------------- | ------------------------------------------------------------ |
| HTTP method       | `GET /productList`                                           |
| data              | { productList: { 商品id, 商品类目id, 商品标题, 商品描述, 商品图片 }`*` } |
| url               |                                                              |
| status/statusInfo |                                                              |

| case              | 获取商品信息                                   |
| ----------------- | ---------------------------------------------- |
| HTTP method       | `GET /productInfo`                             |
| data              | { productInfo: { 与商品自身相关的表字段 }`*` } |
| url               |                                                |
| status/statusInfo |                                                |

| case              | 新增 / 更新商品信息         |
| ----------------- | --------------------------- |
| HTTP method       | `POST /product?productInfo` |
| data              | 无                          |
| url               |                             |
| status/statusInfo |                             |

| case              | 删除商品信息                    |
| ----------------- | ------------------------------- |
| HTTP method       | `DELETE /productInfo?productId` |
| data              | 无                              |
| url               |                                 |
| status/statusInfo |                                 |

---

### 订单管理

| case              | 获取订单列表                                                 |
| ----------------- | ------------------------------------------------------------ |
| HTTP method       | `GET /getOrderList/{status}`                                             |
| data              | { orderList: { 订单id, 用户昵称, 收件人, 联系电话, 商品名称, 商品数量, 订单金额, 订单状态id, 订单状态标签, 更新时间, 收货地址 }`*` } |
| url               |  /Order/getOrderList/{status}                                                            |
| status/statusInfo |                                                              |

| case              | 更新订单信息                                                 |
| ----------------- | ------------------------------------------------------------ |
| HTTP method       | `POST /orderInfo?orderId`                                    |
| data              | { orderInfo: { 订单id, 商品名称, 商品单价, 订单金额,  订单状态id, 商品数量} } |
| url               |  /updateOrder                                               |
| status/statusInfo |                                                              |

| case              | 删除订单信息                |
| ----------------- | --------------------------- |
| HTTP method       | `DELETE /orderInfo?orderId` |
| data              | 无                          |
| url               | /deleteOrder                |
| status/statusInfo |                             |

---

### 留言管理
| case              | 根据用户id获取所有留言        |
| ----------------- | --------------------------- |
| HTTP method       | `GET`                       |
| data              | 无                          |
| url               | /GuestBook/getAll/{adminId} |
| urlParam          | adminId                     |
| status/statusInfo |                             |

| case              | 根据用户id获取已回复以及未回复内容    |
| ----------------- | --------------------------- |
| HTTP method       | `GET`                       |
| data              | 无                          |
| url               | /GuestBook/reply/{determine}|
| urlParam          | determine (true 或 false)   |
| param             | adminId                     |
| status/statusInfo |                             |


| case              | 回复客户                     |
| ----------------- | --------------------------- |
| HTTP method       | `GET` |
| data              | 无                          |
| url               | /GuestBook/reply/content    |
| param             | String id （客户与商家问答的唯一id）,String content（回复内容）    |
| status/statusInfo |                             |
