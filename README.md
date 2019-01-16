[登录相关接口](#登录相关接口)

[&emsp;&emsp;1.登录](#1-登录)

[&emsp;&emsp;2.登出](#2-登出)

[&emsp;&emsp;3.权限校验返回数据结构](#3-权限校验返回数据结构)

[&emsp;&emsp;4.其它返回数据结构](#4-其它返回数据结构)

[&emsp;&emsp;5.获取验证码](#5-获取验证码)

[&emsp;&emsp;6.获取用户登录状态以及角色](#6-获取用户登录状态以及角色)


[ivr相关接口](#ivr相关接口)

[&emsp;&emsp;1. 新增ivr配置](#1-新增ivr配置)

[&emsp;&emsp;2. 删除ivr配置](#2-删除ivr配置)

[&emsp;&emsp;3. 编辑ivr配置](#3-编辑ivr配置)

[&emsp;&emsp;4.ivr列表](#4-ivr列表)

[&emsp;&emsp;5.根据id查询ivr](#5-根据id查询ivr)

[ivrNode相关接口](#ivrNode相关接口)

[&emsp;&emsp;1. 新增ivrNode](#1-新增ivrNode)

[&emsp;&emsp;2. 删除ivrNode](#2-删除ivrNode)

[&emsp;&emsp;3.编辑ivrNode](#3-编辑ivrNode)

[&emsp;&emsp;4. 查找某个ivr下所有的ivrNode](#4-查找某个ivr下所有的ivrNode)

[&emsp;&emsp;5. 根据id查找ivrNode](#5-根据id查找ivrNode)

[&emsp;&emsp;6. 根据endpoint查找ivrNode](#6-根据endpoint查找ivrNode)

[&emsp;&emsp;6. 根据endpoint查找ivrNode](#6-根据endpoint查找ivrNode)










### 登录相关接口
#### 1. 登录
* URL:/api/system/login
* Method:POST
* Content type: application/json
* 输入参数：

| 参数名       | 是否必填 | 数据类型 | 说明             |
| ------------ | -------- | -------- | ---------------- |
| userName     | 是       | String   | 用户名           |
| password     | 是       | String   | 密码             |
| securityCode | 是       | String   | 用户输入的验证码 |

* 返回结果：

| 字段        | 数据类型 | 说明                                                 |
| ----------- | -------- | ---------------------------------------------------- |
| status      | int      | 0成功，-1失败                                        |
| description | String   | 状态说明，例如登录成功、用户名或密码错误、验证码错误 |
| data        | Object   | 保存了用户信息的对象                                 |

* 示例

```
{
    "currentPageNo": 0,
    "data": {
        "password": "",
        "role": "admin",
        "createTime": 1546938079162,
        "roleId": 1,
        "id": 1,
        "username": "admin"
    },
    "pageSize": 0,
    "status": 0,
    "totalCount": 0
}
```

```
{
    "currentPageNo": 0,
    "description": "验证码输入错误",
    "pageSize": 0,
    "status": -1,
    "totalCount": 0
}
```





#### 2. 登出

- URL:/api/system/logout
- Method:GET
- Content type: application/json
- 输入参数：无
- 返回结果：

| 字段        | 数据类型 | 说明                   |
| ----------- | -------- | ---------------------- |
| status      | int      | 0成功，-1失败          |
| description | String   | 状态说明，例如登出成功 |

* 示例

```
{
    "currentPageNo": 0,
    "description": "登出成功",
    "pageSize": 0,
    "status": 0,
    "totalCount": 0
}
```



#### 3. 权限校验返回数据结构

```
{
    "currentPageNo": 0,
    "description": "未授权",
    "pageSize": 0,
    "status": 403,
    "totalCount": 0
}
```

#### 4. 其它返回数据结构

```
{
    "currentPageNo": 0,
    "description": "未登录",
    "pageSize": 0,
    "status": 401,
    "totalCount": 0
}
```

```
{
    "currentPageNo": 0,
    "description": "您已经登录,请先登出",
    "pageSize": 0,
    "status": 200,
    "totalCount": 0
}
```



#### 5. 获取验证码

* URL:/api/login/securitycode
* Method:GET 
* 输入参数：无
* 返回结果：验证码图片

#### 6. 获取用户登录状态以及角色

- URL:/api/userStatus

- Method:GET 

- 返回结果：

  ```
  {
      "currentPageNo": 0,
      "data": {
          "login_status": "已登录",
          "password": "",
          "role": "admin",
          "createTime": 1546938079162,
          "roleId": 1,
          "id": 1,
          "username": "admin"
      },
      "pageSize": 0,
      "status": 0,
      "totalCount": 0
  }
  ```





### ivr相关接口

#### 1. 新增ivr配置

- URL:/api/ivr
- Method:POST
- Content type: application/json
- 输入参数：

| 参数名       | 是否必填 | 数据类型 | 说明                                   |
| ------------ | -------- | -------- | -------------------------------------- |
| name         | 是       | String   | ivr配置name                            |
| description  | 是       | String   | 描述                                   |
| statistic    | 否       | String   | 开启节点统计，默认关闭0：关闭，1：开启 |
| enterpriseId | 是       | String   | 企业id                                 |

- 返回结果：

| 字段        | 数据类型 | 说明               |
| ----------- | -------- | ------------------ |
| status      | int      | 0成功，-1失败      |
| description | String   | 状态说明，例如成功 |
| data        | object   | 结果对象           |

&emsp;&emsp;返回示例

```
{
    "status": 0,
    "description": "成功",
    "data": {
        "id": 25,
        "enterpriseId": 5200002,
        "name": "test",
        "description": "测试",
        "statistic": 0,
        "createTime": "2019-01-04T02:54:01.847+0000",
        "updateTime": "2019-01-04T02:54:01.847+0000",
        "flow": null
    },
    "currentPageNo": 0,
    "pageSize": 0,
    "totalCount": 0
}
```

- 返回对象描述

| 字段         | 类型     | 描述                                 |
| ------------ | -------- | ------------------------------------ |
| id           | int      | 语音导航id                           |
| enterpriseId | int      | 企业id                               |
| name         | String   | 语音导航名称                         |
| description  | String   | 语音导航描述                         |
| statistic    | String   | 节点统计，默认关闭，0：关闭，1：开启 |
| createTime   | String   | 记录创建时间                         |
| updateTime   | String   | 记录更新时间                         |
| flow         | object[] | 语音导航流程                         |

#### 2. 删除ivr配置

- URL:/ivr/{id}
- Method:delete
- Content type: application/json
- 输入参数：

| 参数名       | 是否必填 | 数据类型 | 说明   |
| ------------ | -------- | -------- | ------ |
| enterpriseId | 是       | String   | 企业id |

- 返回结果：

| 字段        | 数据类型 | 说明               |
| ----------- | -------- | ------------------ |
| status      | int      | 0成功，-1失败      |
| description | String   | 状态说明，例如成功 |
| data        | object   | 结果对象           |

```
{
    "status": 0,
    "description": "成功",
    "data": null,
    "currentPageNo": 0,
    "pageSize": 0,
    "totalCount": 0
}
```

#### 3. 编辑ivr配置

- URL:/ivr/{id}
- Method:put
- Content type: application/json
- 输入参数：

| 参数名       | 是否必填 | 数据类型 | 说明                                   |
| ------------ | -------- | -------- | -------------------------------------- |
| id           | 是       | int      | 语音导航id                             |
| enterpriseId | 是       | int      | 企业id                                 |
| name         | 否       | String   | 语音导航name                           |
| description  | 否       | String   | 语音导航描述                           |
| statistic    | 否       | String   | 开启节点统计，默认关闭0：关闭，1：开启 |
| flow         | 否       | object[] | 语音导航流程                           |

- 返回结果：

| 字段        | 数据类型 | 说明               |
| ----------- | -------- | ------------------ |
| status      | int      | 0成功，-1失败      |
| description | String   | 状态说明，例如成功 |
| data        | object   | 结果对象           |

```
{
    "status": 0,
    "description": "成功",
    "data": {
        "id": 18,
        "enterpriseId": 5200002,
        "name": null,
        "description": null,
        "statistic": null,
        "createTime": null,
        "updateTime": "2019-01-04T03:06:18.077+0000",
        "flow": "[...]"
    },
    "currentPageNo": 0,
    "pageSize": 0,
    "totalCount": 0
}

```

- 返回对象描述

| 字段         | 类型     | 描述                                 |
| ------------ | -------- | ------------------------------------ |
| id           | int      | 语音导航id                           |
| enterpriseId | int      | 企业id                               |
| name         | String   | 语音导航名称                         |
| description  | String   | 语音导航描述                         |
| statistic    | String   | 节点统计，默认关闭，0：关闭，1：开启 |
| createTime   | String   | 记录创建时间                         |
| updateTime   | String   | 记录更新时间                         |
| flow         | object[] | 语音导航流程                         |

#### 4.ivr列表

- URL:/ivr
- Method:GET
- Content type: application/json
- 输入参数：

| 参数名        | 是否必填 | 数据类型 | 说明                   |
| ------------- | -------- | -------- | ---------------------- |
| enterpriseId  | 是       | String   | 企业id                 |
| currentPageNo | 否       | int      | 页码，默认第一页       |
| pageSize      | 否       | int      | 每页数据条数，默认20条 |

- 返回结果：

| 字段        | 数据类型 | 说明               |
| ----------- | -------- | ------------------ |
| status      | int      | 0成功，-1失败      |
| description | String   | 状态说明，例如成功 |
| data        | object   | 结果对象           |

&emsp;&emsp;返回示例

```
{
    "status": 0,
    "description": "成功",
    "data": [
        {
            "id": 18,
            "enterpriseId": 5200002,
            "name": "duym",
            "description": "测试",
            "statistic": 0,
            "createTime": "2019-01-03T07:09:15.308+0000",
            "updateTime": "2019-01-04T03:06:18.077+0000",
            "flow": "[]"
	},
        {
            "id": 23,
            "enterpriseId": 5200002,
            "name": "测试",
            "description": "测试",
            "statistic": 0,
            "createTime": "2019-01-03T07:13:08.031+0000",
            "updateTime": "2019-01-03T07:13:08.031+0000",
            "flow": null
        },
        {
            "id": 24,
            "enterpriseId": 5200002,
            "name": "测试root",
            "description": "测试",
            "statistic": 0,
            "createTime": "2019-01-03T10:25:20.837+0000",
            "updateTime": "2019-01-03T10:25:20.837+0000",
            "flow": null
        }
    ],
    "currentPageNo": 1,
    "pageSize": 20,
    "totalCount": 5
}
```

| 字段         | 类型     | 描述                                 |
| ------------ | -------- | ------------------------------------ |
| id           | int      | 语音导航id                           |
| enterpriseId | int      | 企业id                               |
| name         | String   | 语音导航名称                         |
| description  | String   | 语音导航描述                         |
| statistic    | String   | 节点统计，默认关闭，0：关闭，1：开启 |
| createTime   | String   | 记录创建时间                         |
| updateTime   | String   | 记录更新时间                         |
| flow         | object[] | 语音导航流程                         |

#### 5.根据id查询ivr

- URL:/ivr/{id}
- Method:GET
- Content type: application/json
- 输入参数：

| 参数名       | 是否必填 | 数据类型 | 说明   |
| ------------ | -------- | -------- | ------ |
| enterpriseId | 是       | String   | 企业id |

- 返回结果：

| 字段        | 数据类型 | 说明               |
| ----------- | -------- | ------------------ |
| status      | int      | 0成功，-1失败      |
| description | String   | 状态说明，例如成功 |
| data        | object   | 结果对象           |

&emsp;&emsp;返回示例

```
{
    "status": 0,
    "description": "成功",
    "data": {
        "id": 23,
        "name": "测试",
        "description": "测试",
        "createTime": "2019-01-03T07:13:08.031+0000",
        "updateTime": "2019-01-03T07:13:08.031+0000",
        "statistic": 0
    },
    "currentPageNo": 0,
    "pageSize": 0,
    "totalCount": 0
}
```

| 字段         | 类型     | 描述                                 |
| ------------ | -------- | ------------------------------------ |
| id           | int      | 语音导航id                           |
| enterpriseId | int      | 企业id                               |
| name         | String   | 语音导航名称                         |
| description  | String   | 语音导航描述                         |
| statistic    | String   | 节点统计，默认关闭，0：关闭，1：开启 |
| createTime   | String   | 记录创建时间                         |
| updateTime   | String   | 记录更新时间                         |
| flow         | object[] | 语音导航流程                         |



### ivrNode相关接口

#### 1. 新增ivrNode

- URL:/api/ivrNode
- Method:POST
- Content type: application/json
- 输入参数：

| 参数名         | 是否必填 | 数据类型 | 说明                                                         |
| -------------- | -------- | -------- | ------------------------------------------------------------ |
| ivrId          | 是       | String   | 语音导航id                                                   |
| enterpriseId   | 是       | String   | 企业id                                                       |
| endpoint       | 是       | String   | 节点端点                                                     |
| name           | 是       | String   | 节点名称                                                     |
| frequentlyPath | 否       | String   | 常用节点                                                     |
| statistic      | 是       | int      | 节点统计，默认关闭 0：关闭、1：开启                          |
| type           | 是       | String   | 语音导航节点类型 8:变量 11：判断 12:交互 13:直呼 16:分支     |
| property       | 是       | String   | 语音导航节点内容：详见：语音导航节点action类型与property字段详细 |

- 返回结果：

| 字段        | 数据类型 | 说明               |
| ----------- | -------- | ------------------ |
| status      | int      | 0成功，-1失败      |
| description | String   | 状态说明，例如成功 |
| data        | object   | 结果对象           |

&emsp;&emsp;返回示例

```
{
    "status": 0,
    "description": "成功",
    "data": {
        "enterpriseId": 5200002,
        "id": 8,
        "ivrId": 18,
        "endpoint": "M8nF8FN4J1",
        "name": "设置变量",
        "frequentlyPath": "",
        "type": 8,
        "property": {
            "set": [
                {
                    "name": "名字",
                    "value": "duym",
                    "valueType": 1,
                    "comment": "名字"
                },
                {
                    "name": "age",
                    "value": "18",
                    "valueType": 0,
                    "comment": "年龄"
                }
            ]
        },
        "statistic": 0
    },
    "currentPageNo": 0,
    "pageSize": 0,
    "totalCount": 0
}
```

- 返回对象描述

| 字段           | 类型   | 描述                                                         |
| -------------- | ------ | ------------------------------------------------------------ |
| id             | int    | ivrNode id                                                   |
| ivrId          | int    | 语音导航id                                                   |
| endpoint       | String | 节点端点                                                     |
| name           | String | 节点名称                                                     |
| frequentlyPath | String | 常用节点                                                     |
| statistic      | int    | 节点统计，默认关闭 0：关闭、1：开启                          |
| type           | String | 语音导航节点类型 8:变量 11：判断 12:交互 13:直呼 16:分支     |
| property       | String | 语音导航节点内容：详见：语音导航节点action类型与property字段详细 |

#### 2. 删除ivrNode

- URL:/ivrNode/{id}
- Method:delete
- Content type: application/json
- 输入参数：

| 参数名       | 是否必填 | 数据类型 | 说明   |
| ------------ | -------- | -------- | ------ |
| enterpriseId | 是       | String   | 企业id |

- 返回结果：

| 字段        | 数据类型 | 说明               |
| ----------- | -------- | ------------------ |
| status      | int      | 0成功，-1失败      |
| description | String   | 状态说明，例如成功 |

```
{
    "status": 0,
    "description": "成功",
    "data": null,
    "currentPageNo": 0,
    "pageSize": 0,
    "totalCount": 0
}
```

#### 3.编辑ivrNode

- URL:/ivrNode/{id}
- Method:PUT
- Content type: application/json
- 输入参数：

| 参数名         | 是否必填 | 数据类型 | 说明                                                         |
| -------------- | -------- | -------- | ------------------------------------------------------------ |
| ivrId          | 是       | String   | 语音导航id                                                   |
| enterpriseId   | 是       | String   | 企业id                                                       |
| endpoint       | 否       | String   | 节点端点                                                     |
| name           | 否       | String   | 节点名称                                                     |
| frequentlyPath | 否       | String   | 常用节点                                                     |
| statistic      | 否       | int      | 节点统计，默认关闭 0：关闭、1：开启                          |
| type           | 否       | String   | 语音导航节点类型 8:变量 11：判断 12:交互 13:直呼 16:分支     |
| property       | 否       | String   | 语音导航节点内容：详见：语音导航节点action类型与property字段详细 |

- 返回结果：

| 字段        | 数据类型 | 说明               |
| ----------- | -------- | ------------------ |
| status      | int      | 0成功，-1失败      |
| description | String   | 状态说明，例如成功 |
| data        | object   | 结果对象           |

&emsp;&emsp;返回示例

```
{
    "status": 0,
    "description": "成功",
    "data": {
        "enterpriseId": 5200002,
        "id": 8,
        "ivrId": 18,
        "endpoint": "M8nF8FN4J1",
        "name": "设置变量",
        "frequentlyPath": "",
        "type": 8,
        "property": {
            "set": [
                {
                    "name": "名字",
                    "value": "duym",
                    "valueType": 1,
                    "comment": "名字"
                },
                {
                    "name": "age",
                    "value": "18",
                    "valueType": 0,
                    "comment": "年龄"
                }
            ]
        },
        "statistic": 0
    },
    "currentPageNo": 0,
    "pageSize": 0,
    "totalCount": 0
}
```

- 返回对象描述

| 字段           | 类型   | 描述                                                         |
| -------------- | ------ | ------------------------------------------------------------ |
| id             | int    | ivrNode id                                                   |
| ivrId          | int    | 语音导航id                                                   |
| endpoint       | String | 节点端点                                                     |
| name           | String | 节点名称                                                     |
| frequentlyPath | String | 常用节点                                                     |
| statistic      | int    | 节点统计，默认关闭 0：关闭、1：开启                          |
| type           | String | 语音导航节点类型 8:变量 11：判断 12:交互 13:直呼 16:分支     |
| property       | String | 语音导航节点内容：详见：语音导航节点action类型与property字段详细 |

#### 4. 查找某个ivr下所有的ivrNode

- URL:/ivrNode/ivrId/{ivrId}
- Method:get
- Content type: application/json
- 输入参数：

| 参数名       | 是否必填 | 数据类型 | 说明   |
| ------------ | -------- | -------- | ------ |
| enterpriseId | 是       | String   | 企业id |

- 返回结果：

| 字段        | 数据类型 | 说明               |
| ----------- | -------- | ------------------ |
| status      | int      | 0成功，-1失败      |
| description | String   | 状态说明，例如成功 |
| data        | object   | 结果对象           |

&emsp;&emsp;返回示例

```
{
    "status": 0,
    "description": "成功",
    "data": [
        {
            "id": 11,
            "ivrId": 18,
            "enterpriseId": 5200002,
            "endpoint": "1",
            "name": null,
            "frequentlyPath": null,
            "type": 0,
            "property": "{\"rootNext\":\"M8nF8FN4J\"}",
            "statistic": 0,
            "createTime": "2019-01-03T09:05:26.092+0000",
            "updateTime": "2019-01-03T09:05:26.092+0000"
        },
        {
            "id": 15,
            "ivrId": 18,
            "enterpriseId": 5200002,
            "endpoint": "acLD9iAOK",
            "name": "判断节点",
            "frequentlyPath": "",
            "type": 11,
            "property": "{\"branchExpression\":[{\"name\":\"age\",\"operator\":\"=\",\"value\":\"1\",\"relation\":null},{\"name\":\"name\",\"operator\":\"!=\",\"value\":\"2\",\"relation\":1},{\"name\":\"address\",\"operator\":\"=\",\"value\":\"地址\",\"relation\":2}],\"branchTrueNext\":\"\",\"branchFalseNext\":\"\"}",
            "statistic": 0,
            "createTime": "2019-01-03T10:46:23.238+0000",
            "updateTime": "2019-01-03T10:46:23.238+0000"
        },
        {
            "id": 16,
            "ivrId": 18,
            "enterpriseId": 5200002,
            "endpoint": "LTuput8WE",
            "name": "直呼节点",
            "frequentlyPath": "",
            "type": 13,
            "property": "{}"
            "statistic": 0,
            "createTime": "2019-01-03T10:57:48.448+0000",
            "updateTime": "2019-01-03T10:57:48.448+0000"
        }
    ],
    "currentPageNo": 0,
    "pageSize": 0,
    "totalCount": 0
}
```

- 返回对象描述

| 字段           | 类型   | 描述                                                         |
| -------------- | ------ | ------------------------------------------------------------ |
| id             | int    | ivrNode id                                                   |
| ivrId          | int    | 语音导航id                                                   |
| endpoint       | String | 节点端点                                                     |
| name           | String | 节点名称                                                     |
| frequentlyPath | String | 常用节点                                                     |
| statistic      | int    | 节点统计，默认关闭 0：关闭、1：开启                          |
| type           | String | 语音导航节点类型 8:变量 11：判断 12:交互 13:直呼 16:分支     |
| property       | String | 语音导航节点内容：详见：语音导航节点action类型与property字段详细 |

#### 5. 根据id查找ivrNode

- URL:/ivrNode/{id}
- Method:get
- Content type: application/json
- 输入参数：

| 参数名       | 是否必填 | 数据类型 | 说明   |
| ------------ | -------- | -------- | ------ |
| enterpriseId | 是       | String   | 企业id |

- 返回结果：

| 字段        | 数据类型 | 说明               |
| ----------- | -------- | ------------------ |
| status      | int      | 0成功，-1失败      |
| description | String   | 状态说明，例如成功 |
| data        | object   | 结果对象           |

&emsp;&emsp;返回示例

```
{
    "status": 0,
    "description": "成功",
    "data": {
        "enterpriseId": 5200002,
        "id": 18,
        "ivrId": 18,
        "endpoint": "M8nF8FN4J2",
        "name": "设置变量",
        "frequentlyPath": "",
        "type": 8,
        "property": {
            "set": [
                {
                    "name": "名字",
                    "value": "duym",
                    "valueType": 1,
                    "comment": "名字"
                },
                {
                    "name": "age",
                    "value": "18",
                    "valueType": 0,
                    "comment": "年龄"
                }
            ]
        },
        "statistic": 0
    },
    "currentPageNo": 0,
    "pageSize": 0,
    "totalCount": 0
}
```

- 返回对象描述

| 字段           | 类型   | 描述                                                         |
| -------------- | ------ | ------------------------------------------------------------ |
| id             | int    | ivrNode id                                                   |
| ivrId          | int    | 语音导航id                                                   |
| endpoint       | String | 节点端点                                                     |
| name           | String | 节点名称                                                     |
| frequentlyPath | String | 常用节点                                                     |
| statistic      | int    | 节点统计，默认关闭 0：关闭、1：开启                          |
| type           | String | 语音导航节点类型 8:变量 11：判断 12:交互 13:直呼 16:分支     |
| property       | String | 语音导航节点内容：详见：语音导航节点action类型与property字段详细 |

#### 6. 根据endpoint查找ivrNode

- URL:/ivrNode/endpoint
- Method:get
- Content type: application/json
- 输入参数：

| 参数名       | 是否必填 | 数据类型 | 说明       |
| ------------ | -------- | -------- | ---------- |
| enterpriseId | 是       | String   | 企业id     |
| ivrId        | 是       | ivrId    | 语音导航id |
| endpoint     | 是       | String   | 节点       |

- 返回结果：

| 字段        | 数据类型 | 说明               |
| ----------- | -------- | ------------------ |
| status      | int      | 0成功，-1失败      |
| description | String   | 状态说明，例如成功 |
| data        | object   | 结果对象           |

&emsp;&emsp;返回示例

```
{
    "status": 0,
    "description": "成功",
    "data": {
        "enterpriseId": 5200002,
        "id": 12,
        "ivrId": 18,
        "endpoint": "PAajx25Ue",
        "name": "分支节点",
        "frequentlyPath": "",
        "type": 16,
        "property": {
            "switchName": "分支",
            "value": [
                {
                    "value": "1",
                    "next": "bT4-3uoWv"
                },
                {
                    "value": "2",
                    "next": "LTuput8WE"
                }
            ]
        },
        "statistic": 0
    },
    "currentPageNo": 0,
    "pageSize": 0,
    "totalCount": 0
}
```

- 返回对象描述

| 字段           | 类型   | 描述                                                         |
| -------------- | ------ | ------------------------------------------------------------ |
| id             | int    | ivrNode id                                                   |
| ivrId          | int    | 语音导航id                                                   |
| endpoint       | String | 节点端点                                                     |
| name           | String | 节点名称                                                     |
| frequentlyPath | String | 常用节点                                                     |
| statistic      | int    | 节点统计，默认关闭 0：关闭、1：开启                          |
| type           | String | 语音导航节点类型 8:变量 11：判断 12:交互 13:直呼 16:分支     |
| property       | String | 语音导航节点内容：详见：语音导航节点action类型与property字段详细 |



### 语音导航节点type类型与property字段详细

#### 播放节点（8）

| 参数名 | 是否必填 | 数据类型 | 说明                                                         |
| ------ | -------- | -------- | ------------------------------------------------------------ |
| set    | 是       | object[] | 变量数组  name(变量名)、value(变量值)、valueType(变量值类型，0：表达式、1：字符串)、comment(备注) |
| next   | 否       | string   | 跳转节点，默认为空串                                         |

#### 判断节点（11）

| 参数名           | 是否必填 | 数据类型 | 说明                                                         |
| ---------------- | -------- | -------- | ------------------------------------------------------------ |
| branchExpression | 是       | object[] | 变量数组  name(变量名)、operator(操作符，包含：=，!=，<，≤，>，≥，regex)、value(变量值)、relation(逻辑运算关系，1：且、2：或) |
| branchTrueNext   | 否       | string   | 判断为true跳转节点，默认为空串                               |
| branchFalseNext  | 否       | string   | 判断为false跳转节点，默认为空串                              |

#### 交互节点（12）

| 参数名          | 是否必填 | 数据类型 | 说明                                                         |
| --------------- | -------- | -------- | ------------------------------------------------------------ |
| curlUrl         | 是       | object[] | 访问url，不允许包含问号                                      |
| curlParam       | 是       | string   | url参数                                                      |
| curlNext        | 否       | string   | 成功访问跳转节点，默认为空串，                               |
| curlErrorNext   | 否       | string   | 访问失败跳转节点，，默认为空串，                             |
| curlTag         | 是       | string   | 客户标识                                                     |
| curlTimeout     | 是       | string   | 超时时间                                                     |
| curlRetry       | 否       | string   | 重试次数                                                     |
| curlSync        | 是       | string   | 调用方式，默认同步调用，1：同步调用 0：异步调用              |
| curlMethod      | 是       | string   | 请求方式，默认GET，GET：GET方式、POST：POST方式              |
| curlContentType | 否       | string   | 当请求方式为GET时隐藏、为POST时显示。1:multipart/form-data 2:application/x-www-form-urlencoded 3：application/json 默认1 |

#### 直呼节点（13）

| 参数名               | 是否必填 | 数据类型 | 说明                                                         |
| -------------------- | -------- | -------- | ------------------------------------------------------------ |
| dialVoice            | 是       | object[] | 播放内容 type(播放类型播放类型  1:语音 2:数字 4:TTS 5:语音变量 6:数字变量 8:TTS变量 9:HTTP语音 10:HTTP语音变量 )、file(媒体文件)、library(当播放类型为1、5时传递，0:企业1:公共) |
| dialType             | 是       | int      | 直拨类型 1:固话或手机 2:座席号 3:CRM ID 4: 分机号5:队列号 6:电话组号 |
| dialTel              | 是       | string   | 直拨值                                                       |
| dialFailNext         | 否       | string   | 溢出节点                                                     |
| dialMohFile          | 是       | object   | 等待语音 file(媒体文件，默认为空串)、library(0:企业1:公共)   |
| dialCalleeVoiceType  | 是       | int      | 座席侧播放语音类型，传值为：1                                |
| dialCalleeVoiceFile  | 否       | object   | 座席侧播放语音file(媒体文件，默认为空串)、library(0:企业1:公共) |
| dialTimeout          | 是       | int      | 超时时间                                                     |
| dialMaxTalkTime      | 是       | int      | 最长通话时间                                                 |
| dialPreRemindTime    | 否       | int      | 提前提醒时间                                                 |
| dialRemindVoiceType  | 是       | int      | 提醒语音类型，传值为：1                                      |
| dialRemindVoiceFile  | 是       | object   | 提醒语音file(媒体文件，默认为空串)、library(0:企业1:公共)    |
| dialCallSequence     | 是       | int      | 呼叫策略，默认顺序，1：顺序、2：随机                         |
| dialCallerHangupNext | 否       | string   | 呼叫方挂断跳转节点                                           |
| dialCalleeHangupNext | 否       | string   | 接听方挂断跳转节点                                           |

#### 分支节点（16）

| 参数名          | 是否必填 | 数据类型 | 说明                                     |
| --------------- | -------- | -------- | ---------------------------------------- |
| switchName      | 是       | string   | 变量名                                   |
| value           | 否       | object[] | 变量值数组 value(变量值)、next(跳转节点) |
| switchOtherNext | 否       | string   | 其他值跳转节点，默认为空串               |

#### 说明
1、新增ivr时后台默认添加root（0）节点作为根节点，也就是页面上的开始节点 root节点只有一个rootNext属性









