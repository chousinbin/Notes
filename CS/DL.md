# DL

## 概念解释

### Anaconda

一个开源的包管理器和管理环境的平台。

### PyTorch

一种基于 Python 的开源深度学习框架，特点是动态计算图。

### YOLO

> You Only Look Once

用于物体检测方面的深度学习算法。特点是速度快，实时性好。物体检测视为回归问题，将分类和定位任务结合到单一神经网络中处理。

### CUDA

NVIDIA 的并行计算平台和编程模型，使用 CUDA 可以加快机器学习的速度。

### Numpy



### opencv



## PyTorch

### 数据解释

#### Dataset

学习的对象，数据的集合，学习资料是 images 和 labels。labels 记录图片中物品的位置矩阵和类别信息。

```shell
─data6k
    ├─test
    │  ├─images
    │  └─labels
    ├─train
    │  ├─images
    │  ├─jsons
    │  └─labels
    └─val
        ├─images
        ├─jsons
        └─labels
```

- train: 训练集，从中学习并训练模型；
- val: 验证集，每轮结束后，用于评估每轮训练的效果，使训练效果提高；
- test: 测试集，用于测试训练的模型的性能。测试集不必须有 labels。

```
class_id x_center y_center width height
```

#### Dataloader

将数据打包后分批次加载到模型之中，避免内存不足。

### TensorBoard

显示表和图，方便查看和分析训练过程中的数据信息。

## YOLOv5

> 目标检测模型

### 计算机视觉领域

#### 图片分类

- 输出每张图片类别信息
- 数据标注成本最便宜
- 产品缺陷检测、分类

#### 目标检测

- 能输出位置，每张图片输出 n * 5 条信息，n 为目标数
- 数据标注成本相对便宜
- 人脸跟踪

#### 语义分割

- 数据集标注耗费时间
- 输出图片，有精细的类别和边缘信息

### YOLO版本

- V5: 轻量，快速，适合嵌入
- V8: 大数据集