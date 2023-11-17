## Github图床

![image-20220807225452369](https://cdn.jsdelivr.net/gh/chousinbin/Image/Picgo%E9%85%8D%E7%BD%AE.png)

#### token获取方法

Github-setting-Personal access tokens-新建-期限永久-勾选repo-复制

#### CDN加速

https://cdn.jsdelivr.net/gh/username/repo



#### 配置文件

```json
{
  "picBed": {
    "current": "github",
    "uploader": "github",
    "smms": {
      "token": ""
    },
    "github": {
      "branch": "master",
      "customUrl": "https://cdn.jsdelivr.net/gh/chousinbin/Image",
      "path": "",
      "repo": "chousinbin/Image",
      "token": "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"
    },
    "list": [
      {
        "name": "SM.MS图床",
        "type": "smms",
        "visible": false
      },
      {
        "name": "腾讯云COS",
        "type": "tcyun",
        "visible": false
      },
      {
        "name": "GitHub图床",
        "type": "github",
        "visible": true
      },
      {
        "name": "七牛图床",
        "type": "qiniu",
        "visible": false
      },
      {
        "name": "Imgur图床",
        "type": "imgur",
        "visible": false
      },
      {
        "name": "阿里云OSS",
        "type": "aliyun",
        "visible": false
      },
      {
        "name": "又拍云图床",
        "type": "upyun",
        "visible": false
      }
    ]
  },
  "settings": {
    "shortKey": {
      "picgo:upload": {
        "enable": true,
        "key": "Alt+P",
        "name": "upload",
        "label": "快捷上传"
      }
    },
    "server": {
      "port": 36677,
      "host": "127.0.0.1",
      "enable": true
    },
    "privacyEnsure": true,
    "showUpdateTip": false,
    "rename": false,
    "autoStart": true,
    "autoRename": true
  },
  "picgoPlugins": {},
  "debug": true,
  "PICGO_ENV": "GUI",
  "needReload": false
}
```

