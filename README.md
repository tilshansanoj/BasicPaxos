Basic Paxos Protocol

This project implements the Basic Paxos consensus mechanism using Java. A distributed algorithm used to achieve
among group of nodes.

Features
Connect Phase: Nodes establish connection to the central server.
Prepare Phase: Proposers send prepare messages, and Acceptors respond with promises.
Accept Phase: Proposers send Accept_Request messages, and Acceptors accept based on previous promises.
Consensus Phase: Once a proposer receives a majority of Accept messages, consensus is reached.

Design Choices

A central server for communication between nodes.(Server.java)
Nodes that act as both Proposers(Proposer.Java) and Acceptors(Acceptor.java)
Back-off mechanism and message delay handling contribute to the systems's robustness.

Prerequisities

Java Development Kit (JDK)

How to run the Code

You can simple run Main.java. Can change the parameters like no. of Proposers, time delay between messages or no of offline Nodes.

For further testing and details are covered in Testing.
