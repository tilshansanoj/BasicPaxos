package Class;

import java.net.Socket;

public interface Role {
    int Promise(int responseIDp, int acceptedProposalNumber, String acceptedProposalValue, Socket socket, String name);

    String Accept(int acceptedProposalNumber, int responseIDp, String acceptedProposalValue, String responseValue, Socket socket, String name);

    void Connect(int proposalNo, Socket socket, String name);
}
