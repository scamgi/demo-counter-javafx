# demo-counter-javafx

This demo shows you how to create a MVC in JavaFX and connect it to a server using socket.

## How to get your IP address

Run this command on your terminal:

```sh
ifconfig | grep "inet "
```

Look for the inet address associated with your active network interface (likely en0 for Wi-Fi, en1 for Ethernet). Ignore 127.0.0.1 (that's the loopback address, only for your own machine). It will be a line similar to. 

```sh
inet 192.168.1.100 netmask 0xffffff00 broadcast 192.168.1.255
```

In this case, 192.168.1.100 is your IP.

Create a .env file and put:

```
SERVER_IP=192.168.1.100
```

## How to run everything

On the computer where you serve, run the `CounterServer.java` file, whereas on the client run `CounterClient.java`. To run them you can just run java from the terminal, or add a new configuration in IntelliJ (Application) and specify the class you want to run.

## Dependencies

In order to read the .env file, I've downloaded a dependency. Remember to use it if you copy this code in other repositories.