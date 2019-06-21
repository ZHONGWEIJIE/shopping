# shopping

- [shopping](#shopping)
  - [接口声明](#接口声明)
    - [1. 用户列表](#1-用户列表)
      - [1.1 接口：获取用户列表](#11-接口获取用户列表)
      - [1.2 接口：删除用户](#11-接口删除用户)

## 接口声明

### 1. 用户列表

#### 1.1 接口：获取用户列表

url: <http://localhost/shopping/customer/userData>

params: null

```text
response - josndata:

status: 200
user: [
  {
    userId(用户id): "1000",
    email(用户邮箱): "10000@qq.com",
    gender(用户性别): "男",
    name(用户昵称): "John",
    recipient(收件人名称): "Hi",
    phone(用户电话): "1234567",
    age(用户年龄): "31",
    address(用户收获地址):
      "My name is John Brown, I am 32 years old, living in New York No. 1 Lake Park."
  },
  {
    ...
  },
  ...
]
```

#### 1.2 接口：删除用户

url: <http://localhost/shopping/customer/deletaUser?userId=xxx>

params: { userId: xxx }

```text
response - josndata:
  status: ture || 1
  statusTxt: "删除成功!"
  or
  status: flase || 0
  status: "删除失败!"
```

