# Java SE 学习练习（oop）

本目录保存面向对象、常用 API、集合、异常、文件操作和学生管理系统练习。代码是学习过程记录，不代表全部示例均已完成或具备生产环境要求。

## 运行环境
- JDK 25；部分练习使用无参 main 等入口形式，请勿用较旧 JDK 直接判断语法。
- IntelliJ IDEA：将 src 设置为源码根目录，项目 SDK 设置为 JDK 25，按类单独运行。
- 日志练习使用 lib/commons-logging-1.4.0.jar，在需要时添加为模块依赖。
- 有些文件练习使用本机绝对路径，运行前按自己的目录调整；相对路径基于运行工作目录。

## 练习入口
- [集合与 List 接口](src/com/Silas/API/collection/ListInterfaceDemo.java)
- [ArrayList 整数删除重载](src/com/Silas/API/ArrayList/BasicDemo1.java)
- [文件与多名学生解析](src/com/Silas/Files/multiInfoFiles/Main.java)
- [学生管理系统入口](src/com/Silas/StudentManagementSystem/Main.java)
- [菜单与持久化流程](src/com/Silas/StudentManagementSystem/Menu.java)
- [加载与保存方法](src/com/Silas/StudentManagementSystem/StudentFileStore.java)

## 数据与提交范围
- 保留源码、文件练习的演示文本和已有日志依赖。
- 不提交 .idea、out、class、iml 和学生管理系统本地 Student*.txt 数据。
- 学生管理系统在数据文件不存在、父目录存在时，可通过菜单添加并保存演示学生。
- 登录校验练习中的公开演示口令是 DemoOnly_123!，不得作为真实凭据使用。
- 用户登录数据仍只存内存；文件保存功能当前只覆盖学生数据。
- 日期记录、笔记和验收范围以 Obsidian 主题笔记为准。代码链接可使用本提交永久链接保留学习时点。
