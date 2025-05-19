# Docker

![image-20240418164012763](https://cdn.jsdelivr.net/gh/chousinbin/Image/202404181640887.png)

# 镜像管理

### 镜像搜索

```bash
docker search [option] keyword
```

### 镜像拉取

```bash
docker pull 组名/镜像名:[TAG]
# 由于 Docker 官方提供的镜像都放在 library 组中，所以可以省略组
docker pull 镜像名
# TAG 默认为 latest
```

### 镜像查看列表

```bash
docker images
docker image ls
```

### 镜像详细信息

```bash
# 返回 JSON 格式的详细信息
docker inspect [ImageName]:[TAG]

# 筛选返回 Size
docker inspect -f {{".Size"}} [ImageName]:[TAG]
```

### 镜像历史

```bash
docker history [ImageName]:[TAG]
```

### 镜像删除

```bash
docker rmi [-f] 镜像名 / ID
docker image rm [-f] 镜像名 / ID
```

### 镜像清理

清理临时镜像缓存。

```bash
docker image prune
```

### 镜像导出

```bash
docker save [ImageName]:[TAG] > tarName.tar
docker save -o [ImageName]:[TAG] tarName.tar
```

也支持将多个镜像导出为一个 `tar` 包中。

### 镜像导入

```bash
docker load < tarName.tar
docker load -i tarName.tar
```

### 镜像添加标签



### 镜像上传仓库

```
docker push HubID / 仓库名
```



# 容器管理

### 容器启动

```bash
docker run -it 镜像名 /bin/bash
# -i 交互式操作
# -t 终端
```

### 