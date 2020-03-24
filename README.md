# WrenchFix

本插件修复了 工业扳手(包括电动扳手)加热力的储物箱可以无限刷物品的BUG

[B站BUG视频链接](https://www.bilibili.com/video/av98426479)

使用方法:

配置debug: true拿着扳手右键储物箱,获取储物箱方块ID和扳手ID

或者使用/itemdb获取扳手ID,创世神的/info获取方块id

填写到配置文件里面,重载插件即可

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

