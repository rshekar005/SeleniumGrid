
~~~What is Selenium Grid?
The Selenium Grid is a concept which allows us to run our tests on different machines against different browsers. It is a part of the Selenium Suite which specialise in running multiple tests across different browsers, operating system and machines. You can connect to it with Selenium Remote by specifying the browser, browser version, and operating system you want. You specify these values through Selenium Remote’s Capabilities.


using Grid we can achieve cross browser testing and cross platform testing

There are two main elements to Selenium Grid — a hub, and nodes.

~~~What is a Hub?

In Selenium Grid, the hub is a computer which is the central point where we can load our tests into. Hub also acts as a server because of which it acts as a central point to control the network of Test machines. The Selenium Grid has only one hub and it is the master of the network. When a test with given DesiredCapabilities is given to Hub, the Hub searches for the node witch matches the given configuration. For example, you can say that you want to run the test on Windows 10 and on Chrome browser with verision XXX. Hub will try to find a machine in the Grid which matches the criterion and will run the test on that Machine. If there is no match, then hub returns an error. There should be only one hub in a Grid.

~~~What is a Node?

In Selenium Grid, a node is referred to a Test Machine which opts to connect with the Hub. This test machine will be used by Hub to run tests on. A Grid network can have multiple nodes. A node is supposed to have different platforms i.e. different operating system and browsers. The node does not need the same platform for running as that of hub.

~~~How it works?

First you need to create a hub. Then you can connect (or “register”) nodes to that hub. Nodes are where your tests will run, and the hub is responsible for making sure your tests end up on the right one (e.g., the machine with the operating system and browser you specified in your test).


1 Hub with Multiple nodes

communication from Hub to node will happen as JSON protocol and sends HTTP requests.

We won't bother about OS in hub. We should know node OS.

Example:
Nodes as below browsers
VM1 -- chrome version 31, firefox version 52  , IE version 9  -- Windows OS
VM2 -- chrome version 32, firefox version 53, IE version 10    -- MAC OS
VM3 -- chrome , firefox , IE -- Linux OS

In JAVA Code need to written, we need to set desiredCapabilities which tells in which browser, browser version and OS test case need to run.

RemoteWebDriver is a class which is used to run test cases remotely.
We won't need to write chromeDriver, Webdriver in code. In this case need to use RemoteWebDriver, it will take care of driver initilization.


Note: Make sure selenium server Jar file should present in both the machines with same version

Steps:
1. Start the server
E:\Drivers>java -jar selenium-server-standalone-3.141.59.jar -role hub  -- Create a server
2. Register a node to the server.
Command to create a node in hub machine or different machine. But make sure that Java and drivers should present in node machine

java -Dwebdriver.chrome.driver=chromedriver.exe -jar selenium-server-standalone-3.141.59.jar -role node -hub http://192.168.0.19:4444
java -Dwebdriver.gecko.driver=geckodriver.exe -jar selenium-server-standalone-3.141.59.jar -role node -hub http://192.168.0.19:4444

Selenium Grid Status -- http://localhost:4444/status It will have the all node and hub status.


Selenium Grid 4:

Three Components:
1. Standalone  -- All the hub and nodes will present here and test cases will run in same machine
    Command-- java -jar selenium-server-4.0.0-alpha-6.jar standalone
	
2. hub and node -- Old Traditional method.
    Commands
	1. java -jar selenium-server-4.0.0-alpha-6.jar hub  -- Here it will start the hub machine
	2. java -jar selenium-server-4.0.0-alpha-6.jar node -- It will create a node in currect machine
		java -jar selenium-server-4.0.0-alpha-6.jar node --detect-drivers  --WHich is used to detect drivers in current path
	3. If you wish to run the hub and the node on different machines, start the node with:
		java -jar selenium-server-4.0.0-alpha-1.jar node --detect-drivers --publish-events tcp://hub:4442 --subscribe-events tcp://hub:4443
		
		here hub should be replaced with Ip address of hub and port is default 4442 and 4443
		Example:
		java -jar selenium-server-4.0.0-alpha-1.jar node --detect-drivers --publish-events tcp://192.168.0.19:4442 --subscribe-events tcp://192.168.0.19:4443


3. Distributed.

	    Pending


