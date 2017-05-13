package com.kitri.admin.server;

/*
 * programvalue/packet_type/data
 */
public class PacketInformation {
    
    static final byte PACKET_SIZE = 3;
    

    class ProgramValue {
	static final byte ADMIN = 0;
	static final byte USER = 1;
	static final byte PAYMENT = 2;
    }

    class PacketStructrue {
	static final byte PROGRAM_VALUE = 0;
	static final byte PACKET_TYPE = 1;
	static final byte DATA = 2;

    }

    class PacketType {
	static final byte POINT_INFO = 0;
	static final byte TIME_INFO = 1;
    }

}
