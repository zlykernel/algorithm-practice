## gitbook 根目录
## 基础
https://www.jianshu.com/p/191d1e21f7ed
* 标题
   * 在想要设置为标题的文字前面加#来表示
     一个#是一级标题，二个#是二级标题，以此类推。支持六级标题。
* 字体
   * 加粗 要加粗的文字左右分别用两个*号包起来
   * 斜体 要倾斜的文字左右分别用一个*号包起来
   * 斜体加粗 要倾斜和加粗的文字左右分别用三个*号包起来
   * 删除线 要加删除线的文字左右分别用两个~~号包起来
* 分割线
   * 三个或者三个以上的 - 或者 * 都可以。
* 图片
    * ![图片alt](图片地址 ''图片title'')
* 超链接
   * [超链接名](超链接地址 "超链接title")
* 列表
   * 无序列表用 - + * 任何一种都可以
   * 有序列表 数字加点
   * 列表嵌套 上一级和下一级之间敲三个空格即可
* 表格
   * 表头|表头|表头
     ---|:--:|---:
     内容|内容|内容
     内容|内容|内容
     
     第二行分割表头和内容。
     - 有一个就行，为了对齐，多加了几个
     文字默认居左
     -两边加：表示文字居中
     -右边加：表示文字居右
     注：原生的语法两边都要用 | 包起来。此处省略
* 代码
   * 单行代码：代码之间分别用一个反引号包起来
   * 代码块：代码之间分别用三个反引号包起来，且两边的反引号单独占一行
* 流程图

## 1.开发工具标准
### - 注释相关
File | Settings | Editor | Live Templates
* class
```
*
 * @author zhaoliangyuan
 * @version 1.0.0
 * @Description TODO
 * @createTime $time$ $date$
 */
```
* method
```
*
 * @Author zhaoliangyuan
 * @Description //TODO
 * @Date $time$ $date$
 * @Param $param$
 * @return $return$
 **/
```

File | Settings | Other Settings | Eclipse Code Formatter

### - Java代码规范
   * 工具插件
Alibaba Java Coding Guidelines plugin support.