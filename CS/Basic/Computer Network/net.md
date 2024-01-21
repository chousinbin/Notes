# 01x00 computer network and the internet

## 01x01 what is internet

The **Internet** is a computer network that interconnects millions of computing devices throughout the world.

$internet \in computer\ network\in network$

### function

1. resource sharing 
2. date communication

### nuts and bolts view

- hosts(end systems), running network apps
- communication links, transmission rate = bandwidth
- packet switches: router and switches
- end system access the internet through ISP(internet service provider)

### a service view

- communication infrastructure
- communication services

### protocol

A protocol defines the format and the order of messages exchanged between two or more communicating entities as well as the actions taken on the transmission and/or receipt of a message or other event

1. syntax语法
2. semantics语义
3. timing时序

Protocols  controlling the sending and receiving of information within the Internet. 

## 01x02 the network edge

### applications and hosts

### access network

access network connect end systems to edge router

#### residential access住宅接入

1. dialup via modem: up to 56Kbps direct access to router, can't surf phone at same time
2. DSL(digital subscriber line): ADSL非对称数字用户, can use phone and network at same time, **dedicated access**
3. cable电缆: FDM, **shared access**, HFC

#### enterprise access企业接入

LAN局域网

#### wireless access无线接入

1. wireless LANs: within building
2. wide-area wireless access: 4G

### physical media

#### guided media

signals propagate in solid media

1. twisted pair: UTP非屏蔽式, STP屏蔽式
2. coaxial: 同轴电缆, two concentric copper conductors
3. fiber光纤

#### unguided media

signals propagate in the atmosphere and in outer space

radio

1. terrestrial microwave地面微波
2. LAN: wifi
3. wide-area: cellular蜂窝网络
4. satellite: 卫星

## 01x03 network core

### circuit switching电路交换

#### three phase

1. call setup
2. date transfer
3. circuit teardown

#### dedicated resources

no sharing and cut-through直通

network resources divided into pieces片

resource piece idle闲置, if not use by owning call

#### multiplexing

多路复用: 一条通道分为多个单独的子通道

1. FDM: The frequency spectrum of a link is divided up among the connections established across the link.
2. TDM: time is divided into frames of fixed duration,and each frame is divided into a fixed number of time slots.

### message switching报文交换

### packet-switching分组交换

share network resource

date stream divided into packet

full link bandwidth

use the resources on demand

#### store and forward transmission

the switch must receive the entire packet before it can begin to transmit the first bit of the packet onto the outbound link.

1. store and forward delay
2. packet queue, wait for use
3. packet loss

### circuit VS packet

| circuit                         | packet                      |
| ------------------------------- | --------------------------- |
| pre-allocate resource           | allocate resource on demand |
| cut-through                     | store and forward           |
| dedicated bandwidth             | sharing of bandwidth        |
| suitable for real time services | not suitable for real time  |
| telephone net                   | internet                    |

## 01x04 Delay and Loss in Packet-Switched Networks

### nodal processing

- examining the packet's header and determine where to direct the packet
- check bit errors

### queueing

- time waiting to be transmitted onto the link
- depends on congestion level of router

traffic intensity = La / R < 1

a = average packet arrival rate

### transmission delay

- time required to push all of the packet's bits into the link
- R=link bandwidth (bps)
- L=packet length (bits)
- time to send bits into link = L/R

### propagation

- time required to propagate from the beginning of the link to next router (or host)
- d = length of physical link
- s = propagation speed in medium ($~2×10^8$ m/sec)
- propagation delay = d/s

### nodal delay

$d_{nodal} = d_{proc} + d_{queue} + d_{trans} + d_{prop}$

$d_{end-end} = n(d_{proc} + d_{queue} + d_{trans} + d_{prop})$, n = the number of links

(N + Q - 1)L / R, Q = links, N = packets

<img src="https://cdn.jsdelivr.net/gh/chousinbin/Image/202401061803000.png" alt="image-20240106180347922" style="zoom:50%;" />

### packet loss

- queue (aka buffer)preceding link in buffer has finite capacity
- packet arriving to full queue dropped (aka lost)
- lost packet may be retransmitted by previous node,by source end system,or not at all

## 01x05 Protocol Layers and their service models

| name        | PDU      |
| ----------- | -------- |
| application | message  |
| transport   | segment  |
| network     | datagram |
| link        | frame    |
| physical    | -        |

### layers

each layer implements a service

using the services of the layer directly below it

performing certain actions within that layer

# 02x00 application

## 02x01 principle

### application architecture

- CS
- p2p
- hybrid of CS & P2P

### CS

#### server

- always on
- fixed well known IP
- server farms for scaling 用于扩展的服务器厂

#### client

- intermittently connected 间歇连接
- not communicate directly with others

#### example

- web, email, file transfer

### P2P

- no always on
- directly communicate
- peers are intermittently connected
- change IP
- highly scalable 高可扩展
- difficult to mange

#### example

Gnutella尼特拉

### hybrid

- between two user is P2P
- user tell its IP to central server
- user find other IP in central server

### processed communicate

within same host, two processes communicate using **inter-process communication** (defined by OS).

processes in different hosts communicate by **exchanging messages**\

Client process: process that initiates communication

Server process: process that waits to be contacted

### sockets

process sends/receives messages to/from its socket

| name | app protocol | port                                         |            | transfer protocol          |
| ---- | ------------ | -------------------------------------------- | ---------- | -------------------------- |
| web  | HTTP         | 80                                           |            | TCP                        |
| ftp  | FTP          | 21-control persistent, 20date non persistent |            | TCP                        |
| mail | SMTP         | 25                                           | persistent | TCP                        |
|      | POP          | 110                                          | stateless  | Download-and-keep, 不同步  |
|      | IMAP         | 143                                          | state      | all messages in server同步 |
| DNS  |              | 53                                           |            | UDP                        |
| P2P  |              |                                              |            |                            |

