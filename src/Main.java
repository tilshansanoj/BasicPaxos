import Class.*;
public class Main {

    private static void run_paxos(int proposers, int timeDelay, int offlineMembers)
    {
        Server server = new Server();
        Thread sthread = new Thread(server);
        sthread.start();
        try
        {
            Thread.sleep(2000); //give server time to start up
        } catch (InterruptedException e)
        {
            System.out.println("Error: Server Launch was interrupted");
        }

        for (int i = proposers; i < Config.Acceptors; i++)
        {
            Member member = new Member(Config.Acceptor, i, timeDelay, 0);
            timeDelay++;
            Thread mthread = new Thread(member);
            mthread.start();
        }

        for (int i = Config.Proposers-1; i >= 0 ; i--) // counts down so that M-2 and M-3 get marked as offline not M1
        {
            Member proposer = new Member(Config.Proposer, i, timeDelay, offlineMembers);
            offlineMembers--;
            Thread pthread = new Thread(proposer);
            pthread.start();
        }
    }

    public static void main(String[] args) {
//
        int proposers = 3;
        int timeDelay = 1000;
        int offlineMembers = 0;
        if (offlineMembers > 2)
        {
            offlineMembers = 2;
        }
        Config.Acceptors += proposers;
        Config.Proposers += proposers;
        run_paxos(proposers, timeDelay, offlineMembers);
    }


}