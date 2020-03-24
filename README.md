# WrenchFix

本插件修复了 工业扳手(包括电动扳手)加热力的储物箱可以无限刷物品的BUG

[B站BUG视频链接](https://www.bilibili.com/video/av98426479)

配置文件:

```
Option: 
  debug: false
  method: default/warn/kick/ban 四选一,默认就是仅阻止,不做其他操作
  id:
    wrench: 4226,4227,4238 扳手的id
    chest: 346 储物箱的方块id(不是物品ID,放置在地上时候的ID)
Message:
  warn: '[§aWrenchFix§f]检测到你正在你用扳手刷物品bug,你已被警告'
  kick: '[§aWrenchFix§f]检测到你正在你用扳手刷物品bug,你已被kick'
  ban: '[§aWrenchFix§f]检测到你正在你用扳手刷物品bug,你已被ban'
```
