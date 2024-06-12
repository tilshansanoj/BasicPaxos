# Testing

Here are some of the proposed tests for the system. Breaking points include the situations where:
1. No proposers are online to respond to acceptors.
2. Not enough Accpetors are responsive for the system to reach a consensus.

Here are some situations where the system will be able to handle but are more complicated include:
1. Proposers with highest initial ID_p proposes then goes offline (run_Test2_offline1)
2. The delay between messages is so large that a poorly thought out system might never reach consensus as new proposals will happen before consensus is reached causing the process to restart (run_largedelay)
3. A significant number of acceptors are offline but not more then half, a poorly thought out system might never reach consensus if messages get lost. (run_Test1_noResponse3)

## Tests

### run_Main
This test runs the system with 3 proposers and no delay or offline proposers, as ID_p is initially correlated to by name (M-1 = 1, M-2 = 2, M-3 = 3) and there is no delay or offline proposers, the system should reach consensus with M-3 being elected.
to run this test: 
### run_Test1
This test runs the system with 1 proposers and no delay or offline proposers, the system should reach consensus with M-1 being elected, as it is the only proposer.

### run_Test1_smalldelay
This test runs the system with 1 proposers, a small delay and no offline proposers, the system should reach consensus with M-1 being elected, as it is the only proposer.

### run_Test1_largedelay
This test runs the system with 1 proposers, a large delay and no offline proposers, the system should reach consensus with M-1 being elected, as it is the only proposer.

### run_Test1_noResponse1
This test runs the system with 1 proposers, no response from 1 acceptor and no offline proposers, the system should reach consensus with M-1 being elected, as it is the only proposer and 1 unresponsive acceptor will not prevent M-1 from receiving n/2+1 accepts.

### run_Test1_noResponse3
This test runs the system with 1 proposers, no response from 3 acceptors and no offline proposers, the system should reach consensus with M-1 being elected, as it is the only proposer and 3 unresponsive acceptors will not prevent M-1 from receiving n/2+1 accepts (7 total, therefore needs 4);

### run_Test1_noResponse4
Notable: This test is not expected to reach consensus.
This test runs the system with 1 proposers, no response from 4 acceptors and no offline proposers, the system should not reach consensus, as 4 unresponsive acceptors will prevent M-1 from receiving n/2+1 accepts (7 total, therefore needs 4 only gets 3). Hence it will run forever as M-1 continues to make new proposals but does not receive a majority consensus.

### run_Test1_offline1
Notable: This test is not expected to reach consensus.
This test runs the system with 1 proposers, 6 acceptors and 1 offline proposers, the system should not reach consensus, as M-1 will go offline after sending its first Prepare and hence will never respond to any promises. This test merely checks that offline works as intended within the system.

### run_Test2_offline1
This test runs the system with 2 proposers, 6 acceptors and 1 offline proposers, the system should reach consensus, as although M-2 will go offline after sending its first Prepare M-1 will send its prepare which will be of a lower ID_p then M-2's so it will not initially receive many promises, when M-1 sends its second prepare with a larger ID_p it will receive its promises Hence the system will reach consensus M-1.

### run_smalldelay
This runs the system with 3 proposers, a small delay and no offline proposers, the system should reach consensus with M-3 being elected, as it has the largest proposal number.

### run_largedelay
This runs the system with 3 proposers, a large delay and no offline proposers, the system should reach consensus with M-3 being elected, as it has the largest proposal number.

### run_offline1
This test runs the system with 3 proposers, 6 acceptors and 1 offline proposers, the system should reach consensus, as although M-3 will go offline after sending their first Prepare M-1 and M-2 will send their Prepare which will be of a lower ID_p then M-3's so they will not initially receive many promises, when M-2 sends its second prepare with a larger ID_p it will receive its promises Hence the system will reach consensus M-2.

### run_offline2
This test runs the system with 3 proposers, 6 acceptors and 2 offline proposers, the system should reach consensus, as although M-3 and M-2 will go offline after sending their first Prepare M-1 will send their Prepare which will be of a lower ID_p then M-3's or M-2's so they will not initially receive many promises, when M-1 sends its second prepare with a larger ID_p it will receive its promises Hence the system will reach consensus M-1.

