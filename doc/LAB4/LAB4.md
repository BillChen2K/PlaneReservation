1. 需求变更说明

    a) 允许票价随时间和人数的多少进行变动。
    b) 允许票价在特定时间段打折，支持多种折扣方式。
    
    在这部分中，实现多种折扣方式，我们采用了 Strategy策略模式

    c) 支持一键抢票。
    d) 当不同航空公司票价打折时，将通知关注的人。
    e) 不同航空公司在特定时间点发布航班信息。
    f) 进度跟踪。
    g) 订单的历史纪录显示。

2. 需求变更后发生更改的交互图

3. 需求变更后类图也发生了相应的修改，修改后的类图如下所示：

![class diagram](to be done)

4. 需求变更后，为了配合代码实现，数据库也进行了修改，修改后的 ER 图如下所示：
   a) 进行的修改主要是增加了 favourite 表和 payment 里的 discount_strategy

![ER](./ER_database.jpg)


六、项目效果展示

具体详细的效果展示，可以详见附件录制的视频。这里摘取部分运行截图如下：

登录界面

![UI login](https://billc.oss-cn-shanghai.aliyuncs.com/img/2020-12-26-Fjtiwm.png)

创建订单界面

![img](https://billc.oss-cn-shanghai.aliyuncs.com/img/2020-12-26-XjNCAk.jpg)

历史订单界面

![img](https://billc.oss-cn-shanghai.aliyuncs.com/img/2020-12-26-ObLA8N.jpg)

支付界面

![UI payment](https://billc.oss-cn-shanghai.aliyuncs.com/img/2020-12-26-t5ahCn.jpg)

支付完成的消息提示

![img](https://billc.oss-cn-shanghai.aliyuncs.com/img/2020-12-26-X4YuW5.jpg)

航班查询界面

![img](https://billc.oss-cn-shanghai.aliyuncs.com/img/2020-12-26-JhaKA3.jpg)

订单信息界面

![img](https://billc.oss-cn-shanghai.aliyuncs.com/img/2020-12-26-LkVWKP.jpg)



 