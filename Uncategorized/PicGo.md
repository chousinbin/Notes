# Github图床

![image-20220807225452369](https://cdn.jsdelivr.net/gh/chousinbin/Image/Picgo%E9%85%8D%E7%BD%AE.png)

## token获取方法

Github-setting-Personal access tokens-新建-期限永久-勾选repo-复制

## CDN加速

https://cdn.jsdelivr.net/gh/username/repo

## 配置文件

```json
 "github": {
    "branch": "master",
    "customUrl": "https://cdn.jsdelivr.net/gh/chousinbin/Image",
    "path": "",
    "repo": "chousinbin/Image",
    "token": "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"
}
```

## 443 timeout

在PicGO里面手动配置代理

![image-20240124161901946](https://cdn.jsdelivr.net/gh/chousinbin/Image/202401241619980.png)

## MacOS 安装后提示文件损坏

下载之后直接安装即可，此时打开会报错：Picgo.app 文件已损坏，您应该将它移到废纸篓。

这是因为 macOS 为了保护用户不受恶意软件的攻击，macOS 会阻止安装未经过苹果认证的应用程序。

此时只需要在命令行中执行一个命令即可：

```bash
sudo xattr -d com.apple.quarantine "/Applications/PicGo.app"
```

执行完成后，再打开 Picgo.app 就可以正常使用了。

https://tendcode.com/subject/article/PicGo-for-mac/

