优质：https://github.com/JeffLi1993/springboot-learning-example
整合dubbo时最好把spring-boot-dev 依赖去掉,否则 会出现java.lang.ClassCastException: com.neo.service.UserService cannot be cast to com.neo.service.UserService 异常

### spring boot 整合dubbo
插件有两个：
- com.alibaba.spring.boot
  这个插件有点自有，除了需要引入基本的starter以外还要自己引入zk,和curator包以及logback包，配置如下:
  ```
   <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>${slf4j-api.version}</version>
        </dependency>

        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>${slf4j-api.version}</version>
        </dependency>
        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-classic</artifactId>
            <version>${logback.version}</version>
        </dependency>
        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-core</artifactId>
            <version>${logback.version}</version>
        </dependency>
        
        <dependency>
            <groupId>com.alibaba.spring.boot</groupId>
            <artifactId>dubbo-spring-boot-starter</artifactId>
            <version>2.0.0</version>
            <exclusions>
                <exclusion>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-actuator</artifactId>
                </exclusion>
                <exclusion>
                    <artifactId>spring-beans</artifactId>
                    <groupId>org.springframework</groupId>
                </exclusion>
                <exclusion>
                    <artifactId>spring-core</artifactId>
                    <groupId>org.springframework</groupId>
                </exclusion>
                <exclusion>
                    <artifactId>spring-context</artifactId>
                    <groupId>org.springframework</groupId>
                </exclusion>
            </exclusions>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
            <version>${spring.boot.version}</version>
        </dependency>

        <dependency>
            <groupId>com.101tec</groupId>
            <artifactId>zkclient</artifactId>
            <version>0.11</version>
        </dependency>

        <dependency>
            <groupId>org.apache.curator</groupId>
            <artifactId>curator-framework</artifactId>
            <version>2.12.0</version>
        </dependency
  ```
  dubbo配置如下：
  ```
   spring.dubbo.server=true
    spring.dubbo.application.name=SpringBootTest
    spring.dubbo.protocol.name=dubbo
    spring.dubbo.registry.address=10.255.72.159:2181
    spring.dubbo.registry.id=registry
    spring.dubbo.registry.protocol=zookeeper
    spring.dubbo.protocol.port=9300
    spring.dubbo.registry.group=zookeeper
  ```
  在启动类中需要加入  @EnableDubboConfiguration  
  在service 实现类中加入@Service (需要是dubbo的),和 @Compoment(不加的话,该类不会放在spring容器中,其他地方有使用的话会报错)
 
- io.dubbo.springboot
  相对上者要简单
  ```
      <dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <version>1.2.17</version>
        </dependency>

   <dependency>
            <groupId>io.dubbo.springboot</groupId>
            <artifactId>spring-boot-starter-dubbo</artifactId>
            <version>${dubbo-spring-boot}</version>
            <exclusions>
                <exclusion>
                    <artifactId>spring-boot-starter</artifactId>
                    <groupId>org.springframework.boot</groupId>
                </exclusion>
            </exclusions>
        </dependency>
  ```
  
  配置文件
  ```
    spring.dubbo.application.name=SpringBootTest
    spring.dubbo.registry.address=10.255.72.159:2181
    spring.dubbo.registry.protocol=zookeeper
    spring.dubbo.registry.group=zookeeper
    spring.dubbo.protocol.name=dubbo
    spring.dubbo.protocol.port=9300
    #scan选项在生产者方面配置的应该是实现类的包名,消费者配置的应该是使用类的包名
    spring.dubbo.scan=com.xcn.springboottest.dubbo
  ```
   在service 实现类中加入@Service
  