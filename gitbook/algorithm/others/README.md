 1. C 环境安装mingw-w64
https://sourceforge.net/projects/mingw-w64/files/mingw-w64/
https://sourceforge.net/projects/mingw-w64/files/Toolchains%20targetting%20Win32/Personal%20Builds/mingw-builds/installer/mingw-w64-install.exe

 2. gcc相关命令
 ```
 gcc hello.c -o hello       #一步到位编译
 gcc -E hello.c -o hello.i  #预处理

 ```

 3. 问题
    * printf乱码问题
    修改源码文件的编码格式与标准输出的编码格式一致 