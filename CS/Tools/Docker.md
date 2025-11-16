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

# 自定义镜像

## 准备工作

### 创建项目目录

创建容器目录，后面终端命令全部在容器目录执行

```shell
mkdir ~/ml_project_docker
cd ~/ml_project_docker
```

### 编写 Dockerfile

```dockerfile
# 使用官方 Anaconda 基础镜像
FROM continuumio/anaconda3:latest

# 设置工作目录
WORKDIR /app

# 复制你的 requirements.txt 到容器中
# 如果你没有 requirements.txt，可以跳过这一步，直接在容器内安装
COPY requirements.txt .

# 安装 Python 依赖
# 使用 conda 安装，因为基础镜像是 Anaconda
RUN conda install --yes --file requirements.txt
RUN conda clean --all -f -y

# 或者，如果你想使用 pip，确保 conda 环境中安装了 pip
# RUN pip install -r requirements.txt

# 暴露 Jupyter Lab 端口 (如果你打算在容器内运行 Jupyter Lab)
EXPOSE 8888

# 定义容器启动时默认执行的命令
# 这里我们不设置默认命令，让用户手动进入容器或运行特定服务
# CMD ["jupyter", "lab", "--port=8888", "--no-browser", "--ip=0.0.0.0", "--allow-root"]
```

### requirements.txt

```txt
numpy
pandas
scikit-learn
matplotlib
jupyterlab
tensorflow==2.10.0 # 示例，根据你的课程需要指定版本
keras
```

### docker-compose.yml

```yml
version: '3.8'
services:
  ml_env:
    build: . # 指示 Docker 从当前目录的 Dockerfile 构建镜像
    ports:
      - "8888:8888" # 将容器的 8888 端口映射到 macOS 的 8888 端口，用于 Jupyter Lab
    volumes:
      - ./notebooks:/app/notebooks # 将 macOS 本地的 notebooks 文件夹挂载到容器的 /app/notebooks
      - ./data:/app/data           # 将 macOS 本地的 data 文件夹挂载到容器的 /app/data
    command: jupyter lab --port=8888 --no-browser --ip=0.0.0.0 --allow-root # 容器启动时自动运行 Jupyter Lab
    # 如果你不想自动启动 Jupyter Lab，可以注释掉上面这行，然后手动进入容器
    container_name: my_ml_container # 给容器一个易于识别的名称
```

## 构建镜像

```shell
docker build -t my-ml-image .
```

- `-t my-ml-image`: 给你的镜像一个名称（`my-ml-image`）。
- `.`: 表示 Dockerfile 在当前目录。

## 运行容器

### run

```shell
docker run -it --rm -p 8888:8888 -v ~/ml_project_docker/notebooks:/app/notebooks -v ~/ml_project_docker/data:/app/data --name my_ml_container my-ml-image /bin/bash
```

- `-it`: 交互式伪终端，让你能进入容器的 shell。
- `--rm`: 容器停止后自动删除。
- `-p 8888:8888`: 端口映射。
- `-v ...`: 卷挂载。
- `--name my_ml_container`: 给容器命名。
- `my-ml-image`: 你刚刚构建的镜像名称。
- `/bin/bash`: 容器启动后执行的命令，这里是进入 bash shell。

### compose

```shell
docker compose up -d
```

- `up`: 启动服务。
- `-d`: 后台运行（detached mode）。

这会根据 `docker-compose.yml` 文件启动你的 `ml_env` 服务。

## 进入容器

### 终端

无论你使用 `docker run` 还是 `docker compose up -d` 启动了容器，你都可以通过以下命令进入容器的 shell：

```shell
docker exec -it my_ml_container /bin/bash
```

- `my_ml_container`: 你容器的名称（在 `docker run` 或 `docker-compose.yml` 中定义的）。

进入容器后，你就像在一个独立的 Linux 系统中一样：

- 你可以直接运行 `python`。
- 你可以运行 `jupyter lab` (如果之前没有自动启动)。
- 你可以使用 `conda` 命令管理环境（尽管我们已经在 Dockerfile 中安装了所有依赖）。
- 你的 macOS 本地 `notebooks` 和 `data` 文件夹的内容会在容器的 `/app/notebooks` 和 `/app/data` 中可见。

### Jupyter Lab

如果你在 `docker-compose.yml` 中没有设置 `command` 自动启动 Jupyter Lab，或者你使用 `docker run` 启动，你需要手动在容器内启动 Jupyter Lab。

首先，通过 `docker exec -it my_ml_container /bin/bash` 进入容器。 然后，在容器的终端中运行：

```shell
jupyter lab --port=8888 --no-browser --ip=0.0.0.0 --allow-root
```

- `-port=8888`: 指定端口。
- `--no-browser`: 不自动在容器内打开浏览器。
- `--ip=0.0.0.0`: 允许从任何 IP 访问（对于 Docker 容器是必要的）。
- `--allow-root`: 如果你在容器内以 root 用户运行，可能需要这个。

Jupyter Lab 启动后，它会输出一个 URL，其中包含一个 token。 例如：`http://127.0.0.1:8888/?token=xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx`

在你的 macOS 浏览器中打开这个 URL (将 `127.0.0.1` 替换为 `localhost` 或直接使用它)，你就可以访问容器内的 Jupyter Lab 环境了。

### IDE

这是最优雅的开发方式，你可以在 macOS 本地使用你熟悉的 IDE，但代码执行和调试都在 Docker 容器中进行。

**以 VS Code 为例：**

1. **安装 VS Code 扩展：**
   - 在 VS Code 中，安装 `Remote - Containers` 扩展 (Microsoft)。
2. **打开项目文件夹：**
   - 在 VS Code 中，打开你的 `~/ml_project_docker` 文件夹。
3. **重新打开在容器中：**
   - 点击 VS Code 左下角的绿色远程图标（或按 `Cmd+Shift+P` 搜索 `Remote-Containers: Reopen in Container`）。
   - VS Code 会检测到你的 `Dockerfile` 或 `docker-compose.yml`，并询问你是否要在容器中打开。选择“From Docker Compose”或“From Dockerfile”。
   - VS Code 会自动构建或启动容器，并将你的工作区挂载到容器中。
4. **在容器中开发：**
   - 一旦连接成功，VS Code 的终端会直接连接到容器内部。
   - 你可以像在本地一样编辑文件，运行 Python 代码，调试，所有操作都在 Docker 容器的环境中进行。
   - VS Code 会自动识别容器内的 Python 解释器。

