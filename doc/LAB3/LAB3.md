## 进一步分析

我们在分析文档中已经详细分析了各个部分的之间的关系，并且得到了领域模型，如下图所示：

![Domain Model](https://billc.oss-cn-shanghai.aliyuncs.com/img/2020-12-26-Z7nrjA.png)

### GRASP

领域模型中每个模型的具体含义在分析文档中已有详细叙述，这里不再重复。基于领域模型的设计，在这个基础上，基于 GRASP 原则，我们进一步做出了如下修改：

#### Information Expert

根据 nformation Expert 原则，我们给每一个操作确定执行所在的类的时候，根据这个类是否包含这个操作所要执行的所有信息来决定。例如 UserController 包含了所有登陆Login和登出Logout所需要的信息，所以登陆和登出操作会在 UserController 中执行；例如FlightSystemFacade包含了通过机场查询可用航班 getAvailableFlightByAirports 所需要的所有信息，所以操作 getAvailableFlightByAirports 会在类FlightSystemFacade 中实现。

#### Creator

根据 GRASP 中的 Creator 原则，我们的前端类 View 包含了对应的类 Controller ，而且 View 应该能够初始化 Controller 的数据并在创建类 Controller 的实例时将数据传递给类 Controller ，并且类 View 会频繁的使用 Controller 。基于这样的问题，我们认为类 Controller 是对应的类 Controller 的创造者，所以我们设计中每个 View 都会包含 Controller。

#### Low Coupling

根据 GRASP 中的 Low Coupling 原则，我们为了保证低耦合，也就是所谓需求变更或者系统更改产生的影响，我们将所有的类进行功能划分：Mapper 负责对接数据库、Controller 负责具体的控制、Model 负责建立基本的模型、View 负责创建前端。同时我们采用了 Information Expert 模式来做到低耦合。

#### Controller

根据 GRASP 中的 Controller 原则，我们设计过程中将不同的类根据功能拆分，形成分层的状态。根据 GRASP 中的 Controller 原则，一个类完成的功能不要太多，且这些功能都是同级别的。所以我们尽可能的使得每一个类所承担的操作减少，所以根据功能和负责对接的部分，将不同的类拆分成不同指责。

于是，我们得到了具体的类图，如下图所示（为了增加类图的可读性，我们省略了部分显然的且没有很大意义的关联关系，并经过了整理）：

![Class Diagram Rotated](https://billc.oss-cn-shanghai.aliyuncs.com/img/2020-12-26-tW8ejJ.png)

受限于篇幅，我们同时提交了本图片的源文件。

### 用例分析

#### Start Up Use Case

在系统开启时的用例流程如下所示：

| Key            | Value                                                        |
| -------------- | ------------------------------------------------------------ |
| 用例名称       | 系统开启                                                     |
| 简要描述       | 该用例描述了顾客打开本系统，由此本系统进行初始化的信息       |
| 范围           | 用户目标                                                     |
| 主要参与者     | 用户                                                         |
| 涉及及其关注点 | 用户：能够正常的开启系统并使用，在此基础上，尽可能地方便     |
| 前置条件       | 用户需要在MaxOS操作系统下打开本系统，保持 Java 版本最新以及网络通畅。<br>用户应该具备一个可以登录进系统的有效账号。 |
| 后置条件       | 系统成功启动，和数据库建立连接。                             |
| 基本流程       | 用户在 MacOS 操作系统中，打开系统<br>本系统调用相关文件，完成系统页面初始化<br>本系统通过网络连接上航班数据库<br>本系统正常打开，用户可以进行任意允许的操作 |
| 替代流程       | **系统没有找到初始化界面的相关文件**：<br>1. 系统提示用户系统文件缺失<br>2. 待用户确认完成后，系统自动关闭<br>**系统没有联网**<br>1.系统提示用户“请保持网络连接正常”<br>2.带用户确认完成后，重新检查网络是否顺利<br>3.如果网络通畅，继续回到主流程继续开启系统 |
| 特殊需求       | 无                                                           |
| 拓展点         | 无                                                           |

#### 其他用例

在分析阶段，就完成了包含基本需求的用例图，如下如所示：

![Use Case Diagram](https://billc.oss-cn-shanghai.aliyuncs.com/img/2020-12-26-whFeEV.png)

现在，我们根据这些需求，对其中一些重要的用例进行了详细的流程设计

##### Flight Reservation

![Collaboration1!Interaction1!Flight Reservation_2](https://billc.oss-cn-shanghai.aliyuncs.com/img/2020-12-26-uOKKTv.png)

##### Cancel Reservation

![Collaboration3!Interaction1!cancelReservation_3](https://billc.oss-cn-shanghai.aliyuncs.com/img/2020-12-26-1I0IUI.png)

##### Check Previous Passenger![Collaboration4!Interaction1!CheckPreviousPassenger](https://billc.oss-cn-shanghai.aliyuncs.com/img/2020-12-26-SbLo5x.png)

##### Add Passenger

![Collaboration5!Interaction1!Addpassenger](https://billc.oss-cn-shanghai.aliyuncs.com/img/2020-12-26-dHmsNh.png)

##### Check Previous Reservation

![Collaboration4!Interaction1!CheckPreviousPassenger](https://billc.oss-cn-shanghai.aliyuncs.com/img/2020-12-26-3rHNIw.png)

 ## 系统设计

接下来我们开始对项目进行了具体的实现。

- 为了最好地实现面向对象特性，采用 Java 语言来编写本系统。
- 使用 Java Swing 作为 GUI 框架并用 JFormDesigner 设计前端交互界面。
- 使用 MVC 架构，在 Model 层利用 MyBatis 自动注入 Mapper 并生成和数据库沟通的接口。在 Controller 层引入 Mapper，同时接管 View 层的用户事件，对数据库作出更改并将效果展示在 UI 层上。
- 我们使用 `lombook` 对 Model、Controller 等注入 Setter 和 Getter 方法生成 Bean，使 Mode 更加易于使用、简化工作量
- 利用 Spring Boot 来管理系统的上下文环境，动态处理 Component 的构造和析构，提高性能。

### 数据库设计 

根据我们得到的类图，为了能够持久化地存储数据，首先使用 MySQL 建立数据库。数据库中一共包含八个数据表：

1. 机场 airport，包含机场所在的城市、机场名称和代码
2. 航班 flight，包含航班具体执行的日期
3. 航班描述 flight_description，包含航班的编号、执行飞机、起飞和降落的机场、起飞时间和航程时间
4. 座位 seat，包含座位的类型、原始价格和剩余座位数量
5. 订单 reservation，包含订单创建的日期，同时关联支付方式、乘客、航班和座位
6. 用户 user，是订单的创建者
7. 乘客 passenger，是订单的使用者

建立数据库后得到的 ER 图图下图所示：

![ER Database](https://billc.oss-cn-shanghai.aliyuncs.com/img/2020-12-26-ifI3VD.png)

### 主要类设计

基于 MVC 架构，我们将该系统分为 6 个包。分别为 `Model`，`Mapper`， `Controller`，`View`， `Utils`，`Core`。

#### Model

图中展示了8个类：乘客模型 `PassengerModel`、订单模型 `ReservationModel`、航班描述模型`FlightReservationModel`、用户模型 `UserModel` 、座位模型 `SeatModel`、支付模型 `PaymentModel`、机场模型 `AirportModel`和航班模型 `FlightModel` ，图中包括他们的属性。

![Java ClassModel](https://billc.oss-cn-shanghai.aliyuncs.com/img/2020-12-26-5TABtg.jpg)

#### Mapper

根据之前设计的数据库，我们设计编写了和数据库对接的类，并命名为 Mapper，存储在 Mapper 包中：

![Java Mapper](https://billc.oss-cn-shanghai.aliyuncs.com/img/2020-12-26-0lXZAO.jpg)

#### Controller

根据上面类图的设计，我们从之前编写的 Model 类继承，编写得到了 Controller 部分，具体的如下图所示：

![image-20201226164858886](https://billc.oss-cn-shanghai.aliyuncs.com/img/2020-12-26-LRNXuA.png)

在 View 层除了直接接入 Controller 层使用对应的 Controller 之外，我们还设计了一个系统门面 `FlightSystemFacade`，用来处理需要接入多个 Controller 才能实现的频繁操作，进一步封装了一个整合系统的若干接口，如根据机场代码查询机场等。

#### View

最后，使用 Java Swing 构建本系统交互界面，存储在 View Package 中：

![image-20201226164736663](https://billc.oss-cn-shanghai.aliyuncs.com/img/2020-12-26-zuMFQw.png)

`PlaneReservationGUI` 作为启动的第一个 JFrame，会引入 `MainPanel`

#### Core

因为项目的设计不涉及到真实的金额支付，我们在设计初期就设计了多种支付方式：微信支付WechatPay、支付宝支付 Alipay、银行转帐 BankTransfer，所以我们也创建了对应的类，来模拟支付这一过程，而在真实应用中，可以直接通过我们已经完成的类增设接口来完成实际的交易。此外，还有 Other Payment 用来指定未知的交易方法。

![Java Payment](https://billc.oss-cn-shanghai.aliyuncs.com/img/2020-12-26-VtIoTe.jpg)

此外，后期关于折扣策略 Discount Strategy、系统意外处理等功能也将在 Core Package 中实现。

#### Utils

该包内包含了系统中复用性较高的工具类。主要方法如下：

![image-20201226165001487](https://billc.oss-cn-shanghai.aliyuncs.com/img/2020-12-26-VmVw6U.png)

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



 